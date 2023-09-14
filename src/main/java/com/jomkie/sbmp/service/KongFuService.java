package com.jomkie.sbmp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.entity.KongFu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

}
