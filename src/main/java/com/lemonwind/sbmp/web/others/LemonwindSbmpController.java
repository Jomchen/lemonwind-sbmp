package com.lemonwind.sbmp.web.others;

import com.lemonwind.sbmp.common.web.UrlConstant;
import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.entity.User;
import com.lemonwind.sbmp.service.LemonwindSbmpService;
import com.lemonwind.sbmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
public class LemonwindSbmpController {

    @Autowired
    private LemonwindSbmpService lemonwindSbmpService;
    @Autowired
    private UserService userService;

    /**
     * @Description 测试所有
     * @author lemonwind
     * @since 2022-09-13 10:32:01
     */
    @GetMapping(UrlConstant.USER_LEMONWIND_ALL)
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
