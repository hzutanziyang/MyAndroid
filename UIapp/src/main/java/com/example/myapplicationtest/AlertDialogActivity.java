package com.example.myapplicationtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplicationtest.Toast.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {
    private Button mbtAlertDialog1,mbtAlertDialog2,mbtAlertDialog3,mbtAlertDialog4,mbtAlertDialog5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        mbtAlertDialog1 = findViewById(R.id.ad_1);
        mbtAlertDialog2 = findViewById(R.id.ad_2);
        mbtAlertDialog3 = findViewById(R.id.ad_3);
        mbtAlertDialog4 = findViewById(R.id.ad_4);
        mbtAlertDialog5 = findViewById(R.id.ad_5);
        setOnclicklistener();
    }
    private void setOnclicklistener(){
        myOnclick onclick = new myOnclick();
        mbtAlertDialog1.setOnClickListener(onclick);
        mbtAlertDialog2.setOnClickListener(onclick);
        mbtAlertDialog3.setOnClickListener(onclick);
        mbtAlertDialog4.setOnClickListener(onclick);
        mbtAlertDialog5.setOnClickListener(onclick);

    }

    class myOnclick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ad_1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("请回答").setMessage("你吃过饭没").setPositiveButton("吃了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"吃得很饱");
                        }
                    }).setNeutralButton("准备吃", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"在路上");
                        }
                    }).setNegativeButton("没吃", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"不吃了");
                        }
                    }).show();
                    break;
                case R.id.ad_2:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] array2 = new String[]{"男","女"};
                    builder2.setTitle("请选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array2[which]);
                        }
                    }).show();
                    break;
                case R.id.ad_3:
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] array3 = new String[]{"男","女"};
                    builder3.setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array3[which]);
                        }
                    }).setTitle("请选择性别").show();
                    break;
                case R.id.ad_4:
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    final String[] array4 = new String[]{"吃饭","睡觉","打豆豆"};
                    final boolean[] isselected = new boolean[]{false,false,false};
                    builder4.setMultiChoiceItems(array4, isselected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(AlertDialogActivity.this,array4[which]+isChecked);
                        }
                    }).setTitle("选择爱好").show();
                    break;
                case R.id.ad_5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.dialog_style,null);
                    builder5.setTitle("请登录").setView(view).show();
                    break;
            }
        }
    }
}
