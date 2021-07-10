package features.note.data.datasources;

import core.errors.exceptions.DatabaseException;
import features.note.data.models.NoteModel;
import features.note.domain.entities.Note;

import java.util.Map;
import java.util.UUID;

public interface NoteDataSource {
    NoteModel addNote(String text) throws DatabaseException;

    NoteModel deleteNote(UUID noteId) throws DatabaseException;

    Map<UUID, Note> getAllNotes() throws DatabaseException;
}
