package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import com.music.wynk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SongService songService;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(String id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new Exception("Can not find user with id: "+id));
    }

    @Override
    public User getUserByName(String userName) throws Exception {
        return Optional.ofNullable(userRepository.findByUserName(userName)).orElseThrow(() -> new Exception("Can not find a user with name: "+userName));
    }

    @Override
    public void addUser(User user) throws Exception {
        if (userRepository.existsById(user.getUserId())) {
            throw new Exception("User already in database");
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) throws Exception {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Can not find a user with id: "+id);
        }
    }

    @Override
    public void addSongToUser(String id, Song song) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("Can not find user with id: "+id));
        try {
            songService.addSong(song);
        } catch (Exception e) {}
        finally {
            Song song1 = songService.getSongByName(song.getSongName());
            song1.incrementSongPopularity();
            songService.updateSong(song1);
            user.addUserSong(song1.getSongName());
            userRepository.save(user);
        }
    }

}
