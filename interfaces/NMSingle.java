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
    public int getNumberOfNotes() {
        return storageActions.getNumberOfNotes();
    }

    @Override
    public void saveNoteToTxt(NoteWork note) {
        storageActions.saveCommonData(note.getIdNote());
        String lineNote = storageActions.noteToString(note);
        storageActions.saveNote(lineNote);
    }

    @Override
    public List<Note> getAllNotes(int numberOfNotes) {
        List<Note> listAllNotes = new ArrayList<>();
        for (int i = 1; i <= numberOfNotes; i++) {
            String fileName = storageActions.createFileName(String.valueOf(i));
            Note note = storageActions.readAnyFileFromStorage(fileName);
            listAllNotes.add(note);
        }
        return listAllNotes;
    }

    @Override
    public NoteWork readAnyNote(String idFindNote) {
        NoteWork note = storageActions.readAnyFileFromStorage(storageActions.createFileName(idFindNote));
        return note;
    }

    @Override
    public void updateNote(NoteWork readN, NoteWork updN) {
        if (updN.getTitleNote() != "") {
            readN.setTitleNote(updN.getTitleNote());
        }
        if (updN.getTextNote() != "") {
            readN.setTextNote(updN.getTextNote());
        }
        storageActions.saveNote(storageActions.noteToString(readN), storageActions.createFileName(String.valueOf(readN.getIdNote())));
    }

    @Override
    public void deleteNote(String id) {
        NoteWork delNote = this.readAnyNote(id);
        delNote.setTitleNote("Удалена");
        delNote.setTextNote("Время и дата удаления: " + java.time.ZonedDateTime.now());
        storageActions.saveNote(storageActions.noteToString(delNote), storageActions.createFileName(id));
    }

    

}
