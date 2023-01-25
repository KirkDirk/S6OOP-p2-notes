package controllers;

import java.util.List;

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

    public List<Note> getAllNotes(){
        
        return null;
    }
}
