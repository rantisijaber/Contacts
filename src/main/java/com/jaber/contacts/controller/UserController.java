package com.jaber.contacts.controller;


import com.jaber.contacts.model.User;
import com.jaber.contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.verify(user));
    }

   @GetMapping("/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("user-list")
    public ResponseEntity<List<User>> getUserList() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @DeleteMapping("delete-user")
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
        return ResponseEntity.ok("User deleted successfully");
    }

}
