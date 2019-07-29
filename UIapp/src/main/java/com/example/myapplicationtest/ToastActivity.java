package com.example.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.myapplicationtest.Toast.ToastUtil;

import java.util.zip.Inflater;

public class ToastActivity extends AppCompatActivity {
    private Button mbt_toast_1, mbt_toast_2, mbt_toast_3, mbt_toast_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mbt_toast_1 = findViewById(R.id.bt_toast_1);
        mbt_toast_2 = findViewById(R.id.bt_toast_2);
        mbt_toast_3 = findViewById(R.id.bt_toast_3);
        mbt_toast_4 = findViewById(R.id.bt_toast_4);
        MyonClick myonClick = new MyonClick();
        mbt_toast_1.setOnClickListener(myonClick);
        mbt_toast_2.setOnClickListener(myonClick);
        mbt_toast_3.setOnClickListener(myonClick);
        mbt_toast_4.setOnClickListener(myonClick);
    }

    class MyonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_toast_1:
                    Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_LONG).show();
                    break;
                case R.id.bt_toast_2:
                    Toast mCentertoast = Toast.makeText(getApplicationContext(), "居中Toast", Toast.LENGTH_LONG);
                    mCentertoast.setGravity(Gravity.CENTER, 0, 0);
                    mCentertoast.show();
                    break;
                case R.id.bt_toast_3:
                    Toast toast2 = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.m_toast,null);
                    ImageView imageView = view.findViewById(R.id.t_mv);
                    TextView textView = view.findViewById(R.id.t_tv);
                    imageView.setImageResource(R.drawable.feiji);
                    textView.setText("自定义Toast");
                    toast2.setView(view);
                    toast2.show();
                    break;
                case R.id.bt_toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"封装Toast");
                    break;

            }
        }
    }
}
