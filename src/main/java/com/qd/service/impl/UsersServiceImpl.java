package com.qd.service.impl;

import com.qd.entity.Users;
import com.qd.mapper.UsersMapper;
import com.qd.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhoujunyu
 * @since 2024-10-16
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
