package com.sinashow.news.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.obsessive.library.eventbus.EventCenter;
import com.sinashow.news.R;
import com.sinashow.news.bean.Category;
import com.sinashow.news.ui.base.BaseFragment;

/**
 * Created by Administrator on 2018/1/15.
 */

public class NewsFragment extends BaseFragment {
    public static final String FRAGMENT_TAG = NewsFragment.class.getSimpleName();
    public static final String PARAMS_CATEGORY = "PARAMS_CATEGORY";
    private Category mCategory;

    public static NewsFragment newInstance(Category category) {
        NewsFragment fragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(PARAMS_CATEGORY, category);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mCategory = (Category) arguments.getSerializable(PARAMS_CATEGORY);
        }
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
    protected void initViewsAndEvents(View rootView) {
        TextView tvTest = rootView.findViewById(R.id.tv_test);
        if (mCategory != null) {
            tvTest.setText(mCategory.getLabel());
        }
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_news;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
