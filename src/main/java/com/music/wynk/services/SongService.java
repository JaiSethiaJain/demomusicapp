package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(String  id) {
        return this.songRepository.findBySongId(id);
    }

    public Song getSongByName(String songName) {
        return this.songRepository.findBySongName(songName);
    }

    public Song addSong(Song song) {
        this.songRepository.insert(song);
        return song;
    }

    public Song updateSong(String id, Song song) {
        this.songRepository.save(song);
        return song;
    }

    public void deleteSong(String id) {
        this.songRepository.deleteById(id);
    }
}
