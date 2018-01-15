package com.sinashow.news.interactor;

/**
 * Created by lidongliang on 2018/1/14.
 */

public interface SplashInteractor {
    boolean isFirstLaunch();

    void loadAD(LoadADListener listener);

    /**
     * 广告加载回调
     */
    interface LoadADListener {
        void onNeedLoadAD(boolean load);

        void onComplete(String url);
    }
}
