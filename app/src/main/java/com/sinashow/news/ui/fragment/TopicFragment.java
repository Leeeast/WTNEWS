package com.sinashow.news.ui.fragment;

import android.view.View;

import com.github.obsessive.library.eventbus.EventCenter;
import com.sinashow.news.R;
import com.sinashow.news.ui.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/15.
 */

public class TopicFragment extends BaseFragment {
    public static final String FRAGMENT_TAG = TopicFragment.class.getSimpleName();

    public static TopicFragment newInstance() {
        TopicFragment fragment = new TopicFragment();
        return fragment;
    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
