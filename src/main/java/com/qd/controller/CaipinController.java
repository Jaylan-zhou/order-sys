package com.qd.controller;


import com.qd.common.result.ResultUtils;
import com.qd.entity.Caipin;
import com.qd.entity.Clazz;
import com.qd.entity.Users;
import com.qd.service.ICaipinService;
import com.qd.service.IClazzService;
import com.qd.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/caipin")
public class CaipinController {
    @Autowired
    ICaipinService service;


    @GetMapping("/getList")
    public Object getList(){
        List<Caipin> list = service.list();
        return ResultUtils.returnSuccessLayui(list, list.size());
    }
}
