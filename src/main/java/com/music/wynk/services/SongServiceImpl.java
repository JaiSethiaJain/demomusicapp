package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.repositories.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(String id) {
        return this.songRepository.findBySongId(id);
    }

    @Override
    public Song getSongByName(String songName) {
        return this.songRepository.findBySongName(songName);
    }

    @Override
    public Song addSong(Song song) {
        this.songRepository.insert(song);
        return song;
    }

    @Override
    public Song updateSong(String id, Song song) {
        this.songRepository.save(song);
        return song;
    }

    @Override
    public void deleteSong(String id) {
        this.songRepository.deleteById(id);
    }
}
