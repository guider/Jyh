package com.yanyuanquan.android.mylibrary.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import java.util.ArrayList;


/**
 * @Created by apple on 16/3/4.
 * @description:
 * @projectName:YYQ
 */
public abstract class BaseFragmentController {
    protected static BaseFragmentController contrller;
    protected ArrayList<Fragment> fragments;
    protected FragmentManager fm;

    protected BaseFragmentController(Activity activity, int containId) {
        fm = activity.getFragmentManager();
        fragments = new ArrayList<>();
        init(containId);
    }

    public abstract void init(int containId);


    public void showFragment(int position) {
        hideFrgament();
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragments.get(position));
        ft.commit();
    }

    public void hideFrgament() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment f : fragments) {
            if (f != null) {
                ft.hide(f);
            }
        }
        ft.commit();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }

    public void onDestory() {
        contrller = null;
    }
}

