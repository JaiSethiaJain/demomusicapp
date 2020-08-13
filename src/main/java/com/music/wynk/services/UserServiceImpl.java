package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import com.music.wynk.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return this.userRepository.findByUserId(id);
    }

    @Override
    public User getUserByName(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    @Override
    public User addUser(User user) {
        this.userRepository.insert(user);
        return user;
    }

    @Override
    public User updateUser(String id, User user) {
        this.userRepository.save(user);
        return user;
    }

    @Override
    public User addSongToUser(String id, Song song) {
        User user = this.userRepository.findByUserId(id);
        user.addSong(song);
        this.userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }

}
