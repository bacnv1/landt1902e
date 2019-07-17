package com.t3h.buoi12;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;

import com.t3h.buoi12.databinding.ActivityMainBinding;
import com.t3h.buoi12.fragments.FavoriteFragment;
import com.t3h.buoi12.fragments.NewsFragment;
import com.t3h.buoi12.fragments.SavedFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;

    private NewsFragment fmNews = new NewsFragment();
    private SavedFragment fmSaved = new SavedFragment();
    private FavoriteFragment fmFavorite = new FavoriteFragment();
    private PageNewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(
                this,
                binding.drawer,
                R.string.app_name,
                R.string.app_name
        );
        binding.drawer.addDrawerListener(toggle);
        toggle.syncState();

        initViews();
    }

    private void initViews() {
        adapter = new PageNewsAdapter(getSupportFragmentManager(),
                fmNews, fmSaved, fmFavorite);
        binding.pager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.pager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home){
//            finish();
//        }
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
