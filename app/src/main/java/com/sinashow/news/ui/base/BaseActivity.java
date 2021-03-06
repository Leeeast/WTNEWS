package com.sinashow.news.ui.base;

import android.os.Bundle;

import com.github.obsessive.library.base.BaseAppCompatActivity;
import com.gyf.barlibrary.ImmersionBar;
import com.sinashow.news.presenter.BasePresenter;
import com.sinashow.news.view.base.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends BaseAppCompatActivity implements BaseView {
    //表示层引用
    public T presenter;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        if (presenter != null) {
            this.presenter.attachView((V) this);
        } else {
            throw new IllegalArgumentException("You must create a own presenter!!!");
        }
        mUnbinder = ButterKnife.bind(this);
        fetch();
        setSystemStatusBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    protected abstract T createPresenter();

    protected abstract void fetch();

    @Override
    public void showError(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showException(String msg) {
        toggleShowError(true, msg, null);
    }

    @Override
    public void showNetError() {
        toggleNetworkError(true, null);
    }

    @Override
    public void showLoading(String msg) {
        toggleShowLoading(true, null);
    }

    @Override
    public void hideLoading() {
        toggleShowLoading(false, null);
    }

    /**
     * 默认状态栏颜色
     */
    public void setSystemStatusBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0)
                .init();
    }
}