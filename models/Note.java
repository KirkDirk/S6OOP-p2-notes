package models;
/** Абстрактный класс "Записка" */
public abstract class Note {
    /**
     * ID записи абстрактного класса "Записка"
     */
    protected int idNote;
    /**
     * Заголовок записи абстрактного класса "Записка"
     */
    protected String titleNote;
    /**
     * Текст записи абстрактного класса "Записка"
     */
    protected String textNote;

    /**
     * Конструктор абстрактного класса "Записка"
     * @param idNote -ID записи абстрактного класса "Записка"
     * @param titleNote - Заголовок записи абстрактного класса "Записка"
     * @param textNote -Текст записи абстрактного класса "Записка"
     */  
    public Note(int idNote, String titleNote, String textNote) {
        this.idNote = idNote;
        this.titleNote = titleNote;
        this.textNote = textNote;
    }
    /**
     * Возвращает ID записи
     * @return - int idNote
     */
    public int getIdNote() {
        return idNote;
    }    
    public String getTitleNote() {
        return titleNote;
    }
    public String getTextNote() {
        return textNote;
    }
    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }
    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }
    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }
}
