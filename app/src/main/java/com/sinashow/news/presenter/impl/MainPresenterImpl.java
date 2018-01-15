package com.sinashow.news.presenter.impl;


import com.sinashow.news.bean.UserInfo;
import com.sinashow.news.interactor.MainInteractor;
import com.sinashow.news.interactor.impl.MainInteractorImpl;
import com.sinashow.news.presenter.BasePresenter;
import com.sinashow.news.presenter.MainPresenter;
import com.sinashow.news.view.MainView;

/**
 * Created by Administrator on 2018/1/15.
 */

public class MainPresenterImpl<T extends MainView> extends BasePresenter<T> implements MainPresenter, MainInteractor.LoadUserInfoListener {

    private MainInteractorImpl mainInteractor;

    public MainPresenterImpl() {
        mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void checkLoginStatus() {
        MainView mainView = mViewRef.get();
        if (mainView != null) {
            if (mainInteractor != null) {
                if (mainInteractor.isLogin()) {
                    mainInteractor.loadUserInfo(this);
                } else {
                    mainView.updateUserInfo(false, null);
                }
            }
        }
    }

    @Override
    public void onComplete(UserInfo userInfo) {
        if (mViewRef.get() != null) {
            mViewRef.get().updateUserInfo(true, userInfo);
        }
    }
}
