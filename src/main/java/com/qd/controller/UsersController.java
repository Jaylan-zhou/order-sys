package com.qd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qd.common.result.ResultUtils;
import com.qd.common.utils.EmptyUtils;
import com.qd.entity.Users;
import com.qd.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    @PostMapping("/add")
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

    @DeleteMapping("/del")
    public Object del(@RequestParam Integer id){
        if(service.removeById(id)){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail("删除失败");
    }

    @PostMapping("/login")
    public Object login(@RequestParam String account, @RequestParam String code, HttpSession session){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account",account);
        queryWrapper.eq("code",code);
        Users one = service.getOne(queryWrapper);
        if(EmptyUtils.isNotEmpty(one)){
            //登录成功以后将用户名存储到会话
            session.setAttribute("userName",account);
            return ResultUtils.returnDataSuccess(one);
        }else{
            return ResultUtils.returnFail("用户名或密码错误");
        }

    }

    @GetMapping("/getCurrUser")
    public Object getCurrUser(HttpSession session){
        Object account = session.getAttribute("userName");
        return ResultUtils.returnDataSuccess(account);
    }

    @GetMapping("/logOut")
    public Object logOut(HttpSession session){
        Object account = session.getAttribute("userName");
        return ResultUtils.returnDataSuccess(account);
    }


}
