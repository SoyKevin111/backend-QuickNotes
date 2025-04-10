package com.example.quick_notes.application.usecases;

import com.example.quick_notes.application.validation.NoteValidatorUseCase;
import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.NoteRequest;
import com.example.quick_notes.domain.port.in.usecases.INoteUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
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
   public Note create(NoteRequest noteRequest) {
      this.noteRequestValidator.createValidator(noteRequest);
      this.noteValidatorUseCase.validateNoteTitleExistence(noteRequest.getTitle());
      try {
         Note note = new Note();
         note.setTitle(noteRequest.getTitle());
         note.setEmojiRef(noteRequest.getEmojiRef());
         note.setDescription(noteRequest.getDescription());
         return this.noteRepository.save(note);
      } catch (Exception ex) {
         throw new RuntimeException(""); //excepcion generica del servidor.
      }
   }

   @Override
   public Note update(NoteRequest noteRequest, Long id) {
      return null;
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
