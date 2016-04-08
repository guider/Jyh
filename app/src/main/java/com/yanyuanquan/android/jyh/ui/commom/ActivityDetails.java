package com.yanyuanquan.android.jyh.ui.commom;

import android.os.Bundle;

import com.yanyuanquan.android.jyh.R;
import com.yanyuanquan.android.jyh.api.ApiServiceModel;
import com.yanyuanquan.android.jyh.base.BaseActivity;
import com.yanyuanquan.android.mylibrary.widget.AutoWebView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ActivityDetails extends BaseActivity {
    String url = ApiServiceModel.baseUrl+"api/showdetail.php?id=%d&btn=1";
    @Bind(R.id.auto_web)
    AutoWebView autoWeb;

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        int id  = getIntent().getIntExtra(this.getClass().getName(),0);
        if (id==0)
            return;
        autoWeb.loadUrl(String.format(url,id));
    }

    @Override
    protected void init() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }


}
