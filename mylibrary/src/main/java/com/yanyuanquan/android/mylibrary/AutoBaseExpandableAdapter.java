package com.yanyuanquan.android.mylibrary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.List;

/**
 * @Created by apple on 16/2/18.
 * @description:
 * @projectName:YYQ
 */
public abstract class AutoBaseExpandableAdapter<T,M> extends BaseExpandableListAdapter {
    private List<T> groupList;
    private List<M> childList;
    private int groupLayoutId ,childLayoutId;

    public AutoBaseExpandableAdapter(int groupLayoutId, int childLayoutId) {
        this.groupLayoutId = groupLayoutId;
        this.childLayoutId = childLayoutId;
    }

    public void setData(List<T> groupList, List<M> childList){
        this.groupList = groupList;
        this.childList =childList;
    }

    public void setGroupList(List<T> groupList) {
        this.groupList = groupList;
    }

    public void setChildList(List<M> childList) {
        this.childList = childList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        AutoViewHolder holder = AutoViewHolder.getInstance(parent,convertView,groupLayoutId);
        setGroupView(groupPosition,groupList.get(groupPosition),parent.getContext(),isExpanded);
        return holder.getConvertView();
    }

    protected abstract void setGroupView(int groupPosition, T t, Context context, boolean isExpanded);


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        AutoViewHolder holder =AutoViewHolder.getInstance(parent,convertView,childLayoutId);
        setChildView(groupPosition,childPosition,isLastChild,convertView,parent.getContext());
        return null;
    }

    protected abstract void setChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, Context context);


}
