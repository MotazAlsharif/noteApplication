package com.motaz.noteApplication.controller;

import com.motaz.noteApplication.mapper.NoteMapper;

import com.motaz.noteApplication.model.entity.Note;

import com.motaz.noteApplication.model.dto.NoteDto;

import com.motaz.noteApplication.service.NoteService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteMapper noteMapper;

    @PostMapping

    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto noteDto) {
        Note note = noteService.createNote(noteMapper.fromDto(noteDto));
        NoteDto createdNoteDto = noteMapper.toDto(note);
        return new ResponseEntity<>(createdNoteDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")

    public ResponseEntity<NoteDto> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        if (note != null) {
            NoteDto noteDto = noteMapper.toDto(note);
            return new ResponseEntity<>(noteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping

    public ResponseEntity<List<NoteDto>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        List<NoteDto> noteDtos = noteMapper.toDto(notes);
        return new ResponseEntity<>(noteDtos ,HttpStatus.OK);
    }

    @PutMapping("/{id}")

    public ResponseEntity<NoteDto> updateNoteById(@PathVariable Long id, @RequestBody NoteDto noteDto) {
        Note note = noteService.updateNoteById(id, noteMapper.fromDto(noteDto));
        if (note != null) {
            NoteDto updatedNoteDto = noteMapper.toDto(note);
            return new ResponseEntity<>(updatedNoteDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}