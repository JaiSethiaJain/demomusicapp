package com.music.wynk.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String userName;
    private String userDesc;
//    private List<Song> songs;

    public User() {}

    public User(String userId, String userName, String userDesc) {
        this.userId = userId;
        this.userName = userName;
        this.userDesc = userDesc;
//        this.songs = songs;
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

//    public List<Song> getSongs() {
//        return songs;
//    }
//
//    public void setSongs(List<Song> songs) {
//        this.songs = songs;
//    }
//
//    public void addSong(Song song) {
//        this.songs.add(song);
//    }
}
