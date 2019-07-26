package com.t3h.buoi14.model;

public class Song {
    private String data;
    private String title;
    private int size;
    private int duration;
    private String artist;
    private String album;

    public Song(String data, String title, int size, int duration, String artist, String album) {
        this.data = data;
        this.title = title;
        this.size = size;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
    }

    public String getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
