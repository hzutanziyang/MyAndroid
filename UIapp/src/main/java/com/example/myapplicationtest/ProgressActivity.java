package com.example.myapplicationtest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplicationtest.Toast.ToastUtil;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mpb3;
    private Button mbutton,mProgressDialog1, mProgressDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mpb3 = findViewById(R.id.pb3);
        mbutton = findViewById(R.id.mpg1);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        mProgressDialog1 = findViewById(R.id.bt_ProgressDialog1);
        mProgressDialog2 = findViewById(R.id.bt_ProgressDialog2);
        mProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog1 = new ProgressDialog(ProgressActivity.this);
                progressDialog1.setTitle("提示");
                progressDialog1.setMessage("正在加载");
                progressDialog1.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this,"取消加载");
                    }
                });
                progressDialog1.show();
            }
        });
        mProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog2 = new ProgressDialog(ProgressActivity.this);
                progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog2.setTitle("提示");
                progressDialog2.setMessage("正在加载");
                progressDialog2.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(ProgressActivity.this,"棒棒");
                    }
                });
                progressDialog2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this,"取消加载");
                    }
                });
                progressDialog2.show();
            }
        });
    }


     Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(mpb3.getProgress()<100){
                handler.postDelayed(runnable,500);
            }else{
                Toast.makeText(ProgressActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mpb3.setProgress(mpb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}
