package features.note.data.models;

import features.note.domain.entities.Note;

import java.util.UUID;

public class NoteModel extends Note {
    private UUID noteId;
    private String text;

    public NoteModel(UUID noteId, String text) {
        super(noteId, text);
    }
}
