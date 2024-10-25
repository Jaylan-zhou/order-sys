package com.qd.service;

import com.qd.entity.Dingdan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qd.entity.DingdanDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
public interface IDingdanService extends IService<Dingdan> {

    List<Dingdan> getList(DingdanDto orders);
}
