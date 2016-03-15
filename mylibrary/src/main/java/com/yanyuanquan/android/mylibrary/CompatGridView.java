package com.yanyuanquan.android.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @Created by apple on 16/1/29.
 * @description:
 * @projectName:YYQ
 */
public class CompatGridView extends GridView {
    public CompatGridView(Context context) {
        super(context);
    }

    public CompatGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompatGridView(Context context, AttributeSet attrs,
                          int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

