package com.nagarro.mini.java.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.mini.java.assignment.model.Notes;
import com.nagarro.mini.java.assignment.service.NoteService;

@RestController
@CrossOrigin("http://localhost:4200")
public class NoteController {

	@Autowired
	NoteService noteservice;

	@PostMapping("/Notes")
	public Notes addNotes(@RequestBody Notes note) {
		noteservice.saveNotes(note);
		return note;
	}

	@DeleteMapping("/Notes/{id}")
	public String deleteNote(@PathVariable int id) {

		noteservice.deleteNote(id);
		return "deleted";

	}

	@GetMapping("/Notes")

	public List<Notes> getBooks() {
		return noteservice.findAllNotes();

	}

}
