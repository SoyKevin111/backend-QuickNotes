package com.example.quick_notes.application.usecases.note;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.port.in.usecases.note.IFindAllNotesUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FindAllNotesUseCase implements IFindAllNotesUseCase {

   @Autowired
   INoteRepository noteRepository;


   @Override
   public List<Note> findAllNotes() {
      return List.of();
   }
}
