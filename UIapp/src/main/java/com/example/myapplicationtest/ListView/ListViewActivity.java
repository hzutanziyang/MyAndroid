package com.example.myapplicationtest.ListView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplicationtest.R;

/**
 * Created by 洋 on 2018/10/6.
 */

public class ListViewActivity extends AppCompatActivity {
    private ListView mlistView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mlistView = findViewById(R.id.lv_1);
        mlistView.setAdapter(new ListAdapter(ListViewActivity.this));
    }

}
