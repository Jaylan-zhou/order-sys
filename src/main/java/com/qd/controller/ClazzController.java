package com.qd.controller;


import com.qd.common.result.ResultUtils;
import com.qd.entity.Clazz;
import com.qd.service.IClazzService;
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
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    IClazzService service;


    @GetMapping("/getList")
    public Object getList(){
        List<Clazz> list = service.list();
        return ResultUtils.returnSuccessLayui(list, list.size());
    }
}
