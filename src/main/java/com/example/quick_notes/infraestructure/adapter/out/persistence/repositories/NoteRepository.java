package com.example.quick_notes.infraestructure.adapter.out.persistence.repositories;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.domain.port.out.INoteRepository;
import com.example.quick_notes.infraestructure.adapter.out.persistence.databases.NoteRepositorySql;
import com.example.quick_notes.infraestructure.adapter.out.persistence.entities.NoteEntity;
import com.example.quick_notes.infraestructure.adapter.out.persistence.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository implements INoteRepository {

   @Autowired
   NoteRepositorySql noteRepository;
   @Autowired
   NoteMapper mapper;

   @Override
   public Note save(Note note) {
      NoteEntity noteEntity = this.mapper.toEntity(note);
      return this.mapper.toDomain(this.noteRepository.save(noteEntity));
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
      return ((List<NoteEntity>) this.noteRepository.findAll())
         .stream().map(noteEntity ->
            this.mapper.toDomain(noteEntity)
         ).toList();
   }
}
