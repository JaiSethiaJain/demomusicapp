package com.music.wynk.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public ResponseEntity<Object> homePage() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

}
