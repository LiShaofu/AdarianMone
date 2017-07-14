package com.mizuki.adarianmoney.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * BaseAdapter 的基类
 * 抽象类
 * 抽象方法：getView()
 */

public abstract class SimpleBaseAdapter extends BaseAdapter {
    protected Context context = null;
    protected List datas = null;
    protected LayoutInflater layoutInflater = null;

    public SimpleBaseAdapter(Context context, List datas) {
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);//初始化
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
