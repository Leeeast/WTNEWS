package com.sinashow.news.constant;

/**
 * Created by lidongliang on 2017/5/24.
 */

public class JumpCode {

    // 一般请求码
    public static final int FLAG_REQ = 100;
    // 一般返回码
    public static final int FLAG_RES_RETURN = 500;

    // 请求码,往下加1
    public static final int FLAG_REQ_JUMP_MAIN = FLAG_REQ + 1;


    // 返回码,往下加1
    public static final int FLAG_RES_EXIT_APP = FLAG_RES_RETURN + 1;


}
