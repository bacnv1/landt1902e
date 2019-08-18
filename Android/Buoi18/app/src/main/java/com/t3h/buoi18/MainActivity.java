package com.t3h.buoi18;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.databinding.DataBindingUtil;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.t3h.buoi18.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MainActivityListener {
    private ActivityMainBinding binding;
    private MyService service;
    private MyReceiver receiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        binding.setListener(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(receiver, filter);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder) service;
            MainActivity.this.service = binder.getService();
            binding.tvValue.setText("Service connected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onBindClicked() {
        Intent intent = new Intent(this, MyService.class);
//        bindService(intent, connection, BIND_AUTO_CREATE);
        startService(intent);
    }

    @Override
    public void onUnBindClicked() {
//        unbindService(connection);
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unbindService(connection);
        unregisterReceiver(receiver);
    }
}
