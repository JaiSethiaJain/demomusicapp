package com.music.wynk.services;

import com.music.wynk.models.Song;

import java.util.List;

public interface SongService {

    List<Song> getSongs();

    List<Song> getPopularSongs();

    Song getSongById(String id) throws Exception;

    Song getSongByName(String songName) throws Exception;

    void addSong(Song song) throws Exception;

    void updateSong(Song song);

    void deleteSong(String id) throws Exception;

}
