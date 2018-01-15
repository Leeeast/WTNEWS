package com.sinashow.news.interactor;

import com.sinashow.news.bean.Category;

import java.util.List;

/**
 * Created by lidongliang on 2018/1/14.
 */

public interface MainContentInteractor {
    void loadCategory(LoadCategoryListener listener);

    /**
     * 用户信息加载回调
     */
    interface LoadCategoryListener {
        void onFailed(String errMsg);

        void onSuccess(List<Category> categories);
    }
}
