package com.sinashow.news.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sinashow.news.bean.Category;
import com.sinashow.news.ui.fragment.NewsFragment;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */

public class NewsPagerAdapter extends FragmentPagerAdapter {
    private List<Category> mCategoryList = null;

    public NewsPagerAdapter(FragmentManager fm, List<Category> categoryList) {
        super(fm);
        this.mCategoryList = categoryList;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(mCategoryList.get(position));
    }

    @Override
    public int getCount() {
        return null != mCategoryList ? mCategoryList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null != mCategoryList ? mCategoryList.get(position).getLabel() : null;
    }
}
