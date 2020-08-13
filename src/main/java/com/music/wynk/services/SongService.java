package com.music.wynk.services;

import com.music.wynk.models.Song;

import java.util.List;

public interface SongService {
    List<Song> getSongs();

    Song getSongById(String id);

    Song getSongByName(String songName);

    Song addSong(Song song);

    Song updateSong(String id, Song song);

    void deleteSong(String id);
}
