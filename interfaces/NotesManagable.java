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

    /**
     * Обновляем данные для Записи
     * @param readN - считываемая (старая) Запись
     * @param updN - новая Запись
     */
    public void updateNote(NoteWork readN, NoteWork updN);

    /**
     * Удаляем Запись, заданную по ID. Используем saveNote для перезаписи файла 
     * с удаляемой записью 
     * @param id - ID удаляемой записи
     */
    public void deleteNote(String id);
}
