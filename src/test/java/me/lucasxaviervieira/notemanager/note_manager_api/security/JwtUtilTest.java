package me.lucasxaviervieira.notemanager.note_manager_api.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class JwtUtilTest {
    private final JwtUtil jwtUtil = new JwtUtil();
    private final String username = "testuser";

    @Test
    void testGenerateToken() {
        String token = jwtUtil.generateToken(username);
        assertNotNull(token);
    }

    @Test
    void testValidateToken() {
        String token = jwtUtil.generateToken(username);
        assertTrue(jwtUtil.validateToken(token));
    }

    @Test
    void testExtractUsername() {
        String token = jwtUtil.generateToken(username);
        String extractedUsername = jwtUtil.extractUsername(token);
        assertEquals(username, extractedUsername);
    }

    @Test
    void testInvalidToken() {
        String invalidToken = "invalid.token.here";
        assertFalse(jwtUtil.validateToken(invalidToken));
    }
}