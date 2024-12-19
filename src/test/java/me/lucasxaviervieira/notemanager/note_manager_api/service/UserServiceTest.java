package me.lucasxaviervieira.notemanager.note_manager_api.service;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import me.lucasxaviervieira.notemanager.note_manager_api.model.User;
import me.lucasxaviervieira.notemanager.note_manager_api.repository.UserRepository;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        String username = "testuser";
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";

        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);

        userService.registerUser(username, rawPassword);

        verify(userRepository, times(1)).save(any(User.class));
    }
}