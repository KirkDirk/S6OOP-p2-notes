import controllers.NoteController;
import interfaces.NMSingle;
import interfaces.NotesManagable;
import interfaces.SAImpl;
import interfaces.StorageActions;
import views.ViewNotes;

public class Main {
    public static void main(String[] args) {
        /** Путь к файлу, который содержит общие данные по записям */
        final String commonFile = "storage\\notes.txt";
        /** Приветственное слово */
        System.out.println("Привет! Это проект Записки, содержащий работу с записками из консоли");
        /**
         * Считываем и показываем количество записей в проекте. Файл notes.txt хранит
         * общие данные по количеству записей
         */
        int numberOfNotes = new SAImpl(commonFile).getNumberOfNotes();
        System.out.println(String.format("На сегодня в базе хранится %d записей", numberOfNotes));

        /**
         * Стартуем проект. Используем "+1" для имён файлов - запись №1
         * соответствует файлу с именем "note1.txt"
         */
        String fn = "storage\\note" + (numberOfNotes + 1) + ".txt";
        StorageActions storageActions = new SAImpl(fn);
        NotesManagable notesManagable = new NMSingle(storageActions);
        NoteController noteController = new NoteController(notesManagable);
        ViewNotes view = new ViewNotes(noteController);
        view.run();
    }
}