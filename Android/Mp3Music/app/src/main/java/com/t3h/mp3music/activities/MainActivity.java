package com.t3h.mp3music.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;

import com.t3h.mp3music.R;
import com.t3h.mp3music.adapter.MP3PagerAdapter;
import com.t3h.mp3music.base.BaseActivity;
import com.t3h.mp3music.databinding.ActivityMainBinding;
import com.t3h.mp3music.fragments.AlbumFragment;
import com.t3h.mp3music.fragments.ArtistFragment;
import com.t3h.mp3music.fragments.SongFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements SearchView.OnQueryTextListener {

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
        getSupportActionBar().setElevation(0);

        pagerAdapter = new MP3PagerAdapter(getSupportFragmentManager(),
                fmSong, fmArtist, fmAlbum);
        binding.pager.setAdapter(pagerAdapter);
        binding.tab.setupWithViewPager(binding.pager);
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
