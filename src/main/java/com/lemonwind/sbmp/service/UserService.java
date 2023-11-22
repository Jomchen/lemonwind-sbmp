package com.lemonwind.sbmp.service;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemonwind
 * @since 2022-09-22 14:39:44
 */
public interface UserService extends IService<User> {

    ResultObj<List<User>> findAll();

    void mulSave(int n);

    void del(long id);

    void myMulSave(List<User> userList);


}
