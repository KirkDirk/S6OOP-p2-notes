package controllers;

import java.util.List;

import interfaces.NotesManagable;
import models.Note;
import models.NoteWork;

public class NoteController {
    private NotesManagable notesManagable;

    public NoteController(NotesManagable notesManagable) {
        this.notesManagable = notesManagable;
    }

    /**
     * Возвращает количество Записей в хранилище
     * 
     * @return int
     */
    public int getNumberOfNotes() {
        return notesManagable.getNumberOfNotes();
    }

    /**
     * Создание Записи и запись Записи в файл noteID.txt
     * 
     * @param note - запись в формате (ID::Title::Text)
     */
    public void saveNote(NoteWork note) {
        notesManagable.saveNoteToTxt(note);
    }

    /**
     * Получаем список всех Записей в Storage.
     * 
     * @return List<Note>
     */
    public List<Note> getAllNotes() {
        return notesManagable.getAllNotes(getNumberOfNotes());
    }

    /**
     * Проверка ID на существование
     * 
     * @param idNoteString - введённое значение ID
     * @throws Exception
     */
    public void validationID(String idNoteString) throws Exception {
        if (Integer.parseInt(idNoteString) > this.getNumberOfNotes() ||
                Integer.parseInt(idNoteString) < 0)
            throw new Exception("ID not found");
    }

    /**
     * Возвращаем Запись, искомую по ID
     * 
     * @param idNote - ID искомой Записи
     * @return NoteWork
     * @throws Exception
     */
    public NoteWork readAnyNoteWork(String idNote) throws Exception {
        validationID(idNote);
        return notesManagable.readAnyNote(idNote);
    }

    /**
     * Перезапись Записи
     * 
     * @param readN - считанная Запись для изменения
     * @param updN  - новые данные для записи в Запись
     */
    public void updateNote(NoteWork readN, NoteWork updN) {
        notesManagable.updateNote(readN, updN);
    }

    /**
     * Удаление Записи, задаваемой по ID. При удалении в Хранилище файл
     * перезаписывается с указание даты и времени удаления Записи
     * 
     * @param id - ID удаляемой записи
     */
    public void deleteNote(String id) {
        notesManagable.deleteNote(id);
    }
}
