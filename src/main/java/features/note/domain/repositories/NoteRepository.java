package features.note.domain.repositories;

import core.errors.failures.Failure;
import features.note.data.models.NoteModel;
import features.note.domain.entities.Note;
import io.vavr.control.Either;

import java.util.Map;
import java.util.UUID;

public interface NoteRepository {
    Either<Failure, Note> addNote(String text);

    Either<Failure, Note> deleteNote(UUID noteId);

    Either<Failure, Map<UUID, Note>> getAllNotes();
}
