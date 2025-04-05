package com.example.quick_notes.domain.port.in.usecases.note;

import com.example.quick_notes.domain.Note;

import java.util.Optional;

public interface IFindByIdNoteUseCase {
   Optional<Note> findByIdNote(Long id);
}
