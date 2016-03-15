package com.yanyuanquan.android.jyh;

import android.os.Handler;
import android.os.Looper;

import org.litepal.LitePalApplication;

/**
 * Created by apple on 16/3/14.
 */
public class App extends LitePalApplication {
    public static Handler handler;
    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
        handler = new Handler(Looper.getMainLooper());
        init();
    }

    private void init() {

    }

    public static Handler getHandler(){
        return handler;
    }
}
