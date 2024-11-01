package com.qd.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qd.common.result.ResultUtils;
import com.qd.common.utils.EmptyUtils;
import com.qd.entity.Caipin;
import com.qd.entity.Clazz;
import com.qd.entity.TableInfo;
import com.qd.entity.Users;
import com.qd.service.ICaipinService;
import com.qd.service.IClazzService;
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
@RequestMapping("/caipin")
public class CaipinController {
    @Autowired
    ICaipinService service;


    @GetMapping("/getList")
    public Object getList(@RequestParam Integer page, @RequestParam Integer limit,Caipin product){
        //封装分页对象
        IPage p = new Page(page,limit);

        //封装查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        if(EmptyUtils.isNotEmpty(product.getCaipinName())) {
            queryWrapper.like("caipin_name", product.getCaipinName());
        }
        if(EmptyUtils.isNotEmpty(product.getBlongClazz())) {
            queryWrapper.like("blong_Clazz", product.getBlongClazz());
        }
        queryWrapper.orderByDesc("id");


        //调用服务层的方法进行分页查询、条件查询
        IPage res = service.page(p,queryWrapper);
        //从查询结果中取中当前页的数据
        List list = res.getRecords();
        //从查询结果中取中总条数
        int total = (int)res.getTotal();
        //返回数据
        return ResultUtils.returnSuccessLayui(list,total);
    }

    /**
     * 全查
     * @return
     */
    @GetMapping("/getAllList")
    public Object getList(){
        return ResultUtils.returnDataSuccess(service.list());
    }



    @PostMapping("/add")
    public Object add(@RequestBody Caipin t){
        if(service.save(t)){
            return ResultUtils.returnDataSuccess(t);
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
    public Object update(@RequestBody Caipin u){
        if(service.updateById(u)){
            return ResultUtils.returnDataSuccess(u);
        }
        return ResultUtils.returnFail("修改失败");
    }
}
