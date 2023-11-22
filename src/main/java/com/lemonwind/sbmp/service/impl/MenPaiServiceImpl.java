package com.lemonwind.sbmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lemonwind.sbmp.entity.MenPai;
import com.lemonwind.sbmp.mapper.MenPaiMapper;
import com.lemonwind.sbmp.service.MenPaiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * <p>
 * 门派 服务实现类
 * </p>
 *
 * @author lemonwind
 * @since 2023-09-18 17:21:12
 */
@Service
public class MenPaiServiceImpl extends ServiceImpl<MenPaiMapper, MenPai> implements MenPaiService {

    @Transactional
    @Override
    public void mulSave(int n) {
        MenPai menpai = getOne(new LambdaQueryWrapper<MenPai>().orderByDesc(MenPai::getId).last(" LIMIT 1"));
        long start = menpai == null ? 1 : menpai.getId() + 1;
        List<MenPai> menpaiList = LongStream.range(start, start+n).mapToObj(id -> {
            MenPai mp = new MenPai();
            mp.setId(id);
            mp.setName("武当" + id);
            mp.setArea("陕西" + id);
            return mp;
        }).collect(Collectors.toList());
        saveBatch(menpaiList);
    }

    @Transactional
    @Override
    public void del(long id) {
        removeById(id);
    }

}
