package com.music.wynk.controllers;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import com.music.wynk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{userName}")
    public ResponseEntity<Object> getUserByName(@PathVariable String userName) throws Exception {
        return new ResponseEntity<>(userService.getUserByName(userName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody User user) throws Exception {
        userService.addUser(user);
        return new ResponseEntity<>("User Created Successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Object> update(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}/addSong")
    public ResponseEntity<Object> addSongToUser(@PathVariable String id, @RequestBody Song song) throws Exception {
        userService.addSongToUser(id, song);
        return new ResponseEntity<>("Song Added To User Successfully", HttpStatus.OK);
    }
}
