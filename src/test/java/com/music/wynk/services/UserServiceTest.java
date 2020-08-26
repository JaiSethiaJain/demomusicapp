package com.music.wynk.services;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testForGetAllUsers() {
        List<User> Users = userService.getUsers();
        assertNotNull(Users);
        assertEquals(3, Users.size());
        Users.forEach((User) -> System.out.println(User.getUserName()));
    }

    @Test
    public void testForAddDeleteValidUser() throws Exception {
        User User = new User("akshatt", "hat");
        User.setUserId("7");
        String id = "4";
        System.out.println(assertThrows(Exception.class, () -> {
            userService.getUserById(id);}).getMessage());
        userService.addUser(User);
        assertEquals("akshatt", userService.getUserById(id).getUserName());
        userService.deleteUser(id);
        System.out.println(assertThrows(Exception.class, () -> {
            userService.getUserById(id);}).getMessage());
    }

    @Test
    public void testForGetUsersByNullId() {
        System.out.println(assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            userService.getUserById(null);}).getMessage());
    }

    @Test
    public void testForGetUserByValidName() throws Exception {
        String name = "jai";
        assertEquals("jai", userService.getUserByName(name).getUserName());
    }

    @Test
    public void testForGetUsersByInvalidName() {
        System.out.println(assertThrows(Exception.class, () -> {
            userService.getUserByName("R");}).getMessage());
    }

    @Test
    public void testForGetUsersByNullName() {
        System.out.println(assertThrows(Exception.class, () -> {
            userService.getUserByName(null);}).getMessage());
    }

    @Test
    public void testForAddInvalidUser() {
        System.out.println(assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            userService.addUser(new User());}).getMessage());
    }

    @Test
    public void testForAddNullUser() {
        System.out.println(assertThrows(NullPointerException.class, () -> {
            userService.addUser(null);}).getMessage());
    }

    @Test
    public void testForDeleteInvalidUser() {
        System.out.println(assertThrows(Exception.class, () -> {
            userService.deleteUser("5");}).getMessage());
    }

    @Test
    public void testForDeleteNullUser() {
        System.out.println(assertThrows(Exception.class, () -> {
            userService.deleteUser(null);}).getMessage());
    }

    @Test
    public void testForAddValidSongToValidUser() throws Exception {
        User user = userService.getUserById("2");
        assertEquals(0, user.getUserSongs().size());
        Song song = new Song("Rockstar", "pqr");
        song.setSongId("2");
        userService.addSongToUser(user.getUserId(), song);
        assertEquals(1, userService.getUserById(user.getUserId()).getUserSongs().size());
    }

    @Test
    public void testForUpdateInvalidUser() {
        System.out.println(assertThrows(DataIntegrityViolationException.class, () -> {
            userService.updateUser(new User());}).getMessage());
    }

    @Test
    public void testForUpdateNullUser() {
        System.out.println(assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            userService.updateUser(null);}).getMessage());
    }

}
