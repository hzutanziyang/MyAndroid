package com.youlan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button bt_FruitActivity,bt_FruitToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_FruitActivity = findViewById(R.id.bt_fruit);
        bt_FruitToolbar = findViewById(R.id.bt_toolbar);
        setOnClickLinstener();
    }

    public void setOnClickLinstener(){
        bt_FruitActivity.setOnClickListener(new MyonClickListener());
        bt_FruitToolbar.setOnClickListener(new MyonClickListener());
    }

    private class MyonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view)
        {
            Intent intent = null;
            switch (view.getId()){
                case R.id.bt_fruit:
                     intent = new Intent(MainActivity.this,FruitActivity.class);
                    break;
                case R.id.bt_toolbar:
                     intent = new Intent(MainActivity.this,FruitToolbar.class);
                     break;
            }
            startActivity(intent);
        }
    }
}
