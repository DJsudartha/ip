package klalopz;

import klalopz.exceptions.KlalopzException;
import klalopz.instructions.Instruction;
import klalopz.instructions.Parser;
import klalopz.storage.DataStorage;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

import java.util.Scanner;

public class Klalopz {
    private static final String botName = "klalopz";
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
}
