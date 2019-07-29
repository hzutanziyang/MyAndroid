package com.example.myapplicationtest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtest.Data.DataActivity;
import com.example.myapplicationtest.Data.SharepreferencesActivity;
import com.example.myapplicationtest.Fragment.AFragment;
import com.example.myapplicationtest.widget.EventActivity;

public class MainActivity extends AppCompatActivity {
    private Button mbtui;
    private Button mbtevent;
    private Button mbtdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtui = findViewById(R.id.bt_ui);
        mbtevent = findViewById(R.id.bt_event);
        mbtdata = findViewById(R.id.bt_data);
        myOnclick onclick = new myOnclick();
        mbtui.setOnClickListener(onclick);
        mbtevent.setOnClickListener(onclick);
        mbtdata.setOnClickListener(onclick);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }

    class myOnclick implements View.OnClickListener{
        Intent intent = null;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_ui:
                    intent = new Intent(MainActivity.this,UIActivity.class);
                    break;
                case R.id.bt_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.bt_data:
                    intent = new Intent(MainActivity.this, DataActivity.class);
            }
            startActivity(intent);
        }
    }
}
