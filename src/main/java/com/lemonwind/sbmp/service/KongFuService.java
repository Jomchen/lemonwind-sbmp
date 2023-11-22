package com.lemonwind.sbmp.service;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.entity.KongFu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 功夫表 服务类
 * </p>
 *
 * @author Jomkie
 * @since 2023-09-14 13:18:48
 */
public interface KongFuService extends IService<KongFu> {

   ResultObj<List<KongFu>> findAll();

   void mulSave(int n);

   void del(long id);

   void myMulSave(List<KongFu> kongFuList);

}
