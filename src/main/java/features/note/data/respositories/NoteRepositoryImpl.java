package features.note.data.respositories;

import core.errors.exceptions.DatabaseException;
import core.errors.failures.DataBaseFailure;
import core.errors.failures.Failure;
import features.note.data.datasources.NoteDataSource;
import features.note.domain.entities.Note;
import features.note.domain.repositories.NoteRepository;
import io.vavr.control.Either;

import java.util.Map;
import java.util.UUID;

public class NoteRepositoryImpl implements NoteRepository {

    private final NoteDataSource noteDataSource;

    public NoteRepositoryImpl(NoteDataSource noteDataSource) {
        this.noteDataSource = noteDataSource;
    }

    public Either<Failure, Note> addNote(String text) {
        try {
            Note noteAdded = noteDataSource.addNote(text);

            return Either.right(noteAdded);
        } catch (DatabaseException e) {
            return Either.left(new DataBaseFailure());
        }
    }

    public Either<Failure, Note> deleteNote(UUID noteId) {
        try {
            Note noteAdded = noteDataSource.deleteNote(noteId);

            return Either.right(noteAdded);
        } catch (DatabaseException e) {
            return Either.left(new DataBaseFailure());
        }
    }

    @Override
    public Either<Failure, Map<UUID, Note>> getAllNotes() {
        try {
            Map<UUID, Note> noteMap = noteDataSource.getAllNotes();
            return Either.right(noteMap);
        } catch (Exception e) {
            return Either.left(new DataBaseFailure());
        }
    }


}
