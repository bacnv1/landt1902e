package com.t3h.mp3music.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.view.Menu;

import com.t3h.mp3music.R;
import com.t3h.mp3music.adapter.MP3PagerAdapter;
import com.t3h.mp3music.base.BaseActivity;
import com.t3h.mp3music.databinding.ActivityMainBinding;
import com.t3h.mp3music.fragments.album.AlbumFragment;
import com.t3h.mp3music.fragments.artist.ArtistFragment;
import com.t3h.mp3music.fragments.song.SongFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements SearchView.OnQueryTextListener {

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
    }

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
        return false;
    }
}
