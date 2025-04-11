package com.example.quick_notes.application.validation;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.port.out.INoteRepository;
import com.example.quick_notes.globalHandler.exception.request.RequestValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NoteValidatorUseCase {

   @Autowired
   INoteRepository noteRepository;

   public void validateNoteTitleExistence(String title) {
      if (this.noteRepository.existsNoteByTitle(title)) {
         throw new RequestValidationException(
            HttpStatus.CONFLICT,
            List.of("Title alreadey exists.")
         );
      }
   }

   public Note validateNoteByIdExistence(Long id){
      Optional<Note> noteOptional = this.noteRepository.findById(id);
      if(noteOptional.isPresent()){
         return noteOptional.get();
      }

      throw new RequestValidationException(
         HttpStatus.CONFLICT,
         List.of("Note not found.")
      );
   }

}
