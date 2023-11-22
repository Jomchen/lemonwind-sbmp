package com.lemonwind.sbmp.web.others;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.common.web.UrlConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
public class LemonwindTestController {

    @GetMapping(UrlConstant.TEST_LEMONWIND_ALL)
    @ResponseBody
    public ResultObj<String> test() {
        return ResultObj.success("测试");
    }

}
