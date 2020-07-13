package com.rzhy.fjxhznfz.ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 */
public abstract class BasicAdapter<T> extends BaseAdapter {
    protected List<T> data;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public BasicAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public BasicAdapter(Context context, List<T> data) {
        this.data = data;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public T getItem(int position) {
        return data == null ? null : data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected void clear() {
        data.clear();
    }

    public void addData(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return this.data;
    }
}
