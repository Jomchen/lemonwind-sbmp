package com.jomkie.sbmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.entity.KongFu;
import com.jomkie.sbmp.entity.User;
import com.jomkie.sbmp.service.KongFuService;
import com.jomkie.sbmp.service.UserKongFuService;
import com.jomkie.sbmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserKongFuServiceImpl implements UserKongFuService {

    @Autowired
    private UserService userService;

    @Autowired
    private KongFuService kongFuService;

    @Transactional
    @Override
    public ResultObj<String> addUserAndKongfu(int n) {
        User user = userService.getOne(new LambdaQueryWrapper<User>().orderByDesc(User::getId).last(" LIMIT 1"));
        int start = user == null ? 1 : user.getId() + 1;
        List<User> userList = new ArrayList<>(n);
        List<KongFu> kongFuList = new ArrayList<>(n);
        IntStream.range(start, start+n).forEach(userId -> {
            User userBean = new User()
                    .setAge((20 + userId))
                    .setName("关联人员" + userId)
                    .setSex(userId % 2 == 0 ? 0 : 1)
                    .setRealName("关联人员" + userId)
                    .setEmail("test" + userId + "@gmail.com");
            userBean.setId(userId);


            userList.add(userBean);
            KongFu kongFu = new KongFu();
            kongFu.setInventionUserId(userId);
            kongFu.setName("关联功夫" + userId);
            kongFu.setLevel(10 + userId);
            kongFuList.add(kongFu);
        });

        userService.saveBatch(userList);
        kongFuService.saveBatch(kongFuList);

        return ResultObj.success("关联批量执行成功");
    }

}