package com.jomkie.sbmp.service;

import com.jomkie.sbmp.common.web.ResultObj;
import org.springframework.stereotype.Service;

@Service
public interface JomkieSbmpService {

    ResultObj<Object> all();

}
