package com.music.wynk.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
@Table(name = "user_table")
public class User {

    @Column(name = "user_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_desc")
    private String userDesc;

    @Column(name = "user_songs")
    @ElementCollection
    private Set<String> userSongs;

    public User() {}

    public User(String userName, String userDesc) {
        this.userName = userName;
        this.userDesc = userDesc;
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

    public Set<String> getUserSongs() {
        return userSongs;
    }

    public void addUserSong(String userSong) {
        this.userSongs.add(userSong);
    }

}
