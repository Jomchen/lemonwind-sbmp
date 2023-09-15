package com.jomkie.sbmp.web;

import com.jomkie.sbmp.common.web.ResultObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 系统异常捕获
 */
@RestControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(value = {Exception.class})
    public ResultObj<String> systemError(Exception e) {
        log.error("系统异常栈", e);
       return ResultObj.fail("系统错误") ;
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResultObj<String> runtimeError(RuntimeException e) {
        log.error("运行时异常栈", e);
        return ResultObj.fail("运行时异常");
    }

}
