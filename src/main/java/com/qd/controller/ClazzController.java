package com.qd.controller;


import com.qd.common.result.ResultUtils;
import com.qd.entity.Caipin;
import com.qd.entity.Clazz;
import com.qd.entity.Users;
import com.qd.service.IClazzService;
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
@RequestMapping("/clazz")
public class ClazzController {
    @Autowired
    IClazzService service;


    @GetMapping("/getList")
    public Object getList(){
        List<Clazz> list = service.list();
        return ResultUtils.returnSuccessLayui(list, list.size());
    }

    @PostMapping("/add")
    public Object add(@RequestBody Clazz u){
        if(service.save(u)){
            return ResultUtils.returnDataSuccess(u);
        }
        return ResultUtils.returnFail("添加失败");
    }

    @DeleteMapping("/del")
    public Object del(@RequestParam Integer id){
        if(service.removeById(id)){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail("删除失败");
    }


    @PutMapping("/update")
    public Object update(@RequestBody Clazz u){
        if(service.updateById(u)){
            return ResultUtils.returnDataSuccess(u);
        }
        return ResultUtils.returnFail("修改失败");
    }
}
