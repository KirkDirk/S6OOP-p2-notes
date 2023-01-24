package interfaces;

public interface StorageActions {
    void saveCommonData(int id);
    void saveNote(String line);

    /**
     * Возвращает количество записей всего в проекте
     * @return int
     */
    int getNumberOfNotes();
}
