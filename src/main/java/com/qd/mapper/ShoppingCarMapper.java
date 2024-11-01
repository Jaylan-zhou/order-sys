package com.qd.mapper;

import com.qd.entity.ShoppingCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
public interface ShoppingCarMapper extends BaseMapper<ShoppingCar> {

    @Select("SELECT shopping_car.*, caipin.id as pid,caipin_name,price,yuanjia,photo FROM shopping_car,caipin WHERE shopping_car.caipin_id = caipin.id and tables_id=#{deskId};")
    List<ShoppingCar> getList(Integer deskId);
}
