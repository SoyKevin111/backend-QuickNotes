package com.example.quick_notes.infraestructure.adapter.in.rest;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.NoteRequest;
import com.example.quick_notes.domain.port.in.usecases.INoteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

   @Autowired
   INoteUseCase noteUseCase;

   @PostMapping
   public ResponseEntity<?> create(@RequestBody NoteRequest noteRequest){
      Note note =  this.noteUseCase.create(noteRequest);
      if(note != null){
         return ResponseEntity.ok().body(note);
      }
      return ResponseEntity.badRequest().build();
   }

   @GetMapping
   public List<Note> findAll(){
      return this.noteUseCase.findAll();
   }

}
