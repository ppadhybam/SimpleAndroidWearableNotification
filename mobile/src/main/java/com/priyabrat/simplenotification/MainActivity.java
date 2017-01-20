package com.priyabrat.simplenotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int TAKE_PICTURE = 2121;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickCreateNotification(View view)
    {
        Intent intent = new Intent(getApplicationContext(),ViewNotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Hey folks I'm Title");
        builder.setContentText("This is a the details text");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.addAction(R.mipmap.ic_launcher,"Open option",pendingIntent);

        Notification notification = builder.build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
        notificationManagerCompat.notify(1,notification);
    }
}
