package com.lemonwind.sbmp.service.impl;

import com.lemonwind.sbmp.common.web.ResultObj;
import com.lemonwind.sbmp.service.JomkieSbmpService;
import org.springframework.stereotype.Service;

@Service
public class JomkieSbmpServiceImpl implements JomkieSbmpService {

    @Override
    public ResultObj<Object> all() {
        return ResultObj.success();
    }

}
