package com.lemonwind.sbmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.entity.KongFu;
import com.lemonwind.sbmp.mapper.KongFuMapper;
import com.lemonwind.sbmp.service.KongFuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * <p>
 * 功夫表 服务实现类
 * </p>
 *
 * @author Jomkie
 * @since 2023-09-14 13:18:48
 */
@Service
public class KongFuServiceImpl extends ServiceImpl<KongFuMapper, KongFu> implements KongFuService {

    @Transactional(readOnly = true)
    @Override
    public ResultObj<List<KongFu>> findAll() {
        List<KongFu> list = list();
        return ResultObj.success(list);
    }

    @Transactional
    @Override
    public void mulSave(int n) {
        KongFu kongfu = getOne(new LambdaQueryWrapper<KongFu>().orderByDesc(KongFu::getId).last(" LIMIT 1"));
        long start = kongfu == null ? 1 : kongfu.getId() + 1;
        List<KongFu> kongfuList = LongStream.range(start, start+n).mapToObj(id -> {
            KongFu kf = new KongFu();
            kf.setId(id);
            kf.setName("功夫" + id);
            kf.setLevel((int)(20 + id));
            kf.setInventionUserId(id);
            return kf;
        }).collect(Collectors.toList());
        saveBatch(kongfuList);
    }

    @Transactional
    @Override
    public void myMulSave(List<KongFu> kongFuList) {
        saveBatch(kongFuList);
    }

    @Transactional
    @Override
    public void del(long id) {
        removeById(id);
    }

}
