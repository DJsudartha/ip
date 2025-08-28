package Klalopz;

import Klalopz.Exceptions.KlalopzException;
import Klalopz.Instructions.Instruction;
import Klalopz.Instructions.Parser;
import Klalopz.Storage.DataStorage;
import Klalopz.Tasks.Task;
import Klalopz.Tasks.TaskList;
import Klalopz.Ui.TextUi;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Klalopz {
    private static final String botName = "Klalopz";
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
