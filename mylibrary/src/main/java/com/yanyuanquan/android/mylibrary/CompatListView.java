package com.yanyuanquan.android.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @Created by apple on 16/1/31.
 * @description:
 * @projectName:YYQ
 */
public class CompatListView extends ListView {


    public CompatListView(Context context) {
        super(context);
    }

    public CompatListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompatListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
