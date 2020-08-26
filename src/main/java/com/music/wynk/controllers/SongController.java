package com.music.wynk.controllers;

import com.music.wynk.models.Song;
import com.music.wynk.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        return new ResponseEntity<>(songService.getSongs(), HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Song>> getSongsPopularityWise() {
        return new ResponseEntity<>(songService.getPopularSongs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(songService.getSongById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{songName}")
    public ResponseEntity<Song> getSongByName(@PathVariable String songName) throws Exception {
        return new ResponseEntity<>(songService.getSongByName(songName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String > create(@RequestBody Song song) throws Exception {
        songService.addSong(song);
        return new ResponseEntity<>("Song Added Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > delete(@PathVariable String id) throws Exception {
        songService.deleteSong(id);
        return new ResponseEntity<>("Song Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<String> update(@RequestBody Song song) {
        songService.updateSong(song);
        return new ResponseEntity<>("Song Updated Successfully", HttpStatus.OK);
    }

}
