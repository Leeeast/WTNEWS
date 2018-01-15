package com.sinashow.news.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/15.
 */

public class Category implements Serializable {
    private String l_id;
    private String label;

    public String getL_id() {
        return l_id;
    }

    public String getLabel() {
        return label;
    }

}
