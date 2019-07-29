package com.example.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.myapplicationtest.Toast.ToastUtil;

public class PopupActivity extends AppCompatActivity {
    private Button mBt_popup;
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        mBt_popup = findViewById(R.id.bt_popup);
        mBt_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_popup,null);
                TextView tv = view.findViewById(R.id.tv_good);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        ToastUtil.showMsg(PopupActivity.this,"好");
                    }
                });
                popupWindow = new PopupWindow(view,mBt_popup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setFocusable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(mBt_popup);
            }
        });
    }
}
