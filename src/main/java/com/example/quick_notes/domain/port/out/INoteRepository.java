package com.example.quick_notes.domain.port.out;

import com.example.quick_notes.domain.Note;

import java.util.List;
import java.util.Optional;

public interface INoteRepository {
   Note save(Note note);
   Optional<Note> findById(Long id);
   void deleteById(Long id);
   List<Note> findAll();
   boolean existsNoteByTitle(String title);
}
