package com.lemonwind.sbmp.service.impl;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.service.LemonwindSbmpService;
import org.springframework.stereotype.Service;

@Service
public class LemonwindSbmpServiceImpl implements LemonwindSbmpService {

    @Override
    public ResultObj<Object> all() {
        return ResultObj.success();
    }

}
