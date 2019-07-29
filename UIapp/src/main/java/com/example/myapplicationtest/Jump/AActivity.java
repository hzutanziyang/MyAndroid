package com.example.myapplicationtest.Jump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationtest.R;
import com.example.myapplicationtest.UIActivity;

public class AActivity extends AppCompatActivity {
    private Button mbt1;
    private TextView mtv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mbt1 = findViewById(R.id.bt_intent);
        mtv1 = findViewById(R.id.tv_intent);
        mbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this,BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","JoJo");
                bundle.putInt("age",18);
                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }
}
