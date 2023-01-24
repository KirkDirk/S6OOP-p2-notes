package controllers;

import interfaces.NotesManagable;
import models.Note;

public class NoteController {
    private NotesManagable notesManagable;
       
    public NoteController(NotesManagable notesManagable) {
        this.notesManagable = notesManagable;
    }

    public void saveNote(Note note){
        notesManagable.saveNoteToTxt(note);
    }
}
