import java.io.FileWriter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klalopz {
    private static final String FILE_NAME = "data/tasks.txt";
    private static final String botName = "Klalopz";
    private static final String lineGap = "____________________________________________________________";
    private static final String introMessage = "Hello! I'm " + botName + "!\nWhat can I do for you today?";
    private static final String addedTask = "Got it. I've added this task: ";
    private static final String closingMessage = "Bye-bye, hope to see you soon!";
    private static final DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void getTaskCount(List<Task> storage) {
        int count = storage.size();
        System.out.println("Now you have " + storage.size() + " tasks in the list.");
    }

    public static void saveTasks(List<Task> storage) {

    }
    public static void main(String[] args) throws KlalopzException {
        Scanner scanner = new Scanner(System.in);
        DataStorage dataStorage = new DataStorage();
        Ui ui = new Ui();
        List<Task> taskStorage = dataStorage.load();

        ui.sayOpening();

        while(true) {
            System.out.println("Your input: ");
            String currInput = scanner.nextLine().trim();
            ui.showLine();
            try {
                Instruction instruction = Parser.parse(currInput);
                instruction.execute(taskStorage, dataStorage, ui);
                if (instruction.doIExit()) {
                    break;
                }
            } catch (KlalopzException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
