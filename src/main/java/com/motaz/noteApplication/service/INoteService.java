package com.motaz.noteApplication.service;



import com.motaz.noteApplication.model.entity.Note;

import java.util.List;

public interface INoteService {

    Note createNote(Note note);

    Note getNoteById(Long id);

    List<Note> getAllNotes();

    Note updateNoteById(Long id, Note note);

    void deleteNoteById(Long id);
}
