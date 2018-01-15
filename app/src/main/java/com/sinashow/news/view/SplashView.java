/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sinashow.news.view;

/**
 * Author:  LiDongliang
 * Date:    2018/1/14.
 * Description:启动页
 */
public interface SplashView {
    /**
     * 倒计时
     */
    void showCountDown();

    /**
     * 显示广告
     */
    void showAD();


    /**
     * 跳到主页
     * needDelay true:延迟跳转
     */
    void jump2Main(boolean needDelay);

    /**
     * 跳到引导页
     * needDelay true:延迟跳转
     */
    void jump2Guide(boolean needDelay);
}
