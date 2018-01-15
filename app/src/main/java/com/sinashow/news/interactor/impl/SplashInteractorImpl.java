package com.sinashow.news.interactor.impl;

import com.sinashow.news.interactor.SplashInteractor;

/**
 * Created by lidongliang on 2018/1/14.
 */

public class SplashInteractorImpl implements SplashInteractor {
    @Override
    public boolean isFirstLaunch() {
        return false;
    }

    @Override
    public void loadAD(LoadADListener listener) {
        //1.可通过借口获取是否开启广告,默认不开启
        boolean needLoadAD = false;
        listener.onNeedLoadAD(needLoadAD);
        if (needLoadAD) {
            //2.通过接口获取广告相关
            //listener.onComplete("");
        }
    }
}
