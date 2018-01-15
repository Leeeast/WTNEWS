package com.sinashow.news.utils;

import android.content.Context;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2018/1/15.
 */

public class TitleBarAdapterUtil {
    public static void adapterTitleBar(Context context, FrameLayout rootView) {
        if (context != null && rootView != null) {
            int statusBarHeight = DeviceUtils.getStatusBarHeight(context);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rootView.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            rootView.setLayoutParams(layoutParams);
        }
    }
}
