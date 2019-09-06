package com.t3h.mp3music.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.arch.lifecycle.MutableLiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.t3h.mp3music.R;
import com.t3h.mp3music.model.Song;

import java.util.ArrayList;

public class MP3Service extends Service implements MediaPlayer.OnCompletionListener {

    private final String ACTION_NEXT = "action.NEXT";
    private final String ACTION_PREV = "action.PREV";
    private final String ACTION_PLAY = "action.PLAY";
    private final String ACTION_EXIT = "action.EXIT";

    private MediaPlayer player;
    private ArrayList<Song> data;
    private int currentIndex = -1;

    private MutableLiveData<Integer> time = new MutableLiveData<>();
    private MutableLiveData<String> name = new MutableLiveData<>();
    private MutableLiveData<Boolean> isPlaying = new MutableLiveData<>();
    private MutableLiveData<Boolean> isStarted = new MutableLiveData<>();

    private boolean isRunning = false;

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_PLAY);
        filter.addAction(ACTION_PREV);
        filter.addAction(ACTION_NEXT);
        filter.addAction(ACTION_EXIT);
        registerReceiver(receiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (isRunning == false) {
            isRunning = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isRunning){
                        time.postValue(currentPosition());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MP3Binder(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        player.release();
    }

    public void setData(ArrayList<Song> data) {
        this.data = data;
    }

    public void create(int index) {
        name.postValue(data.get(index).getTitle());
        isStarted.postValue(true);

        currentIndex = index;
        release();
        Uri uri = Uri.parse(data.get(index).getData());
        player = MediaPlayer.create(this, uri);
        start();
        player.setOnCompletionListener(this);
    }

    public void pushNotification(String name) {
        Intent intent = new Intent(this, getClass());
        startService(intent);

        String channelId = "MP3Service";

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    channelId,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            manager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        builder.setSmallIcon(R.mipmap.ic_launcher);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.mp3_notification);
        remoteViews.setTextViewText(R.id.tv_title, name);
        setAction(remoteViews, R.id.im_next, ACTION_NEXT);
        setAction(remoteViews, R.id.im_prev, ACTION_PREV);
        setAction(remoteViews, R.id.im_play, ACTION_PLAY);
            setAction(remoteViews, R.id.im_close, ACTION_EXIT);

        if (player.isPlaying()) {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.ic_pause);
        }else {
            remoteViews.setImageViewResource(R.id.im_play, R.drawable.ic_play);
        }

        builder.setCustomBigContentView(remoteViews);
        startForeground(1221233, builder.build());
    }

    public void setAction(RemoteViews remoteViews, int id, String action) {
        Intent intent = new Intent(action);
        PendingIntent pending = PendingIntent.getBroadcast(this, 0,
                intent, 0);
        remoteViews.setOnClickPendingIntent(id, pending);
    }

    public void release() {
        if (player != null) {
            player.release();
        }
    }

    public void start() {
        if (player != null) {
            isPlaying.postValue(true);
            player.start();
            pushNotification(data.get(currentIndex).getTitle());
        }
    }

    public void pause() {
        if (player != null) {
            isPlaying.postValue(false);
            player.pause();
            pushNotification(data.get(currentIndex).getTitle());
        }
    }

    public int getDuration() {
        if (player != null) {
            return player.getDuration();
        }
        return 0;
    }

    public int currentPosition() {
        if (player != null) {
            return player.getCurrentPosition();
        }
        return 0;
    }

    public void seek(int position) {
        if (player != null) {
            player.seekTo(position);
        }
    }

    public static final int NEXT = 1;
    public static final int PREV = -1;

    @Override
    public void onCompletion(MediaPlayer mp) {
        change(NEXT);
    }

    @IntDef({NEXT, PREV})
    public @interface Change{}

    public void change(@Change int value) {
        currentIndex += value;
        if (currentIndex >= data.size()) {
            currentIndex = 0;
        }else if (currentIndex < 0) {
            currentIndex = data.size() - 1;
        }
        create(currentIndex);
    }

    public class MP3Binder extends Binder {
        private MP3Service service;

        public MP3Binder(MP3Service service) {
            this.service = service;
        }

        public MP3Service getService() {
            return service;
        }
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case ACTION_NEXT:
                    change(NEXT);
                    break;
                case ACTION_PLAY:
                    if (player.isPlaying()) {
                        pause();
                    }else {
                        start();
                    }
                    break;
                case ACTION_PREV:
                    change(PREV);
                    break;
                case ACTION_EXIT:
                    isStarted.postValue(false);
                    isRunning = false;
                    stopForeground(true);
                    stopSelf();
                    release();
                    break;
            }
        }
    };

    public MutableLiveData<Integer> getTime() {
        return time;
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<Boolean> getIsPlaying() {
        return isPlaying;
    }

    public MutableLiveData<Boolean> getIsStarted() {
        return isStarted;
    }
}
