package me.lucasxaviervieira.notemanager.note_manager_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.lucasxaviervieira.notemanager.note_manager_api.model.User;
import me.lucasxaviervieira.notemanager.note_manager_api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String rawPassword) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        return userRepository.save(user);
    }

}
