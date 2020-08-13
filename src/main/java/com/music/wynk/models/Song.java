package com.music.wynk.models;

public class Song {

    private String songId;
    private String songName;
    private String songLyrics;

    public Song(String songId, String songName, String songLyrics) {
        this.songId = songId;
        this.songName = songName;
        this.songLyrics = songLyrics;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongLyrics() {
        return songLyrics;
    }

    public void setSongLyrics(String songLyrics) {
        this.songLyrics = songLyrics;
    }

}
