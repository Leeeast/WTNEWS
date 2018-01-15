package com.sinashow.news.presenter.impl;

import com.sinashow.news.bean.Category;
import com.sinashow.news.interactor.MainContentInteractor;
import com.sinashow.news.interactor.impl.MainContentInteractorImpl;
import com.sinashow.news.presenter.BasePresenter;
import com.sinashow.news.presenter.MainContentPresenter;
import com.sinashow.news.view.MainContentView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */

public class MainContentPresenterImpl<T extends MainContentView> extends BasePresenter<T> implements MainContentPresenter {
    protected MainContentInteractorImpl contentInteractor;

    public MainContentPresenterImpl() {
        contentInteractor = new MainContentInteractorImpl();
    }

    @Override
    public void fetch() {
        if (mViewRef != null && contentInteractor != null) {
            contentInteractor.loadCategory(new MainContentInteractor.LoadCategoryListener() {
                @Override
                public void onFailed(String errMsg) {

                }

                @Override
                public void onSuccess(List<Category> categories) {
                    if (mViewRef.get() != null) {
                        mViewRef.get().showViewPager(categories);
                    }
                }
            });
        }
    }
}
