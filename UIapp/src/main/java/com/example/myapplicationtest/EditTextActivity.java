package com.example.myapplicationtest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplicationtest.Toast.ToastUtil;

public class EditTextActivity extends AppCompatActivity {
    private Button mbt_editText;
    String mes = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mbt_editText = (Button) findViewById(R.id.bt_1);
        mbt_editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.bt_1)
                Toast.makeText(EditTextActivity.this,"登陆",Toast.LENGTH_SHORT).show();
            }
        });
        Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        ToastUtil.showMsg(EditTextActivity.this,"handler接受到信息");
                }
            }
        };

    }
}
