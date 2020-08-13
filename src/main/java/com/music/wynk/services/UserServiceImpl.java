package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import com.music.wynk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(new User("0", "", ""));
    }

    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(String id, User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public User addSongToUser(String id, Song song) {
//        User user = userRepository.findById(id).orElse(new User("", "", "", new ArrayList<Song>()));
//        user.addSong(song);
//        userRepository.save(user);
//        return user;
//    }

}
