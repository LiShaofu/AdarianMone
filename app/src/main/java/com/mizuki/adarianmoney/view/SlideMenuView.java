package com.mizuki.adarianmoney.view;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.mizuki.adarianmoney.R;
import com.mizuki.adarianmoney.adapter.SlideMenuAdapter;
import com.mizuki.adarianmoney.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动菜单
 */

public class SlideMenuView {
    private Activity activity;
    private List<SlideMenuItem> menuList;
    private boolean isClosed;
    private RelativeLayout bottomBoxLayout;

    public SlideMenuView(Activity activity) {
        this.activity = activity;
        initVariable();
        initView();
        initListeners();
    }

    //初始化监听
    private void initListeners() {
        bottomBoxLayout.setOnClickListener(new OnSlideMenuClik());
    }

    //初始化控件
    private void initView() {
        bottomBoxLayout = (RelativeLayout) activity.findViewById(R.id.include_bottom);
    }

    //初始化变量
    private void initVariable() {
        menuList = new ArrayList<>();
        isClosed = true;
    }

    private class OnSlideMenuClik implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.include_bottom:
                    toggle();
                    break;
            }
        }
    }


    //关闭菜单
    private void close() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
//                dip2px(Context context, float dipValue)
                RelativeLayout.LayoutParams.MATCH_PARENT, new DisplayUtil().dip2px(activity, 68));
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomBoxLayout.setLayoutParams(layoutParams);
        isClosed = true;
    }

    //打开菜单
    private void open() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        layoutParams.addRule(RelativeLayout.BELOW, R.id.include_bottom);
        bottomBoxLayout.setLayoutParams(layoutParams);
        isClosed = false;
    }

    private void toggle() {
        if (isClosed) {
            open();
        } else {
            close();
        }
    }

    //添加菜单项
    public void add(SlideMenuItem slideMenuItem) {
        menuList.add(slideMenuItem);
    }

    //绑定数据源
    public void bindList() {
        SlideMenuAdapter adapter = new SlideMenuAdapter(activity, menuList);
        ListView listView = (ListView) activity.findViewById((R.id.slide_list_lv));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnSlideMenuItemClick());//点击监听
    }

    //点击监听的实现类
    private class OnSlideMenuItemClick implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }
}
