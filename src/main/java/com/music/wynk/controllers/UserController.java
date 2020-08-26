package com.music.wynk.controllers;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import com.music.wynk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName) throws Exception {
        return new ResponseEntity<>(userService.getUserByName(userName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) throws Exception {
        userService.addUser(user);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}/addSong")
    public ResponseEntity<String> addSongToUser(@PathVariable String id, @RequestBody Song song) throws Exception {
        userService.addSongToUser(id, song);
        return new ResponseEntity<>("Song Added To User Successfully", HttpStatus.OK);
    }
}
