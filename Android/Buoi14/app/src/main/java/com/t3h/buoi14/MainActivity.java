package com.t3h.buoi14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.t3h.buoi14.adapter.SongAdapter;
import com.t3h.buoi14.data.MediaManager;
import com.t3h.buoi14.data.SystemData;
import com.t3h.buoi14.databinding.ActivityMainBinding;
import com.t3h.buoi14.model.Song;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.SongItemClickListener {

    private SystemData data;
    private SongAdapter adapter;

    private ActivityMainBinding binding;
    private MediaManager manager;

    private final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        if (checkPermission()) {
            init();
        }
    }

    private void init() {
        data = new SystemData(this);
        adapter = new SongAdapter(this);
        adapter.setListener(this);
        binding.lvSong.setAdapter(adapter);
        ArrayList<Song> arr = data.getData();
        adapter.setData(arr);
        manager = new MediaManager(this, arr);
    }

    @Override
    public void onItemSongClicked(int position) {
        manager.create(position);
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p: PERMISSIONS) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(PERMISSIONS, 0);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (checkPermission()) {
            init();
        }else{
            finish();
        }
    }
}
