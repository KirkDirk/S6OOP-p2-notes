package interfaces;

import java.util.List;

import models.Note;
import models.NoteWork;
/**
 * Интерфейс управления записями
 */
public interface NotesManagable {
    /**
     * Создание Записи
     * @param note - Запись(ID::Title::Text)
     */
    public void saveNoteToTxt(NoteWork note);
    
    /**
     * Получаем список Записей из хранилища
     * @param numberOfNotes - количество всех Записей
     * @return List<Note>
     */
    public List<Note> getAllNotes(int numberOfNotes);
    
    /**
     * Добывает количестов Записей из хранилища
     * @return int
     */
    public int getNumberOfNotes();

    /**
     * Считываем Запись по ID
     * @return
     */
    public NoteWork readAnyNote(String idFindNote);
}
