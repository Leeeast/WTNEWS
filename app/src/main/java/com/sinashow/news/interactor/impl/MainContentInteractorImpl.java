package com.sinashow.news.interactor.impl;

import com.github.obsessive.library.utils.GsonTools;
import com.sinashow.news.bean.Category;
import com.sinashow.news.constant.Constant;
import com.sinashow.news.interactor.MainContentInteractor;
import com.sinashow.news.utils.RequestUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;

/**
 * Created by Administrator on 2018/1/15.
 */

public class MainContentInteractorImpl implements MainContentInteractor {
    @Override
    public void loadCategory(final LoadCategoryListener listener) {
        RequestUtil.request(true, Constant.URL_TABLE_LIST, null, 10, new RequestUtil.RequestListener() {
            @Override
            public void onSuccess(boolean isSuccess, String obj, int id) {
                if (isSuccess) {
                    try {
                        JSONObject jsonObject = new JSONObject(obj);
                        boolean success = jsonObject.optBoolean("success");
                        if (success) {
                            String tabArray = jsonObject.optString("data");
                            List<Category> categoryList = GsonTools.parseDatas(tabArray, Category.class);
                            listener.onSuccess(categoryList);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.onFailed(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    listener.onFailed(null);
                }
            }

            @Override
            public void onFailed(Call call, Exception e, int id) {
                listener.onFailed(e.getMessage());
            }
        });
    }
}
