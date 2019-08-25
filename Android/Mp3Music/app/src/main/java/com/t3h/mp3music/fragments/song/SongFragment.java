package com.t3h.mp3music.fragments.song;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.t3h.mp3music.R;
import com.t3h.mp3music.activities.MainActivity;
import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.base.BaseFragment;
import com.t3h.mp3music.databinding.FragmentSongBinding;
import com.t3h.mp3music.model.Song;
import com.t3h.mp3music.utils.SystemDataUtils;

public class SongFragment extends BaseFragment<FragmentSongBinding> implements SongItemListener {

    private BaseAdapter<Song> adapter;
    private SystemDataUtils dataUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_song;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dataUtils = new SystemDataUtils(getContext());
        adapter = new BaseAdapter<>(getContext(), R.layout.item_song);
        adapter.setData(dataUtils.getSongs());
        adapter.setListener(this);
        binding.lvSong.setAdapter(adapter);
    }

    @Override
    public String getTitle() {
        return "Song";
    }

    @Override
    public void onSongClick(Song song) {
        int index = adapter.getData().indexOf(song);
        MainActivity act = (MainActivity) getActivity();
        act.getService().setData(adapter.getData());
        act.getService().create(index);
    }
}
