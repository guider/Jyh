package com.yanyuanquan.android.jyh.ui.global;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yanyuanquan.android.jyh.R;
import com.yanyuanquan.android.jyh.api.ApiService;
import com.yanyuanquan.android.jyh.api.ApiServiceModel;
import com.yanyuanquan.android.jyh.entity.Main;
import com.yanyuanquan.android.jyh.ui.commom.ActivityDetails;
import com.yanyuanquan.android.jyh.ui.inland.InlandFragment;
import com.yanyuanquan.android.mylibrary.AutoViewHolder;
import com.yanyuanquan.android.mylibrary.widget.AutoBaseListFragment;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 16/3/14.
 */
public class GlobalFragment extends InlandFragment implements AdapterView.OnItemClickListener{

    @Override
    protected boolean canRefresh() {
        return true;
    }

    @Override
    protected boolean hasModeData() {
        return true;
    }

    @Override
    public int getLayout() {
        return R.layout.item_main;
    }

    @Override
    protected void setListData(Main.DataEntity entity, AutoViewHolder holder, Context context) {
        ((TextView) holder.getView(R.id.title)).setText(entity.getTitle());
        ((TextView) holder.getView(R.id.source)).setText(entity.getMall());
        ((TextView) holder.getView(R.id.time)).setText(entity.getPubtime());
        Glide.with(context).load(entity.getImage()).into((ImageView) holder.getView(R.id.image));
    }


    @Override
    protected void initView() {
        getListView().setOnItemClickListener(this);
        initData();
    }

    @Override
    protected void refresh() {
        initData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (adapter != null&&adapter.getData(position)!=null){
            Intent intent = new Intent(activity, ActivityDetails.class);
            intent.putExtra(ActivityDetails.class.getName(),adapter.getData(position).getId());
            activity.startActivity(intent);
        }
    }

    @Override
    protected void loadMoreData() {
        ApiServiceModel.getInstance().getService()
                .getGlobalList("us","30",String.valueOf(adapter.getData(adapter.getCount()-1).getId()))
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Main>() {
                    @Override
                    public void call(Main main) {
                        getAdapter().append(main.getData());
                        setHasMore(true);
                        setLoadMoreComplete();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        setLoadMoreComplete();
                        setHasMore(false);
                    }
                });
    }


    protected void initData() {
        ApiServiceModel.getInstance().getService().getGlobalList("us","30","")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Main>() {
                    @Override
                    public void call(Main main) {
                        setListAdapter();
                        getAdapter().setData(main.getData());
                        setHasMore(true);
                        setRefreshComplete();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        setRefreshComplete();
                        setHasMore(false);
                    }
                });
    }
}
