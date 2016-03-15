package com.yanyuanquan.android.mylibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * @Created by apple on 16/2/18.
 * @description:
 * @projectName:YYQ
 */
public class CompatExpandableListView extends ExpandableListView {
    public CompatExpandableListView(Context context) {
        super(context);
    }

    public CompatExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompatExpandableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
