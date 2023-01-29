package views;

import java.util.List;
import java.util.Scanner;

import controllers.NoteController;
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
                        System.out.println("Записано!\n-----------------------");
                        break;
                    case READ:
                        String idFindNote = prompt("Введите ID для чтения: ");
                        NoteWork printFindedNote = noteController.readAnyNoteWork(idFindNote);
                        System.out.println("-----------------------\nЗапись № " + idFindNote);
                        System.out.println(printFindedNote.toString());
                        break;
                    case LIST:
                        System.out.println("Всего записей: " + noteController.getNumberOfNotes());
                        System.out.println("-----------------------");
                        List<Note> printedListAllNotes = noteController.getAllNotes();
                        for (Note note : printedListAllNotes) {
                            System.out.println(note.toString()+"\n---");
                        }
                        System.out.println("-----------------------");
                        break;
                    case UPDATE:
                        String idUpdateNote = prompt("Введите ID для замены:");
                        NoteWork readedNote = noteController.readAnyNoteWork(idUpdateNote);
                        System.out.println("Введите обновленные данные");
                        NoteWork updatedNote = getNoteFromConsole();
                        noteController.updateNote(readedNote, updatedNote);
                        System.out.println("Записано!\n-----------------------");
                        break;
                    case DELETE:
                        String idDelNote = prompt("Введите ID для удаления: ");
                        noteController.deleteNote(idDelNote);
                        System.out.println("Запись " + idDelNote + " удалена \n-----------------------");
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
     * @return NoteWork note
     */
    private NoteWork getNoteFromConsole() {
        NoteWork note = new NoteWork();
        /** Устанавливаем для текущей записи значения ID, Заголовка и Текста */
        note.setIdNote(noteController.getNumberOfNotes() + 1);
        note.setTitleNote(prompt("Заголовок: "));
        note.setTextNote(prompt("Текст: "));
        return note;
    }
}
