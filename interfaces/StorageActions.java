package interfaces;

import models.NoteWork;

public interface StorageActions {
    /**
     * Обновление общих данных в общем файле хранилища
     * @param id - количество записей
     */
    void saveCommonData(int id);
    
    /**
     * Создаем Запись и записываем в файл.
     * @param line - параметр, 
     */
    void saveNote(String line);

    /**
     * Возвращает количество записей всего в проекте
     * @return int
     */
    int getNumberOfNotes();

    /**
     * Возвращает Запись из читаемого файла
     * @param fileName - имя читаемого файла
     * @return String
     */
    NoteWork readAnyFileFromStorage(String fileName);

    /**
     * Возвращает Запись в виде строки
     * @return
     */
    String noteToString(NoteWork note); 
}
