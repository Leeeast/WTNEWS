package com.sinashow.news.presenter.impl;

import com.sinashow.news.interactor.SplashInteractor;
import com.sinashow.news.interactor.impl.SplashInteractorImpl;
import com.sinashow.news.presenter.BasePresenter;
import com.sinashow.news.presenter.SplashPresenter;
import com.sinashow.news.view.SplashView;

/**
 * Created by lidongliang on 2018/1/14.
 */

public class SplashPresenterImpl<T extends SplashView> extends BasePresenter<T> implements SplashPresenter {

    protected SplashInteractorImpl splashInteractor = null;

    public SplashPresenterImpl() {
        splashInteractor = new SplashInteractorImpl();
    }

    @Override
    public void fetch() {
        if (splashInteractor != null && mViewRef.get() != null) {
            splashInteractor.loadAD(new SplashInteractor.LoadADListener() {
                @Override
                public void onNeedLoadAD(boolean load) {
                    //如果不需要显示广告直接进入主页
                    if (!load) {
                        if (splashInteractor.isFirstLaunch()) {
                            //TODO 跳转到引导页
                        } else {
                            mViewRef.get().jump2Main(true);
                        }

                    }
                }

                @Override
                public void onComplete(String url) {

                }
            });
        }
    }
}
