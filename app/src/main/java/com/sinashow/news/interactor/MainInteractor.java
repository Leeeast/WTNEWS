package com.sinashow.news.interactor;

import com.sinashow.news.bean.UserInfo;

/**
 * Created by Administrator on 2018/1/15.
 */

public interface MainInteractor {
    /**
     * 判断登录状态
     *
     * @return
     */
    boolean isLogin();

    /**
     * 加载用户信息并更新用户数据
     */
    void loadUserInfo(LoadUserInfoListener listener);

    /**
     * 用户信息加载回调
     */
    interface LoadUserInfoListener {
        void onComplete(UserInfo userInfo);
    }
}
