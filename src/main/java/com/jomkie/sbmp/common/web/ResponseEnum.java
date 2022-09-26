package com.jomkie.sbmp.common.web;


public enum ResponseEnum implements EnumInterface {

    SUCESS(200, "请求成功"),
    FAIL(500, "请求失败"),

    ;

    private final Integer code;
    private final String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
