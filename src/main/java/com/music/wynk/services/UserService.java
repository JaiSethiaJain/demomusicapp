package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import com.music.wynk.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return this.userRepository.findByUserId(id);
    }

    public User getUserByName(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    public User addUser(User user) {
        this.userRepository.insert(user);
        return user;
    }

    public User updateUser(String id, User user) {
        this.userRepository.save(user);
        return user;
    }

    public User addSongToUser(String id, Song song) {
        User user = this.userRepository.findByUserId(id);
        user.addSong(song);
        this.userRepository.save(user);
        return user;
    }

    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

}
