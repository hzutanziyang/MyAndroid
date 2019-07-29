package com.example.myapplicationtest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplicationtest2.Broadcast.Main4Activity;
import com.example.myapplicationtest2.Broadcast.Offline.LoginActivity;
import com.example.myapplicationtest2.Broadcast.Offline.Main5Activity;
import com.example.myapplicationtest2.Contentprovider.Main6Activity;
import com.example.myapplicationtest2.Contentprovider.ReadContacts.Main7Activity;
import com.example.myapplicationtest2.Fruit.Main2Activity;
import com.example.myapplicationtest2.News.Main3Activity;
import com.example.myapplicationtest2.Notification.Main10Activity;
import com.example.myapplicationtest2.Notification.Main8Activity;

public class MainActivity extends AppCompatActivity {
private Topbar topbar;
private Button bt_fruit,bt_news,bt_broadcast,bt_offline,bt_contentprovider,
        bt_readcontact,bt_noitification,bt_camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topbar = findViewById(R.id.topbar);
        bt_fruit = findViewById(R.id.bt_fruit);
        bt_news = findViewById(R.id.bt_news);
        bt_broadcast = findViewById(R.id.bt_Broadcast);
        bt_offline = findViewById(R.id.bt_offline);
        bt_contentprovider = findViewById(R.id.bt_contentprovider);
        bt_readcontact = findViewById(R.id.bt_readcontact);
        bt_noitification = findViewById(R.id.bt_notification);
        bt_camera = findViewById(R.id.bt_camera);

        setOnclickListener();

        topbar.setOnTopbaronClickListener(new Topbar.onTopbaronClickListener() {
            @Override
            public void leftonClick() {
                Toast.makeText(MainActivity.this,"左按钮",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightonClick() {
                Toast.makeText(MainActivity.this,"右按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setOnclickListener(){
        bt_fruit.setOnClickListener(new myOnclickListener());
        bt_news.setOnClickListener(new myOnclickListener());
        bt_broadcast.setOnClickListener(new myOnclickListener());
        bt_offline.setOnClickListener(new myOnclickListener());
        bt_contentprovider.setOnClickListener(new myOnclickListener());
        bt_readcontact.setOnClickListener(new myOnclickListener());
        bt_noitification.setOnClickListener(new myOnclickListener());
        bt_camera.setOnClickListener(new myOnclickListener());

    }

    class myOnclickListener implements View.OnClickListener{
        Intent intent;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.bt_fruit:
                    intent = new Intent(MainActivity.this, Main2Activity.class);
                    break;
                case R.id.bt_news:
                    intent = new Intent(MainActivity.this, Main3Activity.class);
                    break;
                case R.id.bt_Broadcast:
                    intent = new Intent(MainActivity.this, Main4Activity.class);
                    break;
                case R.id.bt_offline:
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    break;
                case R.id.bt_contentprovider:
                    intent = new Intent(MainActivity.this,Main6Activity.class);
                    break;
                case R.id.bt_readcontact:
                    intent = new Intent(MainActivity.this,Main7Activity.class);
                    break;
                case R.id.bt_notification:
                    intent = new Intent(MainActivity.this, Main8Activity.class);
                    break;
                case R.id.bt_camera:
                    intent = new Intent(MainActivity.this, Main10Activity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
