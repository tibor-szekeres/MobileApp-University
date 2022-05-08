package com.example.survey;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHandler {
    private static final String CHANNEL_ID = "shop_notification_channel";
    private final int NOTIFICATION_ID = 0;

    private NotificationManager notificationManager;
    private Context mContext;

    public NotificationHandler(Context context) {
        this.mContext = context;
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        createChannel();
    }

    private void createChannel(){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            return;

        NotificationChannel channel = new NotificationChannel
                (CHANNEL_ID,
                        "Survey notification",
                        NotificationManager.IMPORTANCE_DEFAULT);

        channel.enableLights(true);
        channel.enableVibration(true);
        channel.setLightColor(Color.RED);
        channel.setDescription("Notifications from Survey App");
        this.notificationManager.createNotificationChannel(channel);
    }

    public void send (String message){
        Intent intent = new Intent(mContext, SurveyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setContentTitle("Survey App")
                .setContentText(message)
                .setSmallIcon(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal_background)
                .setContentIntent(pendingIntent);

        this.notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
    public void cancel(){
        this.notificationManager.cancel(NOTIFICATION_ID);
    }
}
