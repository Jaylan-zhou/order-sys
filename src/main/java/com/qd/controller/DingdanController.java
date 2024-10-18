package com.qd.controller;


import com.qd.common.result.ResultUtils;
import com.qd.entity.Dingdan;
import com.qd.entity.Users;
import com.qd.service.IDingdanService;
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
@RequestMapping("/dingdan")
public class DingdanController {
    @Autowired
    IDingdanService service;


    @GetMapping("/getList")
    public Object getList(){
        List<Dingdan> list = service.list();
        return ResultUtils.returnSuccessLayui(list, list.size());
    }
}
