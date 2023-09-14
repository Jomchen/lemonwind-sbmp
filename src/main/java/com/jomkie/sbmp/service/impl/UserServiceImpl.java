package com.jomkie.sbmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.entity.User;
import com.jomkie.sbmp.mapper.UserMapper;
import com.jomkie.sbmp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

    @Override
    public ResultObj<List<User>> findAll() {
        List<User> list = list();
        return ResultObj.success(list);
    }

    @Transactional
    @Override
    public void mulSave(int n) {
        User user = new LambdaQueryWrapper<User>().orderByDesc(User::getCreateTime).last(" LIMIT 1").getEntity();
        long i = user == null ? 1 : user.getId() + 1;
        List<User> userList = LongStream.range(i, i+n).mapToObj(id ->
            new User().setAge((int)(20 + i))
                    .setName("测试人员" + i)
                    .setSex(i % 2 == 0 ? 0 : 1)
                    .setRealName("测试人员" + i)
        ).collect(Collectors.toList());
        saveBatch(userList);
    }

    @Transactional
    @Override
    public void del(long id) {
        super.removeById(id);
    }

}
