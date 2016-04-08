package com.yanyuanquan.android.jyh.base;

import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by apple on 16/3/14.
 */
public abstract class BaseActivity extends BaseUtilActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
        initData();
        initView();
    }

    /**
     *   初始化视图
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     *  初始化参数
     */
    protected abstract void init();

    public abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }




}
