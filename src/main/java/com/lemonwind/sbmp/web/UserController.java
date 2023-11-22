package com.lemonwind.sbmp.web;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.common.web.UrlConstant;
import com.lemonwind.sbmp.entity.User;
import com.lemonwind.sbmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(UrlConstant.USER_FIND_ALL)
    public ResultObj<List<User>> findAll() {
        return userService.findAll();
    }

    /**
     * 添加
     * @param n
     * @return
     */
    @RequestMapping(UrlConstant.USER_MUL_SAVE)
    public ResultObj<String> mulSave(@PathVariable("n") int n) {
        userService.mulSave(n);
        return ResultObj.success("保存成功");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping(UrlConstant.USER_DEL)
    public ResultObj<String> del(@PathVariable("id") long id) {
        userService.del(id);
        return ResultObj.success("删除成功");
    }

}
