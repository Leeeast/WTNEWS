package com.sinashow.news.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.github.obsessive.library.eventbus.EventCenter;
import com.github.obsessive.library.netstatus.NetUtils;
import com.sinashow.news.R;
import com.sinashow.news.presenter.BasePresenter;
import com.sinashow.news.presenter.impl.SplashPresenterImpl;
import com.sinashow.news.ui.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rdobtn_mine)
    RadioButton rdobtnMine;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
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
        rdobtnMine.setText(getString(R.string.tab_unlogin));
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
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
    protected BasePresenter createPresenter() {
        return new SplashPresenterImpl();
    }

    @Override
    protected void fetch() {

    }

    @Override
    public void setSystemStatusBar() {
        super.setSystemStatusBar();
    }
}
