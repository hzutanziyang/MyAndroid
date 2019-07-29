package com.example.myapplicationtest.Data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationtest.R;

public class SharepreferencesActivity extends AppCompatActivity {
    private EditText editText;
    private Button mbtsave,mbtshow;
    private TextView mtv;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreferences);
        editText = findViewById(R.id.m_et);
        mbtsave = findViewById(R.id.bt_save);
        mbtshow = findViewById(R.id.bt_show);
        mtv = findViewById(R.id.m_tv2);
        mbtsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("name",editText.getText().toString());
                editor.apply();
            }
        });
        mbtshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=null;
                string = sharedPreferences.getString("name","");
                mtv.setText(string);
            }
        });
    }
}
