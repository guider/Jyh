package com.yanyuanquan.android.jyh.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by apple on 16/3/14.
 */
public abstract class BaseFragment extends BaseUtilFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        initData();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void init();
    protected abstract void initData();
    protected abstract void initView();


    @Override
    public void onDetach() {
        super.onDetach();
        ButterKnife.unbind(this);
    }
}
