package com.jomkie.sbmp.service.impl;

import com.jomkie.sbmp.entity.User;
import com.jomkie.sbmp.mapper.UserMapper;
import com.jomkie.sbmp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jomkie
 * @since 2022-09-22 14:39:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
