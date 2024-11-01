package com.qd.service.impl;

import com.qd.entity.ShoppingCar;
import com.qd.mapper.ShoppingCarMapper;
import com.qd.service.IShoppingCarService;
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
public class ShoppingCarServiceImpl extends ServiceImpl<ShoppingCarMapper, ShoppingCar> implements IShoppingCarService {
    @Autowired(required = false)
    ShoppingCarMapper mapper;


    @Override
    public List<ShoppingCar> getList(Integer deskId) {
        return mapper.getList(deskId);
    }

}
