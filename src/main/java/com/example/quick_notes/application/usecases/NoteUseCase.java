package com.example.quick_notes.application.usecases;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.NoteRequest;
import com.example.quick_notes.domain.port.in.usecases.INoteUseCase;
import com.example.quick_notes.domain.port.out.INoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteUseCase implements INoteUseCase {

   @Autowired
   INoteRepository noteRepository;

   @Override
   public Note create(NoteRequest noteRequest) {
      try {
         Note note = new Note();
         note.setTitle(noteRequest.getTitle());
         note.setEmojiRef(noteRequest.getEmojiRef());
         note.setDescription(noteRequest.getDescription());
         return this.noteRepository.save(note);
      }
      catch (Exception e){
         throw new RuntimeException("Error al guardar la Nota."+e.getMessage());
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
