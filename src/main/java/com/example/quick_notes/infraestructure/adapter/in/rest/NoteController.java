package com.example.quick_notes.infraestructure.adapter.in.rest;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.request.CreateNoteRequest;
import com.example.quick_notes.domain.port.in.usecases.INoteUseCase;
import com.example.quick_notes.domain.request.UpdateNoteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = {"http://localhost:4200"},
   methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
@RequestMapping("/entity/request")
public class NoteController {

   @Autowired
   INoteUseCase noteUseCase;


   @PostMapping("/notes")
   public ResponseEntity<?> create(@RequestBody CreateNoteRequest createNoteRequest) {
      Note note = this.noteUseCase.create(createNoteRequest);
      if (note != null) {
         return ResponseEntity.ok().body(note);
      }
      return ResponseEntity.badRequest().build();
   }

   @PutMapping("/notes/{id}")
   public ResponseEntity<?> update(@RequestBody UpdateNoteRequest updateNoteRequest, @PathVariable Long id) {
      Note note = this.noteUseCase.update(updateNoteRequest, id);
      if (note != null) {
         return ResponseEntity.ok().body(note);
      }
      return ResponseEntity.badRequest().build();
   }


   @GetMapping("/notes")
   public List<Note> findAll() {
      return this.noteUseCase.findAll();
   }

}
