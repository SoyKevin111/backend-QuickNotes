package com.example.quick_notes.application.validation;

import com.example.quick_notes.domain.port.out.INoteRepository;
import com.example.quick_notes.globalHandler.exception.request.RequestValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

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

}
