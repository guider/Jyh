package com.yanyuanquan.android.mylibrary.widget;

import android.app.Activity;
import android.app.Fragment;

/**
 * Created by apple on 16/3/14.
 */
public class BaseUtilFragment extends Fragment {
    protected Activity activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity =activity;
    }
}
