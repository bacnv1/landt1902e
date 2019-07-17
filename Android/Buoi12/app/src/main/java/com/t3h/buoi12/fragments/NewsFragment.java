package com.t3h.buoi12.fragments;

import com.t3h.buoi12.R;

public class NewsFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public String getTitle() {
        return "News";
    }
}
