package com.qd.service;

import com.qd.entity.ShoppingCar;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
public interface IShoppingCarService extends IService<ShoppingCar> {

    List<ShoppingCar> getList(Integer tablesId);
}
