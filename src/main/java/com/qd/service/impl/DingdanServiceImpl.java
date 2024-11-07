package com.qd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.qd.entity.*;
import com.qd.mapper.CaipinMapper;
import com.qd.mapper.DingdanMapper;
import com.qd.mapper.OrderDetailMapper;
import com.qd.mapper.ShoppingCarMapper;
import com.qd.service.IDingdanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
@Service
public class DingdanServiceImpl extends MPJBaseServiceImpl<DingdanMapper, Dingdan> implements IDingdanService {


    @Autowired(required = false)
    DingdanMapper mapper;

    @Autowired(required = false)
    ShoppingCarMapper shoppingCarMapper;

    @Autowired(required = false)
    OrderDetailMapper orderDetailMapper;
    @Autowired(required = false)
    CaipinMapper caipinMapper;

    @Override
    public List<Dingdan> getList(DingdanDto orders) {
        return mapper.getList(orders);
    }

    @Override
    public boolean addOrderAndDetail(Dingdan o) {
        //1.插入到订单表
        int insert = mapper.insert(o);

        //2.批量插入多条到订单详情表
        //2.1根据餐桌id查询购物车清单
        List<ShoppingCar> list = shoppingCarMapper.getList(o.getTableId());

        //2.2循环插入到订单详情表中
        OrderDetail od = new OrderDetail();
        for (ShoppingCar c:list){
            od.setOrdersId(o.getId());
            od.setOrdersName(c.getCaipinName());
            od.setNumber(c.getNumber());
            od.setCaipinPhoto(c.getPhoto());
            od.setCaipinPrice(c.getPrice());
            orderDetailMapper.insert(od);

            Caipin product = caipinMapper.selectById(c.getPid());
            product.setYuexiao(product.getYuexiao()+c.getNumber());
            caipinMapper.updateById(product);
        }

        //3.删除该桌对应的购物车信息
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("tables_id",o.getTableId());
        int del = shoppingCarMapper.delete(queryWrapper);

        if (insert>0 && del>0){
            return true;
        }
        return false;
    }
}
