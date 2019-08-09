package com.t3h.mp3music.fragments.song;

import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.model.Song;

public interface SongItemListener extends BaseAdapter.BaseItemListener {
    void onSongClick(Song song);
}
