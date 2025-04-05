package com.example.quick_notes.domain.port.in.usecases;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.NoteRequest;

import java.util.List;
import java.util.Optional;

public interface INoteUseCase {
   Note create(NoteRequest noteRequest);
   Note update(NoteRequest noteRequest, Long id);
   void deleteById(Long id);
   Optional<Note> findById(Long id);
   List<Note> findAll();
}
