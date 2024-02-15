package com.nagarro.mini.java.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.nagarro.mini.java.assignment.model.Notes;
import com.nagarro.mini.java.assignment.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	NoteRepository noterepo;

	public void saveNotes(Notes note) {
		noterepo.save(note);

	}

	public void deleteNote(int id) {
		Notes a = noterepo.getOne(id);
		noterepo.delete(a);

	}

	public List<Notes> findAllNotes() {
		List<Notes> allNotes = noterepo.findAll();

		return allNotes;
	}

	@Scheduled(fixedRate = 300000)

	public void deleteNotes() {
		List<Notes> recentRecords = noterepo.findTop20ByOrderByCreatedAtDesc();
		if (recentRecords.size() > 10) {
			List<Notes> recordsToDelete = recentRecords.subList(0, recentRecords.size()-10);
			noterepo.deleteAll(recordsToDelete);
			
		}

	}

}
