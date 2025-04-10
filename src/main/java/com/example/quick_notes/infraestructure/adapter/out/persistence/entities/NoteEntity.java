package com.example.quick_notes.infraestructure.adapter.out.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "note")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;
   @Column(name = "name")
   String title;
   @Column(name = "emoji_ref")
   @NotNull
   String emojiRef;
   @Column(name = "description", columnDefinition = "TEXT")
   String description;
}
