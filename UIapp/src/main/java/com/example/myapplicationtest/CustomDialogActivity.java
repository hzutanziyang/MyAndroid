package com.example.myapplicationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplicationtest.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {
    private Button mbt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mbt1 = findViewById(R.id.bt_CustomDialog);
        mbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog  = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMassage("确定要删除该项吗？").setCancel("取消", new CustomDialog.IonCancelListener() {
                    @Override
                    public void onCencel(CustomDialog dialog) {
                        Toast.makeText(CustomDialogActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                }).setComfirm("确定", new CustomDialog.IonComfirmListener() {
                    @Override
                    public void onComfirm(CustomDialog dialog) {
                        Toast.makeText(CustomDialogActivity.this,"确定",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}
