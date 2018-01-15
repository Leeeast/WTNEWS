package com.sinashow.news.ui.fragment;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.github.obsessive.library.eventbus.EventCenter;
import com.sinashow.news.R;
import com.sinashow.news.bean.Category;
import com.sinashow.news.presenter.impl.MainContentPresenterImpl;
import com.sinashow.news.ui.adapter.NewsPagerAdapter;
import com.sinashow.news.ui.base.BaseFragment;
import com.sinashow.news.utils.TitleBarAdapterUtil;
import com.sinashow.news.view.MainContentView;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import net.lucode.hackware.magicindicator.ext.titles.ScaleTransitionPagerTitleView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */

public class MainFragment extends BaseFragment implements MainContentView {
    public static final String FRAGMENT_TAG = MainFragment.class.getSimpleName();

    protected MainContentPresenterImpl contentPresenter;
    private MagicIndicator mMagicIndicator;
    private CommonNavigator mCommonNavigator;
    private ViewPager mViewPager;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
    protected void initViewsAndEvents(View rootView) {
        contentPresenter = new MainContentPresenterImpl();
        contentPresenter.attachView(this);
        contentPresenter.fetch();

        View titleLayout = rootView.findViewById(R.id.title_layout);
        FrameLayout flyTitleRoot = titleLayout.findViewById(R.id.fly_title_root);
        TitleBarAdapterUtil.adapterTitleBar(getActivity(), flyTitleRoot);

        TextView tvTitle = rootView.findViewById(R.id.tv_title);
        tvTitle.setText(getResources().getString(R.string.app_name));

        mViewPager = rootView.findViewById(R.id.viewpager);
        mMagicIndicator = rootView.findViewById(R.id.magic_indicator);
        mCommonNavigator = new CommonNavigator(getActivity());
        mCommonNavigator.setSkimOver(true);
        mMagicIndicator.setNavigator(mCommonNavigator);
        ViewPagerHelper.bind(mMagicIndicator, mViewPager);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    public void showViewPager(final List<Category> categoryList) {

        mCommonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return categoryList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {

                NewsPagerAdapter newsPagerAdapter = new NewsPagerAdapter(getSupportFragmentManager(), categoryList);
                mViewPager.setOffscreenPageLimit(categoryList.size());
                mViewPager.setAdapter(newsPagerAdapter);

                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);
                simplePagerTitleView.setText(categoryList.get(index).getLabel());
                simplePagerTitleView.setTextSize(getResources().getDimension(R.dimen.tab_text_select));
                simplePagerTitleView.setNormalColor(getResources().getColor(R.color.main_tab_default));
                simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.main_tab_clip));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (contentPresenter != null) {
            contentPresenter.detachView();
        }
    }
}
