package com.sinashow.news.view;

import com.sinashow.news.bean.UserInfo;

/**
 * Created by Administrator on 2018/1/15.
 */

public interface MainView {
    /**
     * 更新用户信息
     *
     * @param isLogion
     * @param userInfo
     */
    void updateUserInfo(boolean isLogion, UserInfo userInfo);
}
