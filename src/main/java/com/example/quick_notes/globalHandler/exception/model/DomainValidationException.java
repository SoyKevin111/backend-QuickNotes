package com.example.quick_notes.globalHandler.exception.model;

import com.example.quick_notes.globalHandler.exception.HandlerException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class DomainValidationException extends HandlerException {
   public DomainValidationException(HttpStatus status, List<String> errors) {
      super(status, errors);
   }


}
