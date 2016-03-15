package com.yanyuanquan.android.mylibrary.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.yanyuanquan.android.mylibrary.R;

/**
 * Created by apple on 16/3/14.
 */
public class ButtomBar extends LinearLayout {

    public ButtomBar(Context context) {
        this(context, null);
    }

    public ButtomBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ButtomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = getContext().obtainStyledAttributes(attrs,R.styleable.ButtomBar);


        ta.recycle();
    }
}
