package features.note.domain.usercases;

import core.errors.failures.Failure;
import core.errors.usecase.UseCase;
import features.note.domain.entities.Note;
import features.note.domain.repositories.NoteRepository;
import io.vavr.control.Either;

import java.util.Map;
import java.util.UUID;

public class GetAllNotes implements UseCase<Map<UUID, Note>,GetAllNotes.Params> {
    final private NoteRepository noteRepository;

    public GetAllNotes(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    @Override
    public Either<Failure, Map<UUID, Note>> execute(Params params) {
        return noteRepository.getAllNotes();
    }

    public static class Params {
    }
}
