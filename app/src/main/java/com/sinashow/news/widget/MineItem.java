package com.sinashow.news.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sinashow.news.R;

/**
 * Created by Administrator on 2018/1/15.
 */

public class MineItem extends FrameLayout {
    private Context mContext;
    private View mRootView;
    private String mItemText;
    private Drawable mItemIcon;
    private boolean mIsShowLine;

    public MineItem(@NonNull Context context) {
        this(context, null);
    }

    public MineItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MineItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        setCustomAttributes(attrs);
        init();
    }

    /**
     * 获取属性
     *
     * @param attrs
     */
    private void setCustomAttributes(AttributeSet attrs) {
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.MineItem);
        mItemText = ta.getString(R.styleable.MineItem_item_title);
        mItemIcon = ta.getDrawable(R.styleable.MineItem_item_icon);
        mIsShowLine = ta.getBoolean(R.styleable.MineItem_item_show_line, false);
        ta.recycle();
    }

    private void init() {
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.layout_mine_item, this, true);
        ImageView ivItemIcon = mRootView.findViewById(R.id.iv_icon);
        TextView tvItemTitle = mRootView.findViewById(R.id.tv_title);
        View itemLine = mRootView.findViewById(R.id.item_line);

        if (mItemIcon != null) {
            ivItemIcon.setImageDrawable(mItemIcon);
        }
        if (!TextUtils.isEmpty(mItemText)) {
            tvItemTitle.setText(mItemText);
        }
        itemLine.setVisibility(mIsShowLine ? View.VISIBLE : View.GONE);
    }
}
