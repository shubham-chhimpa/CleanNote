package features.note.data.datasources;

import core.errors.exceptions.DatabaseException;
import features.note.data.models.NoteModel;
import features.note.domain.entities.Note;

import java.util.*;

public class NoteInMemoryDataSourceImpl implements NoteDataSource {

    //Dummy InMemory Database
    private final Map<UUID, NoteModel> notes = new HashMap<UUID, NoteModel>();

    public NoteInMemoryDataSourceImpl() {
        UUID randomID = UUID.randomUUID();
        notes.put(randomID, new NoteModel(randomID, "note 1"));
        randomID = UUID.randomUUID();
        notes.put(randomID, new NoteModel(randomID, "note 2"));
        randomID = UUID.randomUUID();
        notes.put(randomID, new NoteModel(randomID, "note 3"));
    }

    public NoteModel addNote(String text) throws DatabaseException {
        UUID id = UUID.randomUUID();
        NoteModel noteModel = new NoteModel(id, text);
        try {
            notes.put(id, noteModel);
        } catch (Exception e) {
            throw new DatabaseException();
        }
        return noteModel;
    }

    public NoteModel deleteNote(UUID noteId) throws DatabaseException {
        NoteModel deleteNoteModel;
        try {
            deleteNoteModel = notes.get(noteId);
        } catch (Exception e) {
            throw new DatabaseException();
        }
        return deleteNoteModel;
    }

    public Map<UUID, Note> getAllNotes() throws DatabaseException {
        try {
            Map<UUID, Note> noteMap = new HashMap<>();
            for (UUID noteId : notes.keySet()) {
                Note currNote = notes.get(noteId);
                noteMap.put(noteId, currNote);
            }
            return noteMap;
        } catch (Exception e) {
            throw new DatabaseException();
        }
    }
}
