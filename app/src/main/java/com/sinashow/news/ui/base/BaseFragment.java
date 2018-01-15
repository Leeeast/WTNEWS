package com.sinashow.news.ui.base;

/**
 * Created by lidongliang on 2018/1/14.
 */

import com.github.obsessive.library.base.BaseLazyFragment;
import com.sinashow.news.view.base.BaseView;

/**
 * Author:  LiDongliang
 * Date:    2018/1/15
 * Description:
 */
public abstract class BaseFragment extends BaseLazyFragment implements BaseView {

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

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
}