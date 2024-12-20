package me.lucasxaviervieira.notemanager.note_manager_api.service;

import org.springframework.stereotype.Service;

import me.lucasxaviervieira.notemanager.note_manager_api.model.Note;
import me.lucasxaviervieira.notemanager.note_manager_api.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(Long id, Note updatedNote) {
        return noteRepository.findById(id).map(note -> {
            note.setTitle(updatedNote.getTitle());
            note.setDescription(updatedNote.getDescription());
            note.setContent(updatedNote.getContent());
            return noteRepository.save(note);
        }).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
