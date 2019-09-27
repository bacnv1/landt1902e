package com.t3h.chat.fcmservice;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.t3h.chat.R;
import com.t3h.chat.utils.SharedUtils;

public class FCMService extends FirebaseMessagingService {
    public static final String KEY_TOKEN = "KEY_TOKEN";

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        SharedUtils sharedUtils = new SharedUtils(this);
        sharedUtils.put(KEY_TOKEN, s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String CHANEL_ID = "FCMService";
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANEL_ID,
                    CHANEL_ID,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder
                = new NotificationCompat.Builder(this, CHANEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(remoteMessage.getNotification().getTitle());
        builder.setContentText(remoteMessage.getNotification().getBody());
        manager.notify(2134321, builder.build());
    }
}
