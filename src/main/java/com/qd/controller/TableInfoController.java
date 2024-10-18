package com.qd.controller;


import com.qd.common.result.ResultUtils;
import com.qd.entity.TableInfo;
import com.qd.entity.Users;
import com.qd.service.ITableInfoService;
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
@RequestMapping("/table-info")
public class TableInfoController {


    @Autowired
    ITableInfoService service;


    @GetMapping("/getList")
    public Object getList(){
        List<TableInfo> list = service.list();
        return ResultUtils.returnSuccessLayui(list, list.size());
    }

}
