package com.sinashow.news.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.github.obsessive.library.eventbus.EventCenter;
import com.github.obsessive.library.netstatus.NetUtils;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.sinashow.news.R;
import com.sinashow.news.presenter.impl.SplashPresenterImpl;
import com.sinashow.news.ui.base.BaseActivity;
import com.sinashow.news.view.SplashView;

import java.lang.ref.WeakReference;

public class SplashActivity extends BaseActivity<SplashView, SplashPresenterImpl<SplashView>> implements SplashView {
    private static final int CODE_JUMP_GUIDE = 0;
    private static final int CODE_JUMP_MAIN = 1;
    private static final int TIME_JUMP_DELAY = 1500;

    private SmartHandler mSmartHandler;
    protected ImmersionBar mImmersionBar;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
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
        mSmartHandler = new SmartHandler(this);
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

    @Override
    public void setSystemStatusBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        mImmersionBar.hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
    }

    @Override
    public void showCountDown() {

    }

    @Override
    public void showAD() {

    }

    @Override
    public void jump2Main(boolean needDelay) {
        if (mSmartHandler != null) {
            mSmartHandler.sendEmptyMessageDelayed(CODE_JUMP_MAIN, needDelay ? TIME_JUMP_DELAY : 0);
        }
    }

    @Override
    public void jump2Guide(boolean needDelay) {
        if (mSmartHandler != null) {
            mSmartHandler.sendEmptyMessageDelayed(CODE_JUMP_GUIDE, needDelay ? TIME_JUMP_DELAY : 0);
        }
    }

    @Override
    protected SplashPresenterImpl<SplashView> createPresenter() {
        return new SplashPresenterImpl<>();
    }

    @Override
    protected void fetch() {
        presenter.fetch();
    }

    public static class SmartHandler extends Handler {
        private WeakReference<SplashActivity> weakReference;

        public SmartHandler(SplashActivity splashActivity) {
            weakReference = new WeakReference<>(splashActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity splashActivity = weakReference.get();
            if (weakReference.get() == null) return;
            switch (msg.what) {
                case CODE_JUMP_GUIDE:
                    break;
                case CODE_JUMP_MAIN:
                    splashActivity.readyGoThenKill(MainActivity.class);
                    break;
            }
            weakReference.clear();
        }
    }
}
