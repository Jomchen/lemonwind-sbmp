package com.lemonwind.sbmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.entity.User;
import com.lemonwind.sbmp.mapper.UserMapper;
import com.lemonwind.sbmp.service.UserService;
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
        User user = getOne(new LambdaQueryWrapper<User>().orderByDesc(User::getId).last(" LIMIT 1"));
        long start = user == null ? 1 : user.getId() + 1;
        List<User> userList = LongStream.range(start, start+n).mapToObj(id ->
            new User().setAge((int)(20 + id))
                    .setName("测试人员" + id)
                    .setSex(id % 2 == 0 ? 0 : 1)
                    .setRealName("测试人员" + id)
                    .setEmail("test" + id + "@gmail.com")
        ).collect(Collectors.toList());
        saveBatch(userList);
    }

    @Transactional
    @Override
    public void del(long id) {
        super.removeById(id);
    }

    @Transactional
    @Override
    public void myMulSave(List<User> userList) {
        saveBatch(userList);
    }

}
