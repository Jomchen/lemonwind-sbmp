package com.jomkie.sbmp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jomkie.sbmp.entity.KongFu;
import com.jomkie.sbmp.entity.MenPai;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * <p>
 * 门派 服务类
 * </p>
 *
 * @author Jomkie
 * @since 2023-09-18 17:21:12
 */
public interface MenPaiService extends IService<MenPai> {

    void mulSave(int n);

    void del(long id);

}
