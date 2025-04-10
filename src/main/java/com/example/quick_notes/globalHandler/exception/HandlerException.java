package com.example.quick_notes.globalHandler.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class HandlerException extends RuntimeException {

   private HttpStatus status;
   private List<String> errors;

   // Constructor
   public HandlerException(HttpStatus status ,List<String> errors) {
      this.status = status;
      this.errors = errors;
   }

   // Getters y setters
   public HttpStatus getStatus() {
      return status;
   }

   public void setStatus(HttpStatus status) {
      this.status = status;
   }

   public List<String> getErrors() {
      return errors;
   }

   public void setErrors(List<String> errors) {
      this.errors = errors;
   }
}
