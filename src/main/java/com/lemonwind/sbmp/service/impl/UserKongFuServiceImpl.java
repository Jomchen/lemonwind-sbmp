package com.lemonwind.sbmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.entity.KongFu;
import com.lemonwind.sbmp.entity.User;
import com.lemonwind.sbmp.service.KongFuService;
import com.lemonwind.sbmp.service.UserKongFuService;
import com.lemonwind.sbmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Service
public class UserKongFuServiceImpl implements UserKongFuService {

    @Autowired
    private UserService userService;

    @Autowired
    private KongFuService kongFuService;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public ResultObj<String> addUserAndKongfu(int n) {
        User user = userService.getOne(new LambdaQueryWrapper<User>().orderByDesc(User::getId).last(" LIMIT 1"));
        long start = user == null ? 1 : user.getId() + 1;
        List<User> userList = new ArrayList<>(n);
        List<KongFu> kongFuList = new ArrayList<>(n);
        LongStream.range(start, start+n).forEach(userId -> {
            User userBean = new User()
                    .setAge((int)(20 + userId))
                    .setName("关联人员" + userId)
                    .setSex(userId % 2 == 0 ? 0 : 1)
                    .setRealName("关联人员" + userId)
                    .setEmail("test" + userId + "@gmail.com");
            userBean.setId(userId);
            userList.add(userBean);

            KongFu kongFu = new KongFu();
            kongFu.setInventionUserId(userId);
            kongFu.setName("关联功夫" + userId);
            kongFu.setLevel((int)(10 + userId));
            kongFuList.add(kongFu);
        });

        userService.myMulSave(userList);
        kongFuService.myMulSave(kongFuList);
        return ResultObj.success("关联批量执行成功");
    }

}
