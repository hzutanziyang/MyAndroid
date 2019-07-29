package com.example.myapplicationtest.Jump;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplicationtest.R;

public class BActivity extends AppCompatActivity {
    private TextView mtv1;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mtv1 = findViewById(R.id.tv_intent1);
        button = findViewById(R.id.bt_intent1);
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("name");
        int age = bundle.getInt("age");
        mtv1.setText(text+age+"岁");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title","我回来了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
