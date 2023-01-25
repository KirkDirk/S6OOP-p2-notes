package interfaces;

import java.util.List;

import models.NoteWork;

public interface StorageActions {
    void saveCommonData(int id);
    void saveNote(String line);

    /**
     * Возвращает количество записей всего в проекте
     * @return int
     */
    int getNumberOfNotes();

    /**
     * Возвращает список Записей (ID, Заголовок, Текст)
     * @return List<Note>
     */
    List<NoteWork> readAllFilesFromStorage();

    /**
     * Возвращает Запись из читаемого файла
     * @param fileName - имя читаемого файла
     * @return Note
     */
    String readAnyFileFromStorage(String fileName);
}
