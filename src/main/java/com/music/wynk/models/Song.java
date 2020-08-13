package com.music.wynk.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {

    @Id
    private String songId;
    private String songName;
    private String songLyrics;
    private int songPopularity = 1;

    public Song() {}

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

    public int getSongPopularity() {
        return songPopularity;
    }

    public void setSongPopularity() {
        this.songPopularity++;
    }
}
