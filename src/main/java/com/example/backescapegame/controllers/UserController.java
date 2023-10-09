package com.example.backescapegame.controllers;


import com.example.backescapegame.entities.User;
import com.example.backescapegame.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(value="/users")
    ResponseEntity<Iterable<User>> allUsers(){

        return ResponseEntity.ok(userRepository.findAll());
    }
    @PostMapping(value="/createUser")
    void insertUser(@RequestBody User body){
       userRepository.save(body);
    }

}
