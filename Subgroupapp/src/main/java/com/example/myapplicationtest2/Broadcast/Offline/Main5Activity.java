package com.example.myapplicationtest2.Broadcast.Offline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.myapplicationtest2.R;

public class Main5Activity extends BaseActivity {

    private Button forceOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        forceOffline = findViewById(R.id.bt_send);
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.myapplicationtest2.Broadcast.Offline.FORCE_Offline");
                sendBroadcast(intent);
            }
        });
    }
}
