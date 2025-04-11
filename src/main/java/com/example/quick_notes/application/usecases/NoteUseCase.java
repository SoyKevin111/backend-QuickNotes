package com.example.quick_notes.application.usecases;

import com.example.quick_notes.application.validation.NoteValidatorUseCase;
import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.request.CreateNoteRequest;
import com.example.quick_notes.domain.port.in.usecases.INoteUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
import com.example.quick_notes.domain.request.UpdateNoteRequest;
import com.example.quick_notes.domain.validation.request.NoteRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteUseCase implements INoteUseCase {

   @Autowired
   INoteRepository noteRepository;
   @Autowired
   NoteRequestValidator noteRequestValidator;
   @Autowired
   NoteValidatorUseCase noteValidatorUseCase;

   @Override
   public Note create(CreateNoteRequest createNoteRequest) {
      this.noteRequestValidator.createValidator(createNoteRequest); //data
      this.noteValidatorUseCase.validateNoteTitleExistence(createNoteRequest.getTitle()); //existence title
      try {
         Note note = new Note();
         note.setTitle(createNoteRequest.getTitle());
         note.setEmojiRef(createNoteRequest.getEmojiRef());
         note.setDescription(createNoteRequest.getDescription());
         return this.noteRepository.save(note);
      } catch (Exception ex) {
         throw new RuntimeException(""); //excepcion generica del servidor.
      }
   }

   @Override
   public Note update(UpdateNoteRequest updateNoteRequest, Long id) {
      this.noteValidatorUseCase.validateNoteTitleExistence(updateNoteRequest.getTitle()); //existence title
      //data
      Note note = this.noteValidatorUseCase.validateNoteByIdExistence(id); //existence
      note.setTitle(updateNoteRequest.getTitle());
      note.setDescription(updateNoteRequest.getDescription());
      System.out.println(note);
      try {
         return this.noteRepository.save(note);
      } catch (Exception ex) {
         throw new RuntimeException(""); //excepcion generica del servidor.
      }
   }

   @Override
   public void deleteById(Long id) {

   }

   @Override
   public Optional<Note> findById(Long id) {
      return Optional.empty();
   }

   @Override
   public List<Note> findAll() {
      return this.noteRepository.findAll();
   }
}
