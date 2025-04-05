package com.example.quick_notes.application.usecases.note;

import com.example.quick_notes.domain.port.in.usecases.note.IDeleteNoteUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteNoteUseCase implements IDeleteNoteUseCase {

   @Autowired
   INoteRepository noteRepository;


   @Override
   public void deleteNote(Long id) {

   }
}
