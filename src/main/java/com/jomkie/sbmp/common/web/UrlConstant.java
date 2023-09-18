package com.jomkie.sbmp.common.web;

public interface UrlConstant {

    String USER_JOMKIE_ALL = "/api/jomkie/user/all/{code}";
    String TEST_JOMKIE_ALL = "/api/jomkie/test/all";

    String U_KF_SAVE = "/api/uk/save/{n}";

    String USER_FIND_ALL = "/api/user/find/all";
    String USER_MUL_SAVE = "/api/user/mul/save/{n}";
    String USER_DEL = "/api/user/del/{id}";

    String KONGFU_FIND_ALL = "/api/kongfu/find/all";
    String KONGFU_MUL_SAVE = "/api/kongfu/mul/save/{n}";
    String KONGFU_DEL = "/api/kongfu/del/{id}";

    String MENPAI_FIND_ALL = "/api/menpai/find/all";
    String MENPAI_MUL_SAVE = "/api/menpai/mul/save/{n}";
    String MENPAI_DEL = "/api/menpai/del/{n}";

}
