package com.jomkie.sbmp.service;

import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Jomkie
 * @since 2022-09-22 14:39:44
 */
public interface UserService extends IService<User> {

    ResultObj<List<User>> findAll();

    void mulSave(int n);

    void del(int id);

    void myMulSave(List<User> userList);


}
