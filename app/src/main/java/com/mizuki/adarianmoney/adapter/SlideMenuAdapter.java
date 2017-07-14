package com.mizuki.adarianmoney.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mizuki.adarianmoney.R;
import com.mizuki.adarianmoney.adapter.base.SimpleBaseAdapter;
import com.mizuki.adarianmoney.view.SlideMenuItem;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */

public class SlideMenuAdapter extends SimpleBaseAdapter {
    public SlideMenuAdapter(Context context, List datas) {
        super(context, datas);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.slide_menu_list_item, null);
            holder = new Holder();
            holder.menu_name_tv = (TextView) convertView.findViewById(R.id.slide_menu_list_item_tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();

        }
        SlideMenuItem item = (SlideMenuItem) datas.get(position);
        holder.menu_name_tv.setText(item.getTitle());

        return convertView;
    }

    class Holder {
        TextView menu_name_tv;
    }
}
