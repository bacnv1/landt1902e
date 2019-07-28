package com.t3h.mp3music.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.t3h.mp3music.base.BaseFragment;

public class MP3PagerAdapter extends FragmentPagerAdapter {
    private BaseFragment[] fms;
    public MP3PagerAdapter(FragmentManager fm, BaseFragment ... fms) {
        super(fm);
        this.fms = fms;
    }

    @Override
    public Fragment getItem(int i) {
        return fms[i];
    }

    @Override
    public int getCount() {
        return fms == null ? 0 : fms.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fms[position].getTitle();
    }
}
