package com.qd.service.impl;

import com.qd.entity.Dingdan;
import com.qd.entity.DingdanDto;
import com.qd.mapper.DingdanMapper;
import com.qd.service.IDingdanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
@Service
public class DingdanServiceImpl extends ServiceImpl<DingdanMapper, Dingdan> implements IDingdanService {


    @Autowired(required = false)
    DingdanMapper mapper;

    @Override
    public List<Dingdan> getList(DingdanDto orders) {
        return mapper.getList(orders);
    }
}
