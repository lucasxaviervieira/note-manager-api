package me.lucasxaviervieira.notemanager.note_manager_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.lucasxaviervieira.notemanager.note_manager_api.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username, @RequestParam String password) {

        String result = userService.registerUser(username, password);

        if (result.equals("success")) {
            return ResponseEntity.ok("User registered successfully");
        }
        return ResponseEntity.badRequest().body("Username already taken");

    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {

        String result = userService.loginUser(username, password);

        if (!result.equals("invalid_credentials")) {
            return ResponseEntity.ok("Bearer " + result);
        }

        return ResponseEntity.status(401).body("Invalid Credentials");
    }

}
