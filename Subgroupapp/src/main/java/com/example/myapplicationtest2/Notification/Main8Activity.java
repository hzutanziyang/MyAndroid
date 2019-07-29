package com.example.myapplicationtest2.Notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplicationtest2.R;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener{

    private Button send_notil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        send_notil = findViewById(R.id.send_notification);
        send_notil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notification:
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Intent intent = new Intent(this,Main9Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("default",getString(R.string.app_name),NotificationManager.IMPORTANCE_LOW);
                    channel.setDescription("this is notification");
                    channel.setShowBadge(false);
                    manager.createNotificationChannel(channel);
                }
                Notification notification = new NotificationCompat.Builder(this,"default")
                        .setContentTitle("This is Content title")
                        .setContentText("This is Content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1,notification);

                break;
            default:
                break;
        }
    }
}
