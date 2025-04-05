package com.example.quick_notes.infraestructure.adapter.out.persistence.mapper;

import com.example.quick_notes.domain.Note;
import com.example.quick_notes.infraestructure.adapter.out.persistence.entities.NoteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

   private final ModelMapper mapper = new ModelMapper();

   public NoteEntity toEntity(Note note){
      return this.mapper.map(note, NoteEntity.class);
   }

   public Note toDomain(NoteEntity noteEntity){
      return this.mapper.map(noteEntity, Note.class);
   }
}
