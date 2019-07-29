package com.example.myapplicationtest.widget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtest.R;
import com.example.myapplicationtest.Toast.ToastUtil;

public class EventActivity extends AppCompatActivity {
    private Button mbt1;
    private MyButton myButton;
    private Button mbtHandle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mbt1 = findViewById(R.id.bt_1);
        myButton = findViewById(R.id.bt_my);
        mbt1.setOnClickListener(new MyonclickListen(EventActivity.this));
        mbtHandle = findViewById(R.id.bt_hd);
        mbtHandle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this,HandleActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity","---onTouch---");
        }
        return false;
    }
}
