package com.example.quick_notes.domain.validation.request;

import com.example.quick_notes.infraestructure.adapter.in.dto.CreateNoteRequest;
import com.example.quick_notes.core.globalHandler.exception.request.RequestValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class NoteRequestValidator { //Validacion de Datos de entrada, null, vacio, lenght, etc

   public void createValidator(CreateNoteRequest createNoteRequest) {
      List<String> errors = new ArrayList<>();
      validateField(createNoteRequest.getTitle(), this::titleValidator, errors);
      validateField(createNoteRequest.getDescription(), this::descriptionValidator, errors);
      validateField(createNoteRequest.getEmojiRef(), this::emojiRefValidator, errors);

      if (!errors.isEmpty()) {
         throw new RequestValidationException(
            HttpStatus.BAD_REQUEST,
            errors
         );
      }

   }

   private void validateField(String field, Function<String, String> validator, List<String> errors) {
      String error = validator.apply(field);
      if (error != null) {
         errors.add(error);
      }
   }

   public String titleValidator(String title) {
      if (title == null || title.trim().isEmpty()) {
         return "title is null or empty";
      } else if (title.length() >30) {
         return "title must be 40 characters or fewer ";
      }
      return null;
   }

   public String descriptionValidator(String description) {
      if (description == null || description.isEmpty()) {
         return "description is null or empty";
      }
      return null;
   }

   public String emojiRefValidator(String emojiRef) {
      if (emojiRef == null || emojiRef.isEmpty()) {
         return "emojiRef is null or empty";
      }
      return null;
   }
}
