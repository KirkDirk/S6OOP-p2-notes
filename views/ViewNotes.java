package views;

import java.util.List;
import java.util.Scanner;

import controllers.NoteController;
import interfaces.SAImpl;
import models.Note;
import models.NoteWork;

public class ViewNotes {
    private NoteController noteController;

    public ViewNotes(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {

        /** Текущий выбор меню пользователем */
        Command com = Command.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            if (com == Command.EXIT)
                return;
            try {
                switch (com) {
                    case CREATE:
                        noteController.saveNote(getNoteFromConsole());
                        break;
                    case READ:

                        break;
                    case LIST:
                        System.out.println("Всего записей: " + noteController.getNumberOfNotes());
                        List<Note> printedListAllNotes = noteController.getAllNotes();
                        for (Note note : printedListAllNotes) {
                            System.out.println(note.toString());
                        }
                        break;
                    case UPDATE:

                        break;
                    case DELETE:

                        break;
                }
            } catch (Exception e) {
                System.out.println("Что-то пошло не так: " + e.getMessage());
            }
        }
    }

    /**
     * Получение данных с одного ввода с консоли
     * 
     * @param message - выводимое сообщение
     * @return String
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    /**
     * Получение Записи с консоли
     * 
     * @return Note note
     */
    private Note getNoteFromConsole() {
        Note note = new NoteWork(0, null, null);
        /**
         * getNON - экземпляр класса SAImpl. Создаётся для получения индекса текущей
         * записи, следующей за последней записью
         */
        SAImpl getNON = new SAImpl("storage\\notes.txt");
        /** Устанавливаем для текущей записи индекс */
        note.setIdNote(getNON.getNumberOfNotes() + 1);
        /** Устанавливаем для текущей записи значения Заголовка и Текста */
        note.setTitleNote(prompt("Заголовок: "));
        note.setTextNote(prompt("Текст: "));
        return note;
    }
}
