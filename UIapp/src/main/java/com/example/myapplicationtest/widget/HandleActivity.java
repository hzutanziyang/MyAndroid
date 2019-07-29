package com.example.myapplicationtest.widget;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplicationtest.EditTextActivity;
import com.example.myapplicationtest.R;
import com.example.myapplicationtest.Toast.ToastUtil;

public class HandleActivity extends AppCompatActivity {
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);
//        handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandleActivity.this, EditTextActivity.class);
//
//                startActivity(intent);
//            }
//        }, 3000);
        handler = new Handler();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        }.start();
    }
}
