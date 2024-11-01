package com.qd.controller;


import com.qd.common.result.ResultUtils;
import com.qd.entity.Clazz;
import com.qd.entity.Dingdan;
import com.qd.entity.DingdanDto;
import com.qd.entity.Users;
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



}
