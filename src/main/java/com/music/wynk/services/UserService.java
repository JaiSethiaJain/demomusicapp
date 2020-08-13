package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(String id);

    User getUserByName(String userName);

    User addUser(User user);

    User updateUser(String id, User user);

//    User addSongToUser(String id, Song song);

    void deleteUser(String id);
}
