package com.yanyuanquan.android.jyh.ui.trank;

import android.content.Context;
import android.text.AndroidCharacter;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yanyuanquan.android.jyh.R;
import com.yanyuanquan.android.jyh.api.ApiService;
import com.yanyuanquan.android.jyh.api.ApiServiceModel;
import com.yanyuanquan.android.jyh.entity.TrankList;
import com.yanyuanquan.android.mylibrary.AutoViewHolder;
import com.yanyuanquan.android.mylibrary.util.L;
import com.yanyuanquan.android.mylibrary.widget.AutoBaseListFragment;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 16/3/21.
 */
public class TrankFragment extends AutoBaseListFragment<TrankList.DataEntity> {

    @Override
    protected boolean canRefresh() {
        return true;
    }

    @Override
    protected boolean hasModeData() {
        return false;
    }

    @Override
    public int getLayout() {
        return R.layout.item_main;
    }

    @Override
    protected void setListData(TrankList.DataEntity entity, AutoViewHolder holder, Context context) {
        ((TextView) holder.getView(R.id.title)).setText(entity.getTitle());
        ((TextView) holder.getView(R.id.source)).setText(entity.getMall());
        ((TextView) holder.getView(R.id.time)).setText(entity.getPubtime());
        Glide.with(context).load(entity.getImage()).into((ImageView) holder.getView(R.id.image));
    }

    @Override
    protected void initView() {
        ApiServiceModel.getInstance().getService().getTrankList()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<TrankList>() {
                    @Override
                    public void call(TrankList trankList) {
                        setListAdapter();
                        getAdapter().setData(trankList.getData());
                        setRefreshComplete();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        setRefreshComplete();
                        L.e(throwable.toString());

                    }
                });
    }

    @Override
    protected void refresh() {
        initView();
    }

    @Override
    protected void loadMoreData() {

    }
}
