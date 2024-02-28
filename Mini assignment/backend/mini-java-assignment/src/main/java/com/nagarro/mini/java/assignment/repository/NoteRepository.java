package com.nagarro.mini.java.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.mini.java.assignment.model.Notes;

public interface NoteRepository extends JpaRepository<Notes, Integer> {
	List<Notes> findTop20ByOrderByCreatedAtDesc();

}
