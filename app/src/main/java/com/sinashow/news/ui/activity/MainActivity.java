package com.sinashow.news.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.obsessive.library.eventbus.EventCenter;
import com.github.obsessive.library.netstatus.NetUtils;
import com.sinashow.news.R;
import com.sinashow.news.bean.UserInfo;
import com.sinashow.news.constant.Constant;
import com.sinashow.news.presenter.impl.MainPresenterImpl;
import com.sinashow.news.ui.base.BaseActivity;
import com.sinashow.news.ui.fragment.MainFragment;
import com.sinashow.news.ui.fragment.MineFragment;
import com.sinashow.news.ui.fragment.TopicFragment;
import com.sinashow.news.view.MainView;

public class MainActivity extends BaseActivity<MainView, MainPresenterImpl<MainView>> implements MainView, RadioGroup.OnCheckedChangeListener {
    private RadioGroup rdogpMainTab;
    private RadioButton mRdobtnMine;

    private String[] fragmentTags = new String[]{MainFragment.FRAGMENT_TAG,
            TopicFragment.FRAGMENT_TAG, MineFragment.FRAGMENT_TAG};
    protected FragmentManager fragmentManager;
    protected FragmentTransaction ft;

    //再次点击退出使用
    private long touchTime = 0;

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {
        fragmentManager = getSupportFragmentManager();

        mRdobtnMine = findViewById(R.id.rdobtn_mine);
        rdogpMainTab = findViewById(R.id.rdogp_main_tab);
        rdogpMainTab.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }


    @Override
    protected MainPresenterImpl<MainView> createPresenter() {
        return new MainPresenterImpl<>();
    }

    @Override
    protected void fetch() {
        presenter.checkLoginStatus();
    }

    @Override
    public void setSystemStatusBar() {
        super.setSystemStatusBar();
    }

    @Override
    public void updateUserInfo(boolean isLogion, UserInfo userInfo) {
        if (isLogion) {

        } else {
            mRdobtnMine.setText(getString(R.string.tab_unlogin));
        }
    }

    /**
     * 显示Fragment
     *
     * @param tag
     */
    protected void showFragment(String tag) {
        ft = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragment = addFragment(tag);
        }
        if (!fragment.isAdded()) {
            ft.add(R.id.fly_content, fragment, tag);
        } else {
            ft.show(fragment);
            // ft.addToBackStack(tag);
        }
        hideOtherFragment(tag, ft);
        ft.commitAllowingStateLoss();
    }

    /**
     * 添加Fragment
     *
     * @param tag
     * @return
     */
    private Fragment addFragment(String tag) {
        Fragment fragment = null;
        if (tag.equals(MainFragment.FRAGMENT_TAG)) {
            fragment = MainFragment.newInstance();
        } else if (tag.equals(TopicFragment.FRAGMENT_TAG)) {
            fragment = TopicFragment.newInstance();
        } else if (tag.equals(MineFragment.FRAGMENT_TAG)) {
            fragment = MineFragment.newInstance();
        }
        return fragment;
    }

    /**
     * 隐藏别的Fragment
     *
     * @param tag
     * @param ft
     */
    protected void hideOtherFragment(String tag, FragmentTransaction ft) {
        for (String t : fragmentTags) {
            if (!t.equals(tag)) {
                Fragment otherFragment = fragmentManager.findFragmentByTag(t);
                if (otherFragment != null) {
                    ft.hide(otherFragment);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - touchTime) > Constant.EXIT_APP_TIME_OFFSET) {
            //让Toast的显示时间和等待时间相同
            Toast.makeText(this, getString(R.string.exit_app_tips) + getString(R.string.app_name), Toast.LENGTH_SHORT).show();
            touchTime = currentTime;
        } else {
            this.finish();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rdobtn_main:
                showFragment(MainFragment.FRAGMENT_TAG);
                break;
            case R.id.rdobtn_topic:
                showFragment(TopicFragment.FRAGMENT_TAG);
                break;
            case R.id.rdobtn_mine:
                showFragment(MineFragment.FRAGMENT_TAG);
                break;
        }
    }
}
