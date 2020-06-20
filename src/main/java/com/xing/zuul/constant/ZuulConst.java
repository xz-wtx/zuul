package com.xing.zuul.constant;

public class ZuulConst {
    /**
     * 决定是否走下一个filter
     */
    public static String IS_SUCCESS="isSuccess";

    /**
     * 内部系统接口
     */
    public static String IS_OPEN_API="isOpenApi";
    /**
     * 对外提供接口
     */
    public static String IS_CGI_BIN="isCgiBin";

    public static String PRE_TYPE="pre";

    public static String POST_TYPE="post";

    public static String ERROR_TYPE="error";

    public static Integer FILTER_ORDER_0=0;

    public static Integer FILTER_ORDER_1=1;

    public static Integer FILTER_ORDER_2=2;

    public static Integer FILTER_ORDER_3=3;
}
