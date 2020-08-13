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

    @Override
    public List<Song> getSongs(boolean flag) {
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        if (flag) {
            songs.sort((Song s1, Song s2) -> s2.getSongPopularity()-s1.getSongPopularity());
        }
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
        if (songRepository.existsById(song.getSongId()) == false) {
            songRepository.save(song);
        }
        else {
            Song song1 = getSongById(song.getSongId());
            song1.setSongPopularity();
            songRepository.save(song1);
            song = song1;
        }
        return song;
    }

    @Override
    public Song updateSong(String id, Song song) {
        songRepository.save(song);
        return song;
    }

    @Override
    public void deleteSong(String id) {
        if (songRepository.existsById(id) == true) {
            songRepository.deleteById(id);
        }
    }

}
