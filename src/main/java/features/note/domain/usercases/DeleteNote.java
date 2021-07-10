package features.note.domain.usercases;

import core.errors.failures.Failure;
import core.errors.usecase.UseCase;
import features.note.domain.entities.Note;
import features.note.domain.repositories.NoteRepository;
import io.vavr.control.Either;

import java.util.UUID;

public class DeleteNote implements UseCase<Note, DeleteNote.Params> {
    final private NoteRepository noteRepository;

    public DeleteNote(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public Either<Failure, Note> execute(Params params) {
        return noteRepository.deleteNote(params.noteId);
    }

    public static class Params {
        final public UUID noteId;

        public Params(UUID noteId) {
            this.noteId = noteId;
        }
    }
}
