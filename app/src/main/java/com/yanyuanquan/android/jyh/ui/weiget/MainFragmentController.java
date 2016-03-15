package com.yanyuanquan.android.jyh.ui.weiget;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.yanyuanquan.android.jyh.ui.inland.InlandFragment;
import com.yanyuanquan.android.mylibrary.base.BaseFragmentController;

/**
 * Created by apple on 16/3/14.
 */
public class MainFragmentController extends BaseFragmentController {

    public static BaseFragmentController getInstance(Activity activity, int containId) {
        if (contrller == null)
            contrller = new MainFragmentController(activity, containId);
        return contrller;
    }

    private MainFragmentController(Activity activity, int containId) {
        super(activity, containId);
    }

    @Override
    public void init(int containId) {
        fragments.add(new InlandFragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment f:fragments){
            ft.add(containId,f);
        }
        ft.commit();
    }
}
