package com.yanyuanquan.android.mylibrary.util;

import android.util.Log;

/**
 * Created by apple on 16/3/14.
 */
public class L {
    private boolean isDebug = true;

    public static void e(String msg){
        Log.e("zjw",msg+" <<---------");
    }
    public static void d(String msg){
        Log.d("zjw",msg+" <<---------");
    }
    public static void i(String msg){
        Log.i("zjw",msg+" <<---------");
    }
    public static void w(String msg){
        Log.w("zjw",msg+" <<---------");
    }
}
