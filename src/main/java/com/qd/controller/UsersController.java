package com.qd.controller;


import com.qd.common.result.ResultUtils;
import com.qd.entity.Users;
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
@RequestMapping("/users")
public class UsersController {


    @Autowired
    IUsersService service;

    @GetMapping("/")
    public Object getList(){
        List<Users> list = service.list();
        return ResultUtils.returnSuccessLayui(list, list.size());
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable("id") Integer id){
        Users u = service.getById(id);
        return ResultUtils.returnDataSuccess(u);
    }

    @PostMapping("/")
    public Object add(@RequestBody Users u){
        if(service.save(u)){
            return ResultUtils.returnDataSuccess(u);
        }
        return ResultUtils.returnFail("添加失败");
    }


    @PutMapping("/")
    public Object update(@RequestBody Users u){
        if(service.updateById(u)){
            return ResultUtils.returnDataSuccess(u);
        }
        return ResultUtils.returnFail("修改失败");
    }

    @DeleteMapping("/")
    public Object del(@RequestParam Integer id){
        if(service.removeById(id)){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail("删除失败");
    }


}
