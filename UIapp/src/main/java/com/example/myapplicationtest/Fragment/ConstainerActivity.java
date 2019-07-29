package com.example.myapplicationtest.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplicationtest.R;

public class ConstainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick{
    private AFragment aFragment;
    private TextView mtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constainer);
        aFragment = (AFragment) AFragment.newfragment("我是参数");
        mtv = findViewById(R.id.tv_title1);
        //把AFragment装入容器
        getFragmentManager().beginTransaction().add(R.id.m_fl,aFragment,"a").commitAllowingStateLoss();
    }
    public void setData(String string){
        mtv.setText("你好");
    }

    @Override
    public void onClick(String text) {
        mtv.setText(text);
    }
}
