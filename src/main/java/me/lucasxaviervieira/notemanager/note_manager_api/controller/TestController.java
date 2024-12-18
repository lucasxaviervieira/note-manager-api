package me.lucasxaviervieira.notemanager.note_manager_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/login")
    public String loginEndpoint() {
        return "No authentication needed!";
    }

    @GetMapping("/register")
    public String registerEndpoint() {
        return "No authentication needed!";
    }

}
