package interfaces;

import models.Note;
/**
 * Интерфейс управления записями
 */
public interface NotesManagable {
    public void createNote(Note note);
    public void saveNoteToTxt(Note note);
}
