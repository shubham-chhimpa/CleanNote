package features.note.domain.usercases;

import core.errors.failures.Failure;
import core.errors.usecase.UseCase;
import features.note.domain.entities.Note;
import features.note.domain.repositories.NoteRepository;
import io.vavr.control.Either;

public class AddNote implements UseCase<Note, AddNote.Params> {

    private final NoteRepository noteRepository;

    public AddNote(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Either<Failure, Note> execute(Params params) {
        return noteRepository.addNote(params.text);
    }


    public static class Params {

        final public String text;

        public Params(String text) {
            this.text = text;
        }
    }
}
