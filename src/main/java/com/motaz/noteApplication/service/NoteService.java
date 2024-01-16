package com.motaz.noteApplication.service;

import com.motaz.noteApplication.model.dto.NoteDto;
import com.motaz.noteApplication.model.entity.Note;
import com.motaz.noteApplication.repository.Noterepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements INoteService{

    @Autowired
    private Noterepository noteRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note getNoteById(Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            return noteOptional.get();
        } else {
            return null;
        }
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note updateNoteById(Long id, Note note) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Note existingNote = noteOptional.get();
            existingNote.setTitleEn(note.getTitleEn());
            existingNote.setTitleAr(note.getTitleAr());
            existingNote.setContent(note.getContent());
            return noteRepository.save(existingNote);
        } else {
            return null;
        }
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

}