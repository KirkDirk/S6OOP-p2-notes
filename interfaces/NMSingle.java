package interfaces;

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
    
}
