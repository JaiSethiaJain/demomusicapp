package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getSongs() {
        return (List<Song>) songRepository.findAll();
    }

    @Override
    public List<Song> getPopularSongs() {
        List<Song> songs = getSongs();
        if (songs.size()>1) {
            songs.sort((Song s1, Song s2) -> s2.getSongPopularity()-s1.getSongPopularity());
        }
        return songs;
    }

    @Override
    public Song getSongById(String  id) throws Exception {
        return songRepository.findById(id).orElseThrow(() -> new Exception("Can not find a song with id: "+id));
    }

    @Override
    public Song getSongByName(String songName) throws Exception {
        return Optional.ofNullable(songRepository.findBySongName(songName)).orElseThrow(() -> new Exception("Can not find a song with name: "+songName));
    }

    @Override
    public void addSong(Song song) throws Exception {
        if (songRepository.existsById(song.getSongId())) {
            throw new Exception("Song already in catalog");
        } else {
            songRepository.save(song);
        }
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteSong(String id) throws Exception {
        try {
            songRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Can not find a song with id: "+id);
        }
    }

}
