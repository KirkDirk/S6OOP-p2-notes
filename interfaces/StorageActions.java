package interfaces;

import models.NoteWork;

public interface StorageActions {
    /**
     * Обновление общих данных в общем файле хранилища -
     * количество Записей всего и дата-время последнего
     * сохранения
     * 
     * @param id - количество записей
     */
    void saveCommonData(int id);

    /**
     * Создаем Запись и записываем в файл.
     * 
     * @param line - параметр,
     */
    void saveNote(String line);

    /**
     * Переопределяем saveNote для использования в случае
     * UPDATE и DELETE
     * 
     * @param line     - записываемая Запись в формате строки
     * @param filename - имя файла за записи Записи
     */
    void saveNote(String line, String filename);

    /**
     * Возвращает количество записей всего в проекте
     * 
     * @return int
     */
    int getNumberOfNotes();

    /**
     * Возвращает Запись из читаемого файла
     * 
     * @param fileName - имя читаемого файла
     * @return String
     */
    NoteWork readAnyFileFromStorage(String fileName);

    /**
     * Возвращает Запись в виде строки по формату ID+Title+Text+dataTime.
     * Разделитель ::
     * 
     * @return
     */
    String noteToString(NoteWork note);

    /**
     * Формирует имя файла для его чтения
     * 
     * @param id - номер ID записи для чтения файла
     * @return String - создаваемый путь до читаемого файла
     */
    String createFileName(String id);

    /**
     * Удаление указанной Записи
     * 
     * @param id - ID удаляемой Записи
     */
    void deleteNote(String id);
}
