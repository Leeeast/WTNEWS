package com.sinashow.news.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.github.obsessive.library.eventbus.EventCenter;
import com.github.obsessive.library.netstatus.NetUtils;
import com.sinashow.news.R;
import com.sinashow.news.presenter.BasePresenter;
import com.sinashow.news.presenter.impl.LoginPresenterImpl;
import com.sinashow.news.presenter.impl.SplashPresenterImpl;
import com.sinashow.news.ui.base.BaseActivity;
import com.sinashow.news.view.LoginView;
import com.sinashow.news.view.SplashView;

/**
 * Created by lidongliang on 2018/1/16.
 */

public class LoginActivity extends BaseActivity<LoginView, LoginPresenterImpl<LoginView>> {

    @Override
    protected LoginPresenterImpl<LoginView> createPresenter() {
        return null;
    }

    @Override
    protected void fetch() {

    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }
}
