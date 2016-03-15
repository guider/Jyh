package com.yanyuanquan.android.mylibrary.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yanyuanquan.android.mylibrary.RViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<RViewHolder> {
    protected List<T> mList;
    private int layoutId;

    public BaseRecyclerViewAdapter(List<T> mList, int layoutId) {
        this.mList = mList;
        this.layoutId = layoutId;
    }

    public BaseRecyclerViewAdapter(List<T> mList) {
        this.mList = mList;
    }

    public BaseRecyclerViewAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    public BaseRecyclerViewAdapter() {
    }


    public void setData(List<T> datas) {
//        if (datas == null) {
//            return;
//        }
        mList = datas;
        notifyDataSetChanged();
    }



    public void append(List<T> datas) {
        if (mList == null)
            mList = new ArrayList<>();
        mList.addAll(datas);
        notifyDataSetChanged();
    }

    public void append(T t) {
        if (mList == null)
            mList = new ArrayList<>();
        mList.add(t);
        notifyDataSetChanged();
    }

    public void insert(T data, int position) {
        if (mList == null || mList.size() < position) {
            return;
        }
        mList.add(position, data);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (mList == null || mList.size() < position) {
            return;
        }
        mList.remove(position);
        notifyDataSetChanged();
    }

    public void appendBefore(List<T> datas) {
        if (datas == null)
            return;
        List<T> list = new ArrayList<>();
        list.addAll(datas);
        if (this.mList != null)
            list.addAll(mList);
        this.mList = list;
    }

    public void appendBefore(T t) {
        if (t == null)
            return;
        List<T> list = new ArrayList<>();
        list.add(t);
        if (mList != null)
            list.addAll(mList);
        this.mList = list;

    }

    public T getData(int position) {
        return mList.get(position);
    }
    public List<T> getDatas() {
        return mList;
    }


    @Override
    public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        RViewHolder viewHoler = new RViewHolder(view);
        return viewHoler;
    }

    @Override
    public void onBindViewHolder(final RViewHolder holder, int position) {
        if (linstener != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    linstener.onItemClick(holder.getItemView(), holder.getLayoutPosition());
                }
            });
            holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    linstener.onItemLongClick(holder.getItemView(), holder.getLayoutPosition());
                    return true;
                }
            });
        }
        setView(holder, mList.get(position));
        setView(holder, mList.get(position),position);
    }

    protected void setView(RViewHolder holder, T t, int position) {
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public abstract void setView(RViewHolder holer, T t);

    /**
     * 实现RecyclerView 点击事件，onItemClick, onItemLongClick；
     *
     * @deprecated by guider
     */
    private ItemClickLinstener linstener;

    public interface ItemClickLinstener {
        void onItemClick(View itemView, int layoutPosition);

        void onItemLongClick(View itemView, int layoutPosition);
    }

    public void setOnItemClickLinstener(ItemClickLinstener linstener) {
        this.linstener = linstener;
    }


    public void appendDatas(List<T> list) {
        if (mList == null)
            mList = list;
        else
            mList.addAll(list);
        notifyItemRangeChanged(mList.size() - list.size(), mList.size());
    }
/*
  notifyItemChanged(int position)，position数据发生了改变，那调用这个方法，
 就会回调对应position的onBindViewHolder()方法了，当然，因为ViewHolder是复用的，所以如果position在当前屏幕以外，
  也就不会回调了，因为没有意义，下次position滚动会当前屏幕以内的时候同样会调用onBindViewHolder()方法刷新数据了。其他的方法也是同样的道理。

 public final void notifyItemRangeChanged(int positionStart, int itemCount)，
 顾名思义，可以刷新从positionStart开始itemCount数量的item了（这里的刷新指回调onBindViewHolder()方法）。

 public final void notifyItemInserted(int position)，
 这个方法是在第position位置被插入了一条数据的时候可以使用这个方法刷新，注意这个方法调用后会有插入的动画，这个动画可以使用默认的，也可以自己定义。

 public final void notifyItemMoved(int fromPosition, int toPosition)，
 这个方法是从fromPosition移动到toPosition为止的时候可以使用这个方法刷新

 public final void notifyItemRangeInserted(int positionStart, int itemCount)，
 显然是批量添加。

 public final void notifyItemRemoved(int position)，
 第position个被删除的时候刷新，同样会有动画。

 public final void notifyItemRangeRemoved(int positionStart, int itemCount)，
 批量删除。
 */

}
