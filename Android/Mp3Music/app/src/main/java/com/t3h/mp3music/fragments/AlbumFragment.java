package com.t3h.mp3music.fragments;

import com.t3h.mp3music.R;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentAlbumBinding;

public class AlbumFragment extends BaseFragment<FragmentAlbumBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_album;
    }

    @Override
    public String getTitle() {
        return "Album";
    }
}