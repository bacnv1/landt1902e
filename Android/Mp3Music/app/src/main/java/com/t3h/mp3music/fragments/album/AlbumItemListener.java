package com.t3h.mp3music.fragments.album;

import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.model.Album;

public interface AlbumItemListener extends BaseAdapter.BaseItemListener {
    void albumItemClick(Album album);
}
