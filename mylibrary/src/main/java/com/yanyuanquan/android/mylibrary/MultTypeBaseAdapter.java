package com.yanyuanquan.android.mylibrary;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by apple on 16/1/18.
 * @description:
 * @projectName:YYQ
 */
public abstract class MultTypeBaseAdapter<T> extends BaseAdapter {
    protected List<T> mDatas;
    protected int viewTypeCount;

    /**
     * @param viewTypeCount 默认小于2时需要去设置 getViewTypeCounts 否则不调用
     */
    public MultTypeBaseAdapter(int viewTypeCount) {
        this.viewTypeCount = viewTypeCount;
        if (viewTypeCount<2){
            viewTypeCount = getViewTypeCounts();
        }
    }

    public MultTypeBaseAdapter() {
        if (viewTypeCount<2){
            viewTypeCount = getViewTypeCounts();
        }
    }

    public void setData(List<T> datas){
        if (datas ==null){
            return;
        }
        mDatas = datas;
        notifyDataSetChanged();
    }
    public void append(List<T> datas){
        if (mDatas ==null)
            mDatas =new ArrayList<>();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    public void append(T t){
        if (mDatas ==null)
            mDatas =new ArrayList<>();
        mDatas.add(t);
        notifyDataSetChanged();
    }

    public void insert(T data,int position){
        if (mDatas==null||mDatas.size()<position){return;}
        mDatas.set(position,data);
        notifyDataSetChanged();
    }
    public void remove(int position){
        if (mDatas==null||mDatas.size()<position){return;}
        mDatas.remove(position);
        notifyDataSetChanged();
    }

    public void appendBefore(List<T> datas){
        if (datas ==null)
            return;
        List<T> list = new ArrayList<>();
        list.addAll(datas);
        if (this.mDatas!=null)
            list.addAll(mDatas);
        this.mDatas = list;
    }

    public void appendBefore(T t){
        if (t == null)
            return;
        List<T> list= new ArrayList<>();
        list.add(t);
        if (mDatas!=null)
            list.addAll(mDatas);

        this.mDatas = list;

    }

    /**
     * 返回Item类型数量 暂时不设置为抽象
     * @return
     */
    protected int getViewTypeCounts(){
        return 1;
    }

    public T getData(int position){
        return mDatas.get(position);
    }


    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract int getItemViewType(int position);

    @Override
    public int getViewTypeCount() {
        return viewTypeCount;
    }

}
