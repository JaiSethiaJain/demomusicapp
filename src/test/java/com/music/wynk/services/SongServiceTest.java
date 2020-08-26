package com.music.wynk.services;

import com.music.wynk.models.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongServiceTest {

    @Autowired
    private SongService songService;

    @Test
    public void testForGetAllSongs() {
        List<Song> songs = songService.getSongs();
        assertNotNull(songs);
        assertEquals(3, songs.size());
        songs.forEach((song) -> System.out.println(song.getSongName()));
    }

    @Test
    public void testForAddDeleteValidSong() throws Exception {
        Song song = new Song("River", "fun");
        song.setSongId("7");
        String id = "4";
        System.out.println(assertThrows(Exception.class, () -> {songService.getSongById(id);}).getMessage());
        songService.addSong(song);
        assertEquals("River", songService.getSongById(id).getSongName());
        songService.deleteSong(id);
        System.out.println(assertThrows(Exception.class, () -> {songService.getSongById(id);}).getMessage());
    }

    @Test
    public void testForGetSongsByNullId() {
        System.out.println(assertThrows(InvalidDataAccessApiUsageException.class, () -> {songService.getSongById(null);}).getMessage());
    }

    @Test
    public void testForGetSongByValidName() throws Exception {
        String name = "Roar";
        assertEquals("Roar", songService.getSongByName(name).getSongName());
    }

    @Test
    public void testForGetSongsByInvalidName() {
        System.out.println(assertThrows(Exception.class, () -> {songService.getSongByName("R");}).getMessage());
    }

    @Test
    public void testForGetSongsByNullName() {
        System.out.println(assertThrows(Exception.class, () -> {songService.getSongByName(null);}).getMessage());
    }

    @Test
    public void testForAddInvalidSong() {
        System.out.println(assertThrows(InvalidDataAccessApiUsageException.class, () -> {songService.addSong(new Song());}).getMessage());
    }

    @Test
    public void testForAddNullSong() {
        System.out.println(assertThrows(NullPointerException.class, () -> {songService.addSong(null);}).getMessage());
    }

    @Test
    public void testForDeleteInvalidSong() {
        System.out.println(assertThrows(Exception.class, () -> {songService.deleteSong("5");}).getMessage());
    }

    @Test
    public void testForDeleteNullSong() {
        System.out.println(assertThrows(Exception.class, () -> {songService.deleteSong(null);}).getMessage());
    }

    @Test
    public void testForGetPopularSongs() {
        List<Song> songs = songService.getPopularSongs();
        Song song = songs.get(1);
        song.incrementSongPopularity();
        songService.updateSong(song);
        songs = songService.getPopularSongs();
        assertEquals(song.getSongName(), songs.get(0).getSongName());
    }

    @Test
    public void testForUpdateInvalidSong() {
        System.out.println(assertThrows(DataIntegrityViolationException.class, () -> {songService.updateSong(new Song());}).getMessage());
    }

    @Test
    public void testForUpdateNullSong() {
        System.out.println(assertThrows(InvalidDataAccessApiUsageException.class, () -> {songService.updateSong(null);}).getMessage());
    }

}
