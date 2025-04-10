package com.example.quick_notes.infraestructure.adapter.out.persistence.databases;

import com.example.quick_notes.infraestructure.adapter.out.persistence.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepositorySql extends JpaRepository<NoteEntity, Long> {
   boolean existsByTitle(String title);
}
