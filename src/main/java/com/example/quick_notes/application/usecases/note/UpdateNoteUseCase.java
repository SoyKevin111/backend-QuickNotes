package com.example.quick_notes.application.usecases.note;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.NoteRequest;
import com.example.quick_notes.domain.port.in.usecases.note.IUpdateNoteUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateNoteUseCase implements IUpdateNoteUseCase {

   @Autowired
   INoteRepository noteRepository;


   @Override
   public Note updateNote(NoteRequest noteRequest, Long id) {
      return null;
   }
}
