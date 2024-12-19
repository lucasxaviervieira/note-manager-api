package me.lucasxaviervieira.notemanager.note_manager_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.lucasxaviervieira.notemanager.note_manager_api.model.User;
import me.lucasxaviervieira.notemanager.note_manager_api.repository.UserRepository;
import me.lucasxaviervieira.notemanager.note_manager_api.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String registerUser(String username, String rawPassword) {

        if (userRepository.findByUsername(username).isPresent()) {
            return "username_exists";
        }

        User user = new User();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        userRepository.save(user);

        return "success";
    }

    public String loginUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (passwordEncoder.matches(password, user.getPassword())) {

                return jwtUtil.generateToken(user.getUsername());
            }
        }
        return "invalid_credentials";
    }

}
