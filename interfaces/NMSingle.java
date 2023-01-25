package interfaces;

import java.util.ArrayList;
import java.util.List;

import models.Note;

public class NMSingle implements NotesManagable {
    private StorageActions storageActions;

    public NMSingle(StorageActions storageActions) {
        this.storageActions = storageActions;
    }

    @Override
    public void createNote(Note note) {
        // TODO Auto-generated method stub

    }

    /** Преобразование класса Записи (note) в строку (noteToLine) */
    @Override
    public void saveNoteToTxt(Note note) {
        String noteToLine = note.getIdNote() + "::" + note.getTitleNote() + "::" + note.getTextNote();
        storageActions.saveCommonData(note.getIdNote());
        storageActions.saveNote(noteToLine);
    }

    @Override
    public List<String> getAllNotes(int numberOfNotes) {
        List<String> listAllFiles = new ArrayList<String>();
        for (int i = 1; i <= numberOfNotes; i++) {
            String fileName = "storage\\note" + i + ".txt";
            String note = storageActions.readAnyFileFromStorage(fileName);
            listAllFiles.add(note);
        }
        return null;
    }

}
