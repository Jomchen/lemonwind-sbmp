package com.jomkie.sbmp.service.impl;

import com.jomkie.sbmp.common.web.ResultObj;
import com.jomkie.sbmp.service.JomkieSbmpService;
import org.springframework.stereotype.Service;

@Service
public class JomkieSbmpServiceImpl implements JomkieSbmpService {

    @Override
    public ResultObj<Object> all() {
        return ResultObj.success();
    }

}
