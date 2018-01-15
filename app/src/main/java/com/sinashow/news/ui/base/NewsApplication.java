package com.sinashow.news.ui.base;

import android.app.Application;
import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by lidongliang on 2018/1/14.
 */

public class NewsApplication extends Application {
    public static NewsApplication showApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        showApplication = this;
        init();
    }

    /**
     * 获取应用ApplicationContext
     *
     * @return
     */
    public static Context getAppContext() {
        return showApplication;
    }

    /**
     * 初始化相关配置
     */
    private void init() {
        Fresco.initialize(this);
    }

    private HttpProxyCacheServer proxy;

    public static HttpProxyCacheServer getProxy() {
        NewsApplication app = NewsApplication.showApplication;
        return app.proxy == null ? (app.proxy = app.newProxy()) : app.proxy;
    }

    private HttpProxyCacheServer newProxy() {
        return new HttpProxyCacheServer(this);
    }
}
