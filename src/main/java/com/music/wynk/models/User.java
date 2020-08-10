package com.music.wynk.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Users")
public class User {

    @Id
    private String userId;
    private String userName;
    private String userDesc;
    private List<Song> songs;

    public User(String userId, String userName, String userDesc, List<Song> songs) {
        this.userId = userId;
        this.userName = userName;
        this.userDesc = userDesc;
        this.songs = songs;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}
