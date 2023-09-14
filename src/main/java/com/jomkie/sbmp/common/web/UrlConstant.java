package com.jomkie.sbmp.common.web;

public interface UrlConstant {

    String USER_JOMKIE_ALL = "/api/jomkie/user/all/{code}";
    String TEST_JOMKIE_ALL = "/api/jomkie/test/all";
    String ABSTRACT_JOMKIE_CONTROLLER = "/api/jomkie/abstract/controller";

    String JO_USER_FIND_ALL = "/api/jo/user/find/all";
    String JO_USER_MUL_SAVE = "/api/jo/user/mul/save/{n}";
    String JO_USER_DEL = "/api/jo/user/del/{id}";

    String JO_KONG_FU_FIND_ALL = "/api/jo/kongfu/find/all";
    String JO_KONG_FU_MUL_SAVE = "/api/jo/kongfu/mul/save/{n}";
    String JO_KONG_FU_DEL = "/api/jo/kongfu/del/{id}";
}
