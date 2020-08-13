package com.music.wynk.controllers;

import com.music.wynk.models.Song;
import com.music.wynk.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getSongs(false);
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable String id){
        return songService.getSongById(id);
    }

    @GetMapping("/name/{songName}")
    public Song getSongByName(@PathVariable String songName) {
        return songService.getSongByName(songName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song create(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        songService.deleteSong(id);
    }

    @PutMapping("/{id}")
    public Song update(@PathVariable String id, @RequestBody Song song) {
        return songService.updateSong(id, song);
    }

    @GetMapping("/popular")
    public List<Song> getSongsPopularityWise() {
        return songService.getSongs(true);
    }

}
