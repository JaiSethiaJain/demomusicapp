package com.music.wynk.controllers;

import com.music.wynk.models.Song;
import com.music.wynk.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<Object> getAllSongs() {
        return new ResponseEntity<>(songService.getSongs(), HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<Object> getSongsPopularityWise() {
        return new ResponseEntity<>(songService.getPopularSongs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSongById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(songService.getSongById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{songName}")
    public ResponseEntity<Object> getSongByName(@PathVariable String songName) throws Exception {
        return new ResponseEntity<>(songService.getSongByName(songName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Song song) throws Exception {
        songService.addSong(song);
        return new ResponseEntity<>("Song Added Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) throws Exception {
        songService.deleteSong(id);
        return new ResponseEntity<>("Song Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody Song song) {
        songService.updateSong(song);
        return new ResponseEntity<>("Song Updated Successfully", HttpStatus.OK);
    }

}
