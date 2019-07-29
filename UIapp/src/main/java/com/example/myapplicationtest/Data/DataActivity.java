package com.example.myapplicationtest.Data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtest.R;

public class DataActivity extends AppCompatActivity {
    private Button msharedpreferences;
    private Button mfiledata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        msharedpreferences = findViewById(R.id.bt_sharedpreferences);
        mfiledata = findViewById(R.id.bt_filedata);
        msharedpreferences.setOnClickListener(new MyOnclick());
        mfiledata.setOnClickListener(new MyOnclick());

    }
    class MyOnclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.bt_sharedpreferences:
                     intent = new Intent(DataActivity.this,SharepreferencesActivity.class);
                     break;
                case R.id.bt_filedata:
                     intent = new Intent(DataActivity.this,FileActivity.class);
                     break;
            }
            startActivity(intent);
        }

    }
}
