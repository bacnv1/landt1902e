package com.t3h.mp3music.activities;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.view.Menu;

import com.t3h.mp3music.R;
import com.t3h.mp3music.adapter.MP3PagerAdapter;
import com.t3h.mp3music.base.BaseActivity;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.ActivityMainBinding;
import com.t3h.mp3music.fragments.album.AlbumFragment;
import com.t3h.mp3music.fragments.artist.ArtistFragment;
import com.t3h.mp3music.fragments.song.SongFragment;
import com.t3h.mp3music.service.MP3Service;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements SearchView.OnQueryTextListener {

    private MP3Service service;

    private final String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private SongFragment fmSong = new SongFragment();
    private ArtistFragment fmArtist = new ArtistFragment();
    private AlbumFragment fmAlbum = new AlbumFragment();

    private MP3PagerAdapter pagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAct() {
        if (checkPermission() == false){
            return;
        }
        getSupportActionBar().setElevation(0);

        pagerAdapter = new MP3PagerAdapter(getSupportFragmentManager(),
                fmSong, fmArtist, fmAlbum);
        binding.pager.setAdapter(pagerAdapter);
        binding.tab.setupWithViewPager(binding.pager);

        Intent intent = new Intent(this, MP3Service.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MP3Service.MP3Binder binder = (MP3Service.MP3Binder) service;
            MainActivity.this.service = binder.getService();
            binding.playView.setService(MainActivity.this.service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p: PERMISSIONS) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
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
        if (checkPermission()){
            initAct();
        }else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) menu.
                findItem(R.id.search_view).getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        BaseFragment fm = (BaseFragment)
                pagerAdapter.getItem(binding.pager.getCurrentItem());
        fm.executeSearch(s);
        return false;
    }

    public MP3Service getService() {
        return service;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
