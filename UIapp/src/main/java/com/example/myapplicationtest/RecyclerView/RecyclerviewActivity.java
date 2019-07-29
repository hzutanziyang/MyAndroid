package com.example.myapplicationtest.RecyclerView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtest.R;

public class RecyclerviewActivity extends AppCompatActivity {
    private Button bt_1;
    private Button bt_2;
    private Button bt_3;
    private Button bt_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        bt_1 = findViewById(R.id.bt_re1);
        bt_2 = findViewById(R.id.bt_re2);
        bt_3 = findViewById(R.id.bt_re3);
        bt_4 = findViewById(R.id.bt_re4);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerviewActivity.this,RecyclerLinearViewActivity.class);
                startActivity(intent);
            }
        });
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerviewActivity.this,HorRecyclerActivity.class);
                startActivity(intent);
            }
        });
        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerviewActivity.this,GridRecyclerActivity.class);
                startActivity(intent);
            }
        });
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerviewActivity.this,PuRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }

}
