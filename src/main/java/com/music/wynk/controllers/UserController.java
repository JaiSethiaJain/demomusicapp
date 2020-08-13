package com.music.wynk.controllers;

import com.music.wynk.models.Song;
import com.music.wynk.models.User;
import com.music.wynk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("/name/{userName}")
    public User getUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

//    @PutMapping("/{id}/addSong")
//    public User addSongToUser(@PathVariable String id, @RequestBody Song song) {
//        return userService.addSongToUser(id, song);
//    }
}
