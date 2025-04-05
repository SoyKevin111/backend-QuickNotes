package com.example.quick_notes.application.usecases.note;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.NoteRequest;
import com.example.quick_notes.domain.port.in.usecases.note.ICreateNoteUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateNoteUseCase implements ICreateNoteUseCase {

   @Autowired
   INoteRepository noteRepository;

   @Override
   public Note create(NoteRequest noteRequest) {
      return null;
   }
}
