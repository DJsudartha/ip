package klalopz;

import javafx.application.Platform;
import klalopz.exceptions.KlalopzException;
import klalopz.instructions.Instruction;
import klalopz.instructions.Parser;

import klalopz.storage.DataStorage;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

import java.util.Scanner;

public class Klalopz {
    private static final String botName = "klalopz";
    private final DataStorage dataStorage;
    private final TextUi textUi;
    private final TaskList taskList;
    public Klalopz() throws KlalopzException {
        this.dataStorage = new DataStorage(null);
        this.textUi = new TextUi();
        this.taskList = new TaskList(dataStorage.load());
    }
    public static void main(String[] args) throws KlalopzException {
        Scanner scanner = new Scanner(System.in);
        DataStorage dataStorage = new DataStorage(null);
        TextUi textUi = new TextUi();
        TaskList taskList = new TaskList(dataStorage.load());

        textUi.sayOpening();

        while(true) {
            System.out.println("Your input: ");
            String currInput = scanner.nextLine().trim();
            textUi.showLine();
            try {
                Instruction instruction = Parser.parse(currInput);
                instruction.execute(taskList, dataStorage, textUi);
                if (instruction.doIExit()) {
                    break;
                }
            } catch (KlalopzException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        assert input != null : "Input should not be empty";
        try {
            Instruction currInstruction = Parser.parse(input);
            currInstruction.execute(taskList, dataStorage, textUi);

            assert !textUi.getMessages().isEmpty() : "TextUi should have a message after executing";

            String response = String.join("\n", textUi.getMessages());
            if (currInstruction.doIExit()) {
                Platform.exit();
                System.exit(0);
            }
            return response;


        } catch (KlalopzException e) {
            throw new RuntimeException(e);
        } finally {
            textUi.clearMessages();
        }
    }

}
