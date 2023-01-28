package controllers;

import java.util.List;

import interfaces.NotesManagable;
import models.Note;

public class NoteController {
    private NotesManagable notesManagable;
       
    public NoteController(NotesManagable notesManagable) {
        this.notesManagable = notesManagable;
    }
    
    /**
     * Возвращает количество Записей в хранилище
     * @return int
     */
    public int getNumberOfNotes(){
        return notesManagable.getNumberOfNotes();
    }
    
    /**
     * Создание Записи и запись Записи в файл noteID.txt
     * @param note - запись в формате (ID::Title::Text)
     */
    public void saveNote(Note note){
        notesManagable.saveNoteToTxt(note);
    }
    /**
     * Получаем список всех Записей в Storage.
     * @return List<String>
     */
    public List<Note> getAllNotes(){
        return notesManagable.getAllNotes(getNumberOfNotes());
    }
}
