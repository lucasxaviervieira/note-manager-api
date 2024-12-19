package me.lucasxaviervieira.notemanager.note_manager_api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import me.lucasxaviervieira.notemanager.note_manager_api.security.JwtUtil;

@SpringBootTest
@AutoConfigureMockMvc
class ProtectedEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtil jwtUtil;

    @Test
    void testAccessProtectedEndpointWithoutToken() throws Exception {
        mockMvc.perform(get("/test/protected"))
                .andExpect(status().isForbidden());
    }

    @Test
    void testAccessProtectedEndpointWithValidToken() throws Exception {
        String token = jwtUtil.generateToken("testuser");

        mockMvc.perform(get("/test/protected")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }
}