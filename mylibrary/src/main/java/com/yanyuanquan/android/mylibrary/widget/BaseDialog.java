package com.yanyuanquan.android.mylibrary.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by apple on 16/3/2.
 */
public class BaseDialog extends Dialog {

    public BaseDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
    public BaseDialog(Context context,int theme) {
        super(context,theme);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

}
