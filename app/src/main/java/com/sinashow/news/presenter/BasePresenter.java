package com.sinashow.news.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by lidongliang on 2018/1/14.
 * 表示层基类，抽出绑定和解绑view功能
 */

public class BasePresenter<T> {
    //1. view层引用
    //IGirlView girlView;
    protected WeakReference<T> mViewRef;

    //进行绑定
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    //解除绑定
    public void detachView() {
        mViewRef.clear();
    }
}