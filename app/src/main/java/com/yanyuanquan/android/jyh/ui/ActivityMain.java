package com.yanyuanquan.android.jyh.ui;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.yanyuanquan.android.jyh.R;
import com.yanyuanquan.android.jyh.base.BaseActivity;
import com.yanyuanquan.android.jyh.ui.weiget.MainFragmentController;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityMain extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    MainFragmentController contrller;
    @Bind(R.id.radiogroup)
    RadioGroup radiogroup;

    @Override
    protected void initView() {
        contrller.showFragment(0);
    }

    @Override
    protected void initData() {
        radiogroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void init() {
        contrller = (MainFragmentController) MainFragmentController.getInstance(this,R.id.framelayout);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.internal:
                contrller.showFragment(0);
                break;
            case R.id.global:
                contrller.showFragment(1);
                break;
            case R.id.collect:
                contrller.showFragment(2);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contrller.onDestory();
    }
}
