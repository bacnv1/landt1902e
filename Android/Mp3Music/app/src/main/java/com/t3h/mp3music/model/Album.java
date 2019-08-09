package com.t3h.mp3music.model;

import android.provider.MediaStore;

public class Album extends BaseModel{
    @FieldInfo(fieldName = MediaStore.Audio.Albums.ALBUM)
    private String name;
    @FieldInfo(fieldName = MediaStore.Audio.Albums.ARTIST)
    private String artist;
    @FieldInfo(fieldName = MediaStore.Audio.Albums.ALBUM_ART)
    private String image;
    @FieldInfo(fieldName = MediaStore.Audio.Albums.NUMBER_OF_SONGS)
    private String numberOfSong;

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getImage() {
        return image;
    }

    public String getNumberOfSong() {
        return numberOfSong;
    }
}
