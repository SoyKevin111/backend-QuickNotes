package com.example.quick_notes.application.usecases.note;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.port.in.usecases.note.IFindByIdNoteUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FindByIdNoteUseCase implements IFindByIdNoteUseCase {

   @Autowired
   INoteRepository noteRepository;


   @Override
   public Optional<Note> findByIdNote(Long id) {
      return Optional.empty();
   }
}
