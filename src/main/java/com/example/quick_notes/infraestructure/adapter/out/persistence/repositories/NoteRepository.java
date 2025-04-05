package com.example.quick_notes.infraestructure.adapter.out.persistence.repositories;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.port.out.INoteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository implements INoteRepository {
   @Override
   public Note save(Note note) {
      return null;
   }

   @Override
   public Optional<Note> findById(Note note) {
      return Optional.empty();
   }

   @Override
   public void deleteById(Long id) {

   }
   @Override
   public List<Note> findAll() {
      return List.of();
   }
}
