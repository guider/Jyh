package com.yanyuanquan.android.jyh.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 16/3/14.
 */
public class BaseUiAcitivity extends BaseUtilActivity{
    public static List<Activity> activities = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        activities.add(this);
    }
    public void exit() {
        if (activities.size() > 0) {
            int size = activities.size() - 1;
            for (int i = size; i >= 0; i--) {
                Activity activity = activities.get(i);
                if (activity != null && activity != this)
                    activity.finish();
            }
        }
    }

    public static Activity getCurrentActivity() {
        if (activities.size() > 0)
            return activities.get(activities.size() - 1);
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activities.remove(this);
    }
}
