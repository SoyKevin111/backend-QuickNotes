package com.example.quick_notes.globalHandler.exception;

import com.example.quick_notes.globalHandler.exception.model.DomainValidationException;
import com.example.quick_notes.globalHandler.exception.request.RequestValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class HandlerExceptionController {

   //Para errores de Dominio
   @ExceptionHandler(DomainValidationException.class)
   public ResponseEntity<Map<String, Object>> globalDomainException(DomainValidationException ex) {
      String type = "[Domain Error]";
      Map<String, Object> response = Map.of(
         "status", ex.getStatus().toString(),
         "type", type,
         "errors", ex.getErrors()
      );
      return ResponseEntity
         .status(ex.getStatus())  //cabecera http
         .body(response);
   }

   //Para errores de Entrada
   @ExceptionHandler(RequestValidationException.class)
   public ResponseEntity<Map<String, Object>> globalDomainException(RequestValidationException ex) {
      String type = "[Input Error]";
      Map<String, Object> response = Map.of(
         "status", ex.getStatus().toString(),
         "type", type,
         "errors", ex.getErrors()
      );
      return ResponseEntity
         .status(ex.getStatus())  //cabecera http
         .body(response);
   }

   //Validaciones Generico Falla en el servidor interno.
   @ExceptionHandler(Exception.class)
   public ResponseEntity<Map<String, String>> handleGeneric(Exception ex) {
      return ResponseEntity
         .status(HttpStatus.INTERNAL_SERVER_ERROR)
         .body(Map.of("message", "Server Internal Error,"));
   }


}




/*
{
  "status": "BAD_REQUEST",
  "type": "[Domain Error]",
  "errors": [
    "Error 1",
    "Error 2"
  ]
}

 */
