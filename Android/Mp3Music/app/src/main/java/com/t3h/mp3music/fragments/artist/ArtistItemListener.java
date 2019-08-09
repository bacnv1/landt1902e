package com.t3h.mp3music.fragments.artist;

import com.t3h.mp3music.base.BaseAdapter;
import com.t3h.mp3music.model.Artist;

public interface ArtistItemListener extends BaseAdapter.BaseItemListener {
    void onArtistClick(Artist artist);
}
