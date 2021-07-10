import core.errors.failures.Failure;
import features.note.data.datasources.NoteDataSource;
import features.note.data.datasources.NoteInMemoryDataSourceImpl;
import features.note.data.models.NoteModel;
import features.note.data.respositories.NoteRepositoryImpl;
import features.note.domain.entities.Note;
import features.note.domain.repositories.NoteRepository;
import features.note.domain.usercases.AddNote;
import features.note.domain.usercases.GetAllNotes;
import io.vavr.control.Either;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    /*
     * Create a Note application
     *
     * 1. we can add a note
     * 2. we can update a note
     * 3. we can delete a note
     * 4. we can see all notes
     * */
    public static void main(String[] args) {

        NoteDataSource noteDataSource = new NoteInMemoryDataSourceImpl();
        NoteRepository noteRepository = new NoteRepositoryImpl(noteDataSource);
        AddNote addNote = new AddNote(noteRepository);
        GetAllNotes getAllNotes = new GetAllNotes(noteRepository);
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag) {

            System.out.println("Please Enter Note Command\n 0 : Exit \n 1 : Insert new Note \n 2 : Print all Notes");


            int command = scanner.nextInt();
            switch (command) {
                case 0: {
                    System.out.println("Thanks for using Note app...\n");
                    flag = false;
                    break;
                }
                case 1: {
                    System.out.println("Enter Note Text...");
                    String text = scanner.next();
                    Either<Failure, Note> res = addNote.execute(new AddNote.Params(text));
                    if (res.isRight()) {
                        System.out.println("Note Added Successfully");
                    } else {
                        System.out.println("Something went wrong");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Printing all Notes \n ===========================");
                    Either<Failure, Map<UUID, Note>> res = getAllNotes.execute(new GetAllNotes.Params());
                    if (res.isRight()) {
                        Map<UUID, Note> noteMap = res.right().get();
                        for (UUID noteId : noteMap.keySet()) {
                            NoteModel note = (NoteModel) noteMap.get(noteId);
                            System.out.println(note.getText());
                            System.out.println("===========================");
                        }
                    } else {
                        System.out.println("Something went wrong");
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid Input");
                    break;
                }
            }
        }

    }
}
