package com.qd.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.qd.entity.Dingdan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qd.entity.DingdanDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
public interface DingdanMapper extends MPJBaseMapper<Dingdan> {

    List<Dingdan> getList(DingdanDto orders);
}
