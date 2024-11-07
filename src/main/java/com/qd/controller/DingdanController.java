package com.qd.controller;


import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.qd.common.result.ResultUtils;
import com.qd.entity.*;
import com.qd.service.IDingdanService;
import com.qd.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
@RestController
@RequestMapping("/dingdan")
public class DingdanController {
    @Autowired
    IDingdanService service;

    @GetMapping("/getList")
    public Object getList(DingdanDto orders){
        List<Dingdan> list =  service.getList(orders);
        orders.setPage(null);
        orders.setLimit(null);
        int total =  service.getList(orders).size();
        return ResultUtils.returnSuccessLayui(list,total);
    }


    /**
     * 修改
     * @param
     * @return
     */
    @PutMapping("/update")
    public Object update(@RequestBody Dingdan u){
        if(service.updateById(u)){
            return ResultUtils.returnDataSuccess(u);
        }
        return ResultUtils.returnFail("修改失败");
    }

    /**
     *添加
     */
    @PostMapping("/add")
    public Object add(@RequestBody Dingdan o){
        if(service.addOrderAndDetail(o)){
            return ResultUtils.returnDataSuccess(o);
        }
        return ResultUtils.returnFail("添加失败");
    }


   /**
    *订单和订单明细表量表联查
    **/
    @GetMapping("/getListFront")
    public Object getListFront(Integer tableId){
        MPJLambdaWrapper<Dingdan> wrapper = JoinWrappers.lambda(Dingdan.class)
                .selectAll(Dingdan.class)//查询订单表全部字段
                .selectCollection(OrderDetail.class,Dingdan::getOrderDetailList) //查询明细表中的数据
                .leftJoin(OrderDetail.class, OrderDetail::getOrdersId, Dingdan::getId); //两表连查的条件
        //指定桌号
        wrapper.eq("table_id",tableId);
        //按照订单时间倒序
        wrapper.orderByDesc("order_time");
        List<Dingdan> list = service.selectJoinList(Dingdan.class, wrapper);
        return ResultUtils.returnDataSuccess(list);
    }

}
