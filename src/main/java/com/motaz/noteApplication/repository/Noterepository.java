package com.motaz.noteApplication.repository;

import com.motaz.noteApplication.model.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Noterepository extends JpaRepository<Note,Long> {
}
