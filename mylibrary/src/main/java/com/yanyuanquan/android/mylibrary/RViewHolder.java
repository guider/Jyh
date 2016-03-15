package com.yanyuanquan.android.mylibrary;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * @Created by apple on 15/12/24.
 * @description:
 * @projectName:YYQDYB
 */
public class RViewHolder extends RecyclerView.ViewHolder {
    public RViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<View>();
        this.itemView = itemView;
    }

    private SparseArray<View> views;
    private View itemView;
    public <T extends View> T getView(int viewId){
        View view = views.get(viewId);
        if (view==null){
            view = itemView.findViewById(viewId);
        }
        return (T)view;
    }
    public View getItemView(){
        return itemView;
    }

}
