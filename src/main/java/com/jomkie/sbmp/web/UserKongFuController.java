package com.jomkie.sbmp.web;

import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.common.web.UrlConstant;
import com.jomkie.sbmp.service.UserKongFuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserKongFuController {

    @Autowired
    private UserKongFuService userKongFuService;

    /**
     * 批量插入 用户 和 功夫
     * @param n
     * @return
     */
    @RequestMapping(UrlConstant.U_KF_SAVE)
    public ResultObj<String> addUserAndKongfu(@PathVariable("n") int n) {
        return userKongFuService.addUserAndKongfu(n);
    }

}
