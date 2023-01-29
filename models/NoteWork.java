package models;
/**
 * класс Записка типа Рабочая
 */
public class NoteWork extends Note {
    /**
     * Поле Записки типа Дата-Время 
     */
    private String dateTime = "none";

    /**
     * Конструктор класса Записка типа Рабочая c 3 полями
     * @param idNote - ID Записки
     * @param titleNote - Заголовок Записки
     * @param textNote - Текст Записки
     */
    public NoteWork(int idNote, String titleNote, String textNote) {
        super(idNote, titleNote, textNote);        
    }
    /**
     * Конструктор класса Записка c 4 полями
     * @param idNote
     * @param titleNote
     * @param textNote
     * @param dateTime
     */
    public NoteWork(int idNote, String titleNote, String textNote, String dateTime) {
        this(idNote, titleNote, textNote);
        this.dateTime = dateTime;
    }

    public NoteWork() {
        super();
    }
    // public String getPartnerNote() {
    //     return partnerNote;
    //}
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    @Override
    public String toString() {
        return String.format("Идентификатор: %s\nЗаголовок: %s\nТекст: %s\nДата-Время: %s", idNote, titleNote, textNote, dateTime);
    }
 

}
