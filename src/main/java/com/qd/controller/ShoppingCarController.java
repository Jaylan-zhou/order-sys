package com.qd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qd.common.result.ResultUtils;
import com.qd.common.utils.EmptyUtils;
import com.qd.entity.ShoppingCar;
import com.qd.entity.Users;
import com.qd.service.IShoppingCarService;
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
@RequestMapping("/shopping-car")
public class ShoppingCarController {
    @Autowired
    IShoppingCarService service;


    @GetMapping("/getList")
    public Object getList(Integer tablesId) {
        List<ShoppingCar> list = service.getList(tablesId);//调用自定义方法
        return ResultUtils.returnDataSuccess(list);
    }


    @PostMapping("/add")
    public Object add(@RequestBody ShoppingCar u) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("tables_id", u.getTablesId());
        queryWrapper.eq("caipin_id", u.getCaipinId());
        ShoppingCar one = service.getOne(queryWrapper);

        //已存在：修改数量，num+1, num-1
        if(EmptyUtils.isNotEmpty(one)){
            one.setNumber(one.getNumber() + u.getNumber());
            if(one.getNumber()<=0){
                //执行删除
                if(service.removeById(one)) {
                    return ResultUtils.returnDataSuccess(u);
                }
                return ResultUtils.returnFail("删除失败");
            }else{
                //执行修改
                if (service.updateById(one)) {
                    return ResultUtils.returnDataSuccess(u);
                }
                return ResultUtils.returnFail("修改数量失败");
            }
        }else { //未存在：添加
            if (service.save(u)) {
                return ResultUtils.returnDataSuccess(u);
            }
            return ResultUtils.returnFail("添加失败");
        }

    }

    @DeleteMapping("/del")
    public Object del(Integer tablesId){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("tables_id",tablesId);
        if(service.remove(queryWrapper)){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail("清空失败");
    }


}
