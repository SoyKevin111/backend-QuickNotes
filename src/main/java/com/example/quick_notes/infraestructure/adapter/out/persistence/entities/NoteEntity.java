package com.example.quick_notes.infraestructure.adapter.out.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "note_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
   @Column(name = "name")
   String name;
   @Column(name = "description",columnDefinition = "TEXT")
   String description;
}
