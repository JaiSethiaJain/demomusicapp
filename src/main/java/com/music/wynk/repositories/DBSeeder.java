package com.music.wynk.repositories;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Song song = new Song("Roar", "abc");
        Song song1 = new Song("Rockstar", "pqr");
        Song song2 = new Song("Roses", "xyz");

        User user = new User("jai", "wow");
        User user1 = new User("ajeet", "hoh");
        User user2 = new User("sanju", "sos");

        songRepository.deleteAll();
        userRepository.deleteAll();

        List<Song> songs = Arrays.asList(song, song1, song2);
        songRepository.saveAll(songs);

        List<User> users = Arrays.asList(user, user1, user2);
        userRepository.saveAll(users);
    }
}
