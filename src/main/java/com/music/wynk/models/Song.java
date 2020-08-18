package com.music.wynk.models;

import javax.persistence.*;

@Entity(name = "song")
@Table(name = "song_table")
public class Song {

    @Column(name = "song_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String songId;

    @Column(name = "song_name", nullable = false)
    private String songName;

    @Column(name = "song_lyrics")
    private String songLyrics;

    @Column(name = "song_popularity", nullable = false)
    private int songPopularity = 1;

    public Song() {}

    public Song(String songName, String songLyrics) {
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

    public void incrementSongPopularity() {
        this.songPopularity++;
    }
}
