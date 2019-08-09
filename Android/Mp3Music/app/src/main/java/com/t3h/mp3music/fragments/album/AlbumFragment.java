package com.t3h.mp3music.fragments.album;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentAlbumBinding;
import com.t3h.mp3music.model.Album;
import com.t3h.mp3music.utils.SystemDataUtils;

public class AlbumFragment extends BaseFragment<FragmentAlbumBinding> implements AlbumItemListener{

    private BaseAdapter<Album> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_album;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataUtils = new SystemDataUtils(getContext());
        adapter = new BaseAdapter<>(getContext(), R.layout.item_album);
        adapter.setData(dataUtils.getAlbums());
        adapter.setListener(this);
        binding.lvAlbum.setAdapter(adapter);
    }

    @Override
    public String getTitle() {
        return "Album";
    }

    @Override
    public void albumItemClick(Album album) {

    }
}