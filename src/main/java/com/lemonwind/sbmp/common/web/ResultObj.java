package com.lemonwind.sbmp.common.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultObj<T> {

    private Integer code;
    private String msg;
    private T data;

    public ResultObj(Integer code, String msg, T data) {
        this.code = code;
        this.msg= msg;
        this.data = data;
    }

@SuppressWarnings("unchecked")
    public static <T> ResultObj<T> build(ResponseEnum responseEnum, T data) {
        return new ResultObj(responseEnum.getCode(), responseEnum.getMsg(), data);
    }

    public static <T> ResultObj<T> success() {
        return build(ResponseEnum.SUCESS, null);
    }

    public static <T> ResultObj<T> success(T data) {
        return build(ResponseEnum.SUCESS, data);
    }

    public static <T> ResultObj<T> success(String msg, T data) {
        ResultObj<T> r = build(ResponseEnum.SUCESS, data);
        r.setMsg(msg);
        return r;
    }

    public static <T> ResultObj<T> fail() {
        return build(ResponseEnum.FAIL, null);
    }

    public static <T> ResultObj<T> fail(String message) {
        ResultObj<T> r = build(ResponseEnum.FAIL, null);
        r.setMsg(message);
        return r;
    }

}
