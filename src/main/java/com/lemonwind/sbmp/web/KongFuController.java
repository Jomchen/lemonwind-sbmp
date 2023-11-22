package com.lemonwind.sbmp.web;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.common.web.UrlConstant;
import com.lemonwind.sbmp.entity.KongFu;
import com.lemonwind.sbmp.service.KongFuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KongFuController {

    @Autowired
    private KongFuService kongFuService;

    @RequestMapping(UrlConstant.KONGFU_FIND_ALL)
    public ResultObj<List<KongFu>> findAll() {
        return kongFuService.findAll();
    }

    @RequestMapping(UrlConstant.KONGFU_MUL_SAVE)
    public ResultObj<String> mulSave(@PathVariable("n") int n) {
        kongFuService.mulSave(n);
        return ResultObj.success("保存功夫成功");
    }

    @RequestMapping(UrlConstant.KONGFU_DEL)
    public ResultObj<String> del(long id) {
        kongFuService.del(id);
        return ResultObj.success("删除功夫" + id + "成功");
    }

}
