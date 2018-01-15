package com.sinashow.news.view;

import com.sinashow.news.bean.Category;

import java.util.List;

/**
 * Created by lidongliang on 2018/1/15.
 */

public interface MainContentView {
    void showViewPager(List<Category> categoryList);
}
