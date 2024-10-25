package com.qd.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qd.common.result.ResultUtils;
import com.qd.entity.TableInfo;
import com.qd.entity.Users;
import com.qd.service.ITableInfoService;
import com.qd.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Object getList(@RequestParam Integer page,@RequestParam Integer limit){
        //封装一个分页对象
        IPage p = new Page(page,limit);
        //调用服务层的方法进行分页查询
        IPage res = service.page(p);
        //从查询结果中获取当前页的数据
        List list = res.getRecords();
        //从查询结果中获取总条数
        int total = (int)res.getTotal();
        //返回数据，total是总行数
        return ResultUtils.returnSuccessLayui(list, total);
    }

    /**
     * 全查
     * @return
     */
    @GetMapping("/getAllList")
    public Object getList(){
        return ResultUtils.returnDataSuccess(service.list());
    }

    @DeleteMapping("/del")
    public Object del(@RequestParam Integer id){
        if(service.removeById(id)){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail("删除失败");
    }

    @PostMapping("/add")
    public Object add(@RequestBody TableInfo t){
        if(service.save(t)){
            return ResultUtils.returnDataSuccess(t);
        }
        return ResultUtils.returnFail("添加失败");
    }

    @PutMapping("/update")
    public Object update(@RequestBody TableInfo u){
        if(service.updateById(u)){
            return ResultUtils.returnDataSuccess(u);
        }
        return ResultUtils.returnFail("修改失败");
    }

}
