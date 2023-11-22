package com.lemonwind.sbmp.web;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.common.web.UrlConstant;
import com.lemonwind.sbmp.entity.MenPai;
import com.lemonwind.sbmp.service.MenPaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenPaiController {

    @Autowired
    private MenPaiService menPaiService;

    @GetMapping(UrlConstant.MENPAI_FIND_ALL)
    public ResultObj<List<MenPai>> findAll() {
       List<MenPai> menPaiList = menPaiService.list();
       return ResultObj.success(menPaiList);
    }

    @PostMapping(UrlConstant.MENPAI_MUL_SAVE)
    public ResultObj<String> addMenpai(@PathVariable("n") int n) {
        menPaiService.mulSave(n);
        return ResultObj.success("添加门派成功");
    }

    @PostMapping(UrlConstant.MENPAI_DEL)
    public ResultObj<String> del(@PathVariable("id") long id) {
        menPaiService.del(id);
        return ResultObj.success("删除成功");
    }

}
