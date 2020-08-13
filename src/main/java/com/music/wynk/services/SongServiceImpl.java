package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

//    public SongServiceImpl(SongRepository songRepository) {
//        this.songRepository = songRepository;
//    }

    @Override
    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        return songs;
    }

    @Override
    public Song getSongById(String  id) {
        return songRepository.findById(id).orElse(new Song("", "", "")) ;
    }

    @Override
    public Song getSongByName(String songName) {
        return songRepository.findBySongName(songName);
    }

    @Override
    public Song addSong(Song song) {
        songRepository.save(song);
        return song;
    }

    @Override
    public Song updateSong(String id, Song song) {
        songRepository.save(song);
        return song;
    }

    @Override
    public void deleteSong(String id) {
        songRepository.deleteById(id);
    }
}
