package com.example.quick_notes.globalHandler.exception.request;

import com.example.quick_notes.globalHandler.exception.HandlerException;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RequestValidationException extends HandlerException {

   public RequestValidationException(HttpStatus status, List<String> errors) {
      super(status, errors);
   }
}
