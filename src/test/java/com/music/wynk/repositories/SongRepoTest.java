package com.music.wynk.repositories;

import com.music.wynk.models.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SongRepoTest {

    @Autowired
    private SongRepository songRepository;

    @Test
    public void findAllSongs() {
        List<Song> songs = (List<Song>) songRepository.findAll();
        assertNotNull(songs);
        assertEquals(3, songs.size());
        songs.forEach((song) -> System.out.println(song.getSongName()));
    }

    @Test
    public void findSongByValidId() {
        String id = "1";
        assertEquals("Roar", songRepository.findById(id).get().getSongName());
    }

    @Test
    public void findSongByInvalidId() {
        String id = "5";
        Exception exception = assertThrows(NoSuchElementException.class, () -> {songRepository.findById(id).get();});
        System.out.println(exception.getMessage());
    }

    @Test
    public void findSongByNullId() {
        String id = null;
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {songRepository.findById(id);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void findSongByValidName() {
        String name = "Roar";
        assertEquals("Roar", songRepository.findBySongName(name).getSongName());
    }

    @Test
    public void findSongByInvalidName() {
        String name = "R";
        assertNull(songRepository.findBySongName(name));
    }

    @Test
    public void findSongByNullName() {
        String name = null;
        assertNull(songRepository.findBySongName(name));
    }

    @Test
    public void testForSaveDeleteValidSong() {
        Song song = new Song("River", "fun");
        String id = "4";
        assertFalse(songRepository.existsById(id));
        songRepository.save(song);
        assertTrue(songRepository.existsById(id));
        songRepository.deleteById(id);
        assertFalse(songRepository.existsById(id));
    }

    @Test
    public void testForSaveInvalidSong() {
        Song song = new Song();
        Exception exception = assertThrows(DataIntegrityViolationException.class, () -> {songRepository.save(song);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void testForSaveNullSong() {
        Song song = null;
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {songRepository.save(song);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void testForDeleteByInvalidId() {
        String id = "4";
        Exception exception = assertThrows(EmptyResultDataAccessException.class, () -> {songRepository.deleteById(id);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void testForDeleteByNullId() {
        String id = null;
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {songRepository.deleteById(id);});
        System.out.println(exception.getMessage());
    }

}
