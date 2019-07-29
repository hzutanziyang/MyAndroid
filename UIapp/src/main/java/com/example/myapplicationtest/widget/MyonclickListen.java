package com.example.myapplicationtest.widget;

import android.app.Activity;
import android.view.View;

import com.example.myapplicationtest.Toast.ToastUtil;

/**
 * Created by 洋 on 2019/3/10.
 */

public class MyonclickListen implements View.OnClickListener {
    private Activity activity;
    public MyonclickListen(Activity activity){
        this.activity = activity;
    }
    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(activity,"Click...");
    }
}
