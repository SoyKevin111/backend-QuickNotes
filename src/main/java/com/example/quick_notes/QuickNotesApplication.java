package com.example.quick_notes;

import com.example.quick_notes.infraestructure.adapter.out.persistence.databases.NoteRepositorySql;
import com.example.quick_notes.infraestructure.adapter.out.persistence.entities.NoteEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class QuickNotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickNotesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(
		NoteRepositorySql noteRepository
	){
		return args -> {
			NoteEntity noteEntity1 = new NoteEntity();
			noteEntity1.setTitle("Tarea para la casa");
			noteEntity1.setDescription("lorem ipsum dor, pon mas");
			noteEntity1.setEmojiRef("Cansado");

			NoteEntity noteEntity2 = new NoteEntity();
			noteEntity2.setTitle("Comprar víveres");
			noteEntity2.setDescription("Arroz, frijoles, leche");
			noteEntity2.setEmojiRef("Animado");

			NoteEntity noteEntity3 = new NoteEntity();
			noteEntity3.setTitle("Estudiar Java");
			noteEntity3.setDescription("Repasar clases y métodos");
			noteEntity3.setEmojiRef("Libros");

			NoteEntity noteEntity4 = new NoteEntity();
			noteEntity4.setTitle("Hacer ejercicio");
			noteEntity4.setDescription("Correr 5km");
			noteEntity4.setEmojiRef("Esfuerzo");

			NoteEntity noteEntity5 = new NoteEntity();
			noteEntity5.setTitle("Reunión de trabajo");
			noteEntity5.setDescription("Discutir proyectos nuevos");
			noteEntity5.setEmojiRef("Trabajo");

			noteRepository.saveAll(List.of(noteEntity1, noteEntity2, noteEntity3, noteEntity4, noteEntity5));
		};
	}


}
