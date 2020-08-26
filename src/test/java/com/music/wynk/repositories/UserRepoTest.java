package com.music.wynk.repositories;

import com.music.wynk.models.User;
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
public class UserRepoTest {

    @Autowired
    private UserRepository UserRepository;

    @Test
    public void findAllUsers() {
        List<User> Users = (List<User>) UserRepository.findAll();
        assertNotNull(Users);
        assertEquals(3, Users.size());
        Users.forEach((User) -> System.out.println(User.getUserName()));
    }

    @Test
    public void findUserByValidId() {
        String id = "1";
        assertEquals("jai", UserRepository.findById(id).get().getUserName());
    }

    @Test
    public void findUserByInvalidId() {
        String id = "5";
        Exception exception = assertThrows(NoSuchElementException.class, () -> {UserRepository.findById(id).get();});
        System.out.println(exception.getMessage());
    }

    @Test
    public void findUserByNullId() {
        String id = null;
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {UserRepository.findById(id);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void findUserByValidName() {
        String name = "jai";
        assertEquals("jai", UserRepository.findByUserName(name).getUserName());
    }

    @Test
    public void findUserByInvalidName() {
        String name = "R";
        assertNull(UserRepository.findByUserName(name));
    }

    @Test
    public void findUserByNullName() {
        String name = null;
        assertNull(UserRepository.findByUserName(name));
    }

    @Test
    public void testForSaveDeleteValidUser() {
        User User = new User("akshatt", "hat");
        String id = "4";
        assertFalse(UserRepository.existsById(id));
        UserRepository.save(User);
        assertTrue(UserRepository.existsById(id));
        UserRepository.deleteById(id);
        assertFalse(UserRepository.existsById(id));
    }

    @Test
    public void testForSaveInvalidUser() {
        User User = new User();
        Exception exception = assertThrows(DataIntegrityViolationException.class, () -> {UserRepository.save(User);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void testForSaveNullUser() {
        User User = null;
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {UserRepository.save(User);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void testForDeleteByInvalidId() {
        String id = "4";
        Exception exception = assertThrows(EmptyResultDataAccessException.class, () -> {UserRepository.deleteById(id);});
        System.out.println(exception.getMessage());
    }

    @Test
    public void testForDeleteByNullId() {
        String id = null;
        Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {UserRepository.deleteById(id);});
        System.out.println(exception.getMessage());
    }

}