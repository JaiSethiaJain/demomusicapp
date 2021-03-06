package com.music.wynk.repositories;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private SongRepository songRepository;
    private UserRepository userRepository;

    public DBSeeder(SongRepository songRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Song song = new Song("1", "Roar", "abc");
        Song song1 = new Song("2", "Rockstar", "pqr");
        Song song2 = new Song("3", "Roses", "xyz");

        User user = new User("1", "jai", "wow", Arrays.asList(song, song1));
        User user1 = new User("2", "ajeet", "hoh", Arrays.asList(song1));
        User user2 = new User("3", "sanju", "sos", Arrays.asList(song1, song2));

        this.songRepository.deleteAll();
        this.userRepository.deleteAll();

        List<Song> songs = Arrays.asList(song, song1, song2);
        this.songRepository.saveAll(songs);

        List<User> users = Arrays.asList(user, user1, user2);
        this.userRepository.saveAll(users);
    }
}
