package com.mizuki.adarianmoney.activity;

import android.os.Bundle;
import android.widget.GridView;

import com.mizuki.adarianmoney.R;
import com.mizuki.adarianmoney.activity.base.FrameActivity;
import com.mizuki.adarianmoney.adapter.AppGridAdapter;

public class MainActivity extends FrameActivity {
    private GridView main_body_gv;
    private AppGridAdapter gridAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appendMainBody(R.layout.main_body);
        initVariable();
        initView();
        initListeners();
        initData();
        createSlideMenu(R.array.SlideMenuActivityMain);
    }

    //初始化变量
    private void initVariable() {
        gridAdapter = new AppGridAdapter(this);
    }

    //控件初始化
    private void initView() {
        main_body_gv = (GridView) findViewById(R.id.main_body_gv);
    }

    //初始化监听
    private void initListeners() {

    }

    //绑定数据
    private void initData() {
        main_body_gv.setAdapter(gridAdapter);
    }
}
