package com.sinashow.news.constant;

/**
 * Created by Administrator on 2018/1/15.
 */

public class Constant {
    //主页再次按返回按钮，退出程序，时间间隔
    public static final int EXIT_APP_TIME_OFFSET = 2000;

    public static final boolean isTest = true;
    public static final String URL_BASE_TEST = "http://mztt.sinashow.com";
    public static final String URL_BASE_PRODUCTIVE = "";
    public static final String URL_BASE = isTest ? URL_BASE_TEST : URL_BASE_PRODUCTIVE;
    //获取tab集合
    public static final String URL_TABLE_LIST = URL_BASE + "/interface/getLabelList.php";
    //获取分类下内容列表
    public static final String URL_CONTENT_LIST = URL_BASE + "/interface/getContentList.php?l_id=%1s&page=%2s";
    //获取内容
    public static final String URL_GET_NEWS_CONTENT = URL_BASE + "/interface/getContent.php?id=559";
}
