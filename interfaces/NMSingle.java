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

    @Override
    public void saveNoteToTxt(Note note) {
        // TODO Auto-generated method stub
        
    }
    
}
