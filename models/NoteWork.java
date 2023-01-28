package models;
/**
 * класс Записка типа Рабочая
 */
public class NoteWork extends Note {
    /**
     * Поле Записки типа Рабочая - контрагент. 
     * Начальное значение "none"
     */
    private String partnerNote = "none";

    /**
     * Конструктор класса Записка типа Рабочая c 3 полями
     * @param idNote
     * @param titleNote
     * @param textNote
     */
    public NoteWork(int idNote, String titleNote, String textNote) {
        super(idNote, titleNote, textNote);        
    }
    /**
     * Конструктор класса Записка типа Рабочая c 4 полями
     * @param idNote
     * @param titleNote
     * @param textNote
     * @param partnerNote
     */
    public NoteWork(int idNote, String titleNote, String textNote, String partnerNote) {
        this(idNote, titleNote, textNote);
        this.partnerNote = partnerNote;
    }

    public NoteWork() {
        super();
    }
    public String getPartnerNote() {
        return partnerNote;
    }
    public void setPartnerNote(String partnerNote) {
        this.partnerNote = partnerNote;
    }
    @Override
    public String toString() {
        return String.format("Идентификатор: %s\nЗаголовок: %s\nТекст: %s\nКонтрагент: %s", idNote, titleNote, textNote, partnerNote);
    }
 

}
