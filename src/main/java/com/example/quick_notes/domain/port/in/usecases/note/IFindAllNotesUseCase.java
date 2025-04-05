package com.example.quick_notes.domain.port.in.usecases.note;

import com.example.quick_notes.domain.Note;

import java.util.List;

public interface IFindAllNotesUseCase {
   List<Note> findAllNotes();
}
