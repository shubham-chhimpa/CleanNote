package features.note.domain.entities;

import java.util.UUID;

public class Note {
    private final UUID noteId;
    private final String text;

    public Note(UUID noteId, String text) {
        this.noteId = noteId;
        this.text = text;
    }

    public UUID getNoteId() {
        return noteId;
    }

    public String getText() {
        return text;
    }
}
