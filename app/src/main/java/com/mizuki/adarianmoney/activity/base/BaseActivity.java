package com.mizuki.adarianmoney.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * 这是基类
 */

public class BaseActivity extends Activity {
    protected void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    protected void openActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
}
