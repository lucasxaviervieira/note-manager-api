package me.lucasxaviervieira.notemanager.note_manager_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/protected")
    public String protectedRoute() {
        return "This route is protected!";
    }
}
