package com.music.wynk.models;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    private String userId;
    private String userName;
    private String userDesc;
    @ElementCollection
    private List<String> userSongs = new ArrayList<>();

    public User() {}

    public User(String userId, String userName, String userDesc/*, List<String> userSongs*/) {
        this.userId = userId;
        this.userName = userName;
        this.userDesc = userDesc;
//        this.userSongs = userSongs;
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

    public List<String> getUserSongs() {
        return userSongs;
    }

    public void setUserSongs(String userSong) {
        this.userSongs.add(userSong);
    }

    //    public List<String> getUserSongs() {
//        return userSongs;
//    }

//    public void setUserSongs(List<String> userSongs) {
//        this.userSongs = userSongs;
//    }

//    public void setUserSongs(String songId) {
//        if (userSongs.contains(songId) == false) {
//            userSongs.add(songId);
//        }
//    }
}
