package com.t3h.buoi12;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.t3h.buoi12.fragments.BaseFragment;

public class PageNewsAdapter extends FragmentPagerAdapter {

    private BaseFragment[] fms;

    public PageNewsAdapter(FragmentManager fm, BaseFragment ... fms) {
        super(fm);
        this.fms = fms;
    }

    @Override
    public Fragment getItem(int position) {
        return fms[position];
    }

    @Override
    public int getCount() {
        return fms.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fms[position].getTitle();
    }
}
