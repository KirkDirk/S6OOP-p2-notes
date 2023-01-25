package interfaces;

import java.util.List;

import models.Note;
/**
 * Интерфейс управления записями
 */
public interface NotesManagable {
    public void createNote(Note note);
    public void saveNoteToTxt(Note note);
    public List<String> getAllNotes(int numberOfNotes);
}
