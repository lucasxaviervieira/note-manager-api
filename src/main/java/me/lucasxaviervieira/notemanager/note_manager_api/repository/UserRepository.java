package me.lucasxaviervieira.notemanager.note_manager_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.lucasxaviervieira.notemanager.note_manager_api.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
