package interfaces;

import java.util.ArrayList;
import java.util.List;

import models.Note;
import models.NoteWork;

public class NMSingle implements NotesManagable {
    private StorageActions storageActions;

    public NMSingle(StorageActions storageActions) {
        this.storageActions = storageActions;
    }
    
    @Override
    public int getNumberOfNotes(){
        return storageActions.getNumberOfNotes();
    }

    /** Преобразование класса Записи (note) в строку (noteToLine) */
    @Override
    public void saveNoteToTxt(NoteWork note) {
        storageActions.saveCommonData(note.getIdNote());
        String lineNote = storageActions.noteToString(note);
        storageActions.saveNote(lineNote);
    }

    /** Получение всех Записей из хранилища */
    @Override
    public List<Note> getAllNotes(int numberOfNotes) {
        List<Note> listAllNotes = new ArrayList<>();
        for (int i = 1; i <= numberOfNotes; i++) {
            /** Формируем имя читаемого файла из хранилища */
            String fileName = "storage\\note" + i + ".txt";
            Note note = storageActions.readAnyFileFromStorage(fileName);
            listAllNotes.add(note);
        }
        return listAllNotes;
    }
    
}
