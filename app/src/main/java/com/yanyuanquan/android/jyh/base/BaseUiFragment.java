package com.yanyuanquan.android.jyh.base;

import android.app.Activity;
import android.app.Fragment;

/**
 * Created by apple on 16/3/14.
 */
public class BaseUiFragment extends Fragment {

    protected Activity activity;

    @Override
    public void onAttach(Activity activity) {
        this.activity =activity;
        super.onAttach(activity);
    }
}
