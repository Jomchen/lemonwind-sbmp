package com.jomkie.sbmp.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.common.web.UrlConstant;
import com.jomkie.sbmp.entity.KongFu;
import com.jomkie.sbmp.service.KongFuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@RestController
public class KongFuController {

    @Autowired
    private KongFuService kongFuService;

    @RequestMapping(UrlConstant.JO_KONG_FU_FIND_ALL)
    public ResultObj<List<KongFu>> findAll() {
        return kongFuService.findAll();
    }

    @RequestMapping(UrlConstant.JO_KONG_FU_MUL_SAVE)
    public ResultObj<String> mulSave(@PathVariable("n") int n) {
        kongFuService.mulSave(n);
        return ResultObj.success("保存功夫成功");
    }

    @RequestMapping(UrlConstant.JO_KONG_FU_DEL)
    public ResultObj<String> del(long id) {
        kongFuService.del(id);
        return ResultObj.success("删除功夫" + id + "成功");
    }

}
