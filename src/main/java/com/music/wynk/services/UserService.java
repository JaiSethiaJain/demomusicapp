package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(String id) throws Exception;

    User getUserByName(String userName) throws Exception;

    void addUser(User user) throws Exception;

    void updateUser(User user);

    void deleteUser(String id) throws Exception;

    void addSongToUser(String id, Song song) throws Exception;
}
