package com.yanyuanquan.android.mylibrary.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanyuanquan.android.mylibrary.AutoBaseAdapter;
import com.yanyuanquan.android.mylibrary.AutoViewHolder;
import com.yanyuanquan.android.mylibrary.R;


/**
 * @Created by apple on 16/1/5.
 * @description:可上啦刷新，下拉加载的ListView，
 * @projectName:YYQ
 */
public abstract class AutoBaseListFragment<T> extends BaseUtilFragment implements SwipeRefreshLayout.OnRefreshListener
        , AutoLoadListView.onLoadMoreLinstener {
    private AutoLoadListView listView;
    private SwipeRefreshLayoutCompat swipeRefreshLayout;
    private View emptyView;
    protected AutoBaseAdapter<T> adapter;
    private View errorView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout root = new FrameLayout(activity);
        //---- For Empty ListVeiw
//        LinearLayout linearLayout = new LinearLayout(activity);
//        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        linearLayout.setGravity(Gravity.CENTER);
//        linearLayout.setVisibility(View.GONE);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleLarge);
//        linearLayout.addView(progressBar, new FrameLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout errView = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.error_view, null);
        errView.setId(R.id.error_view);
        root.addView(errView, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        View progressBar = LayoutInflater.from(getActivity()).inflate(R.layout.progressbar_layout, null);
        root.addView(progressBar, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //---------ListView
        FrameLayout frameLayout = new FrameLayout(activity);
        TextView tv = new TextView(activity);
        tv.setId(R.id.textview);
        tv.setVisibility(View.GONE);
        tv.setText("暂无数据");
        tv.setGravity(Gravity.CENTER);
        frameLayout.addView(tv, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        AutoLoadListView lv = new AutoLoadListView(activity);
        lv.setId(R.id.listview);
        frameLayout.addView(lv, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        SwipeRefreshLayoutCompat swipeRefreshLayout = new SwipeRefreshLayoutCompat(activity, lv);
        swipeRefreshLayout.setId(R.id.swiperefreshlayout);
        swipeRefreshLayout.addView(frameLayout, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        root.addView(swipeRefreshLayout, new SwipeRefreshLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        //------------root layoutparmas
        root.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        setViewShown(false);
        initAdapter();
        initView();
        initSetting();
    }


    private void initSetting() {
        setSwipeRefresLayoutCanRefresh(canRefresh());
        setHasMore(hasModeData());
    }

    protected abstract boolean canRefresh();

    protected abstract boolean hasModeData();

    private void initAdapter() {
        adapter = new AutoBaseAdapter<T>() {
            @Override
            protected void setView(T t, AutoViewHolder holder, Context context) {
                setListData(t, holder, context);
            }
        };
        adapter.setLayoutId(getLayout());
    }

    protected AutoBaseAdapter<T> getAdapter() {
        return adapter;
    }

    public abstract int getLayout();

    protected abstract void setListData(T t, AutoViewHolder holder, Context context);


    protected abstract void initView();

    private void init() {
        listView = (AutoLoadListView) getView().findViewById(R.id.listview);
        listView.setOnLoadMoreLinstener(this);

        swipeRefreshLayout = (SwipeRefreshLayoutCompat) getView().findViewById(R.id.swiperefreshlayout);
        swipeRefreshLayout.setOnRefreshListener(this);

        emptyView = getView().findViewById(R.id.textview);
        errorView = getView().findViewById(R.id.error_view);
        setdiverHeight(0);
    }

    public void setListAdapter() {
        if (listView == null) {
            throw new IllegalStateException("listview is null");
        }
        listView.setEmptyView(emptyView);
        listView.setAdapter(adapter);
        setViewShown(true);

    }


    protected void setSwipeRefresLayoutCanRefresh(boolean canRefresh) {
        swipeRefreshLayout.setCanRefresh(canRefresh);
        if (canRefresh) {
            setOnLoadModeListener();
        }
    }

    protected AutoLoadListView getListView() {
        return listView;
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    protected abstract void refresh();

    protected void setRefreshComplete() {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing())
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);

                }
            }, 500);
    }

    protected void setLoadMoreComplete() {
        listView.onLoadMoreComplete();
    }

    protected void setHasMore(boolean hasMore) {
        listView.setHasMore(hasMore);
    }

    protected void setOnLoadModeListener() {
        listView.setOnLoadMoreLinstener(this);
    }

    protected void setdiverHeight(int height) {
        listView.setDividerHeight(0);
    }

    protected void setDivider(int deawableId) {
        listView.setDivider(getResources().getDrawable(R.drawable.shape_bg_line_tansparent));
    }

    @Override
    public void loadMore() {
        loadMoreData();
    }

    protected abstract void loadMoreData();

    public void setListViewEmptyView(View view) {
        if (view == null)
            return;
        view.setId(R.id.empty_view);
        ((ViewGroup) getListView().getParent()).removeView(((ViewGroup) (getListView().getParent())).findViewById(R.id.textview));
        ((ViewGroup) getListView().getParent()).addView(view, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        emptyView = getView().findViewById(R.id.empty_view);
    }

    public void setErrorView(View view) {
        if (view == null)
            return;
        ((ViewGroup) getView()).removeView(((ViewGroup) getView()).findViewById(R.id.error_view));
        view.setId(R.id.error_view);
        ((ViewGroup) getView()).addView(view, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        emptyView = ((ViewGroup) getListView().getParent()).findViewById(R.id.error_view);

    }

    public void shownErrorView(boolean show) {
        swipeRefreshLayout.setVisibility(show ? View.GONE : View.VISIBLE);
        getView().findViewById(R.id.progress_linear).setVisibility(show ? View.GONE : View.VISIBLE);
        errorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }


    protected void setViewShown(boolean mListViewShown) {
        shownErrorView(false);
        View progressLinear = getView().findViewById(R.id.progress_linear);
        if (mListViewShown) {
            progressLinear.setVisibility(View.GONE);
            swipeRefreshLayout.setVisibility(View.VISIBLE);
        } else {
            swipeRefreshLayout.setVisibility(View.GONE);
        }
    }

    protected void setEmptyText(String msg) {
        TextView textView = (TextView) getView().findViewById(R.id.textview);
        if (textView != null)
            textView.setText(msg);
    }
}

