package interfaces;

public interface StorageActions {
    void saveCommonData();
    void saveNote();

    /**
     * Возвращает количество записей
     * @return int
     */
    int getNumberOfNotes();
}
