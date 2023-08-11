package com.jomkie.sbmp.web;

import com.jomkie.sbmp.common.web.UrlConstant;
import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.entity.User;
import com.jomkie.sbmp.service.JomkieSbmpService;
import com.jomkie.sbmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
public class JomkieSbmpController {

    @Autowired
    private JomkieSbmpService jomkieSbmpService;
    @Autowired
    private UserService userService;

    /**
     * @Description 测试所有
     * @author jomkie
     * @since 2022-09-13 10:32:01
     * @return com.yunxi.sbmp.jomkie.action.common.ResultObj<java.lang.String>
     */
    @GetMapping(UrlConstant.USER_JOMKIE_ALL)
    public ResultObj<Object> all(@PathVariable("code") Integer code) {
        Object data = null;
        if (Objects.equals(1, code)) {
            // 查询
            data = userService.getById(1);
        } else if (Objects.equals(2, code)) {
            // 增加
            LocalDateTime now = LocalDateTime.now();
            User user = new User()
                    .setAge(now.getMonthValue())
                    .setName("金庸" + now.getSecond())
                    .setSex(1 & now.getSecond())
                    .setRealName("金庸")
                    .setEmail("jinyong@qq.com");
            data = userService.save(user);
        } else if (Objects.equals(3, code)) {
           data = "3";
        }
        return ResultObj.success(data);
    }

}
