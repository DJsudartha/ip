import java.io.FileWriter;

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

    public static void getTaskCount(List<Task> storage) {
        int count = storage.size();
        System.out.println("Now you have " + count + " tasks in the list.");
    }

    public static void saveTasks(List<Task> storage) {

    }
    public static void main(String[] args) throws KlalopzException {
        Scanner scanner = new Scanner(System.in);
        String currInput, instruction, otherData, details, startDate, endDate;
        DataStorage dataStorage = new DataStorage();
        String[] tempStorage;
        int index;
        Task currTask;
        List<Task> taskStorage = dataStorage.load();

        System.out.println(lineGap);
        System.out.println(introMessage);
        System.out.println(lineGap);

        while(true) {
            System.out.println("Your input: ");
            currInput = scanner.nextLine().trim();
            System.out.println(lineGap);

            if (currInput.equalsIgnoreCase("bye")) {
                break;
            }

            String[] splitInput = currInput.split(" ", 2);
            if (splitInput.length > 1) {
                instruction = splitInput[0];
                otherData = splitInput[1];
            } else {
                instruction = currInput;
                otherData = "";
            }
            // TO DO make cases into enums
            switch(instruction.toLowerCase()) {
                case "list":
                    if (taskStorage.isEmpty()) {
                        System.out.println("HEY! You haven't added anything yet!");
                    } else {
                        System.out.println("No | Task type | Completed? | Title");
                        System.out.println("-----------------------------------");
                        // Formatting TO DO
                        for (int i = 0; i < taskStorage.size(); i++) {
                            currTask = taskStorage.get(i);
                            String currItemString = (i + 1) + ". " + currTask.toString();
                            System.out.println(currItemString);
                        }
                        System.out.println(lineGap);

                    }
                    break;
                case "mark":
                    if (otherData.isEmpty()) {
                        throw new KlalopzException("Tell me which task to mark");
                    }

                    index = Integer.parseInt(otherData) - 1;

                    if (index < 0 || index >= taskStorage.size()) {
                        throw new KlalopzException("What even is that task??");
                    }

                    currTask = taskStorage.get(index);
                    currTask.setCompleted(Boolean.TRUE);
                    dataStorage.save(taskStorage);

                    System.out.println("Well done! I have marked this task:\n" + "[X] " + currTask.getDetails());
                    System.out.println(lineGap);
                    break;

                case "unmark":
                    if (otherData.isEmpty()) {
                        throw new KlalopzException("Tell me which task to unmark");
                    }

                    index = Integer.parseInt(otherData) - 1;

                    if (index < 0 || index >= taskStorage.size()) {
                        throw new KlalopzException("What even is that task??");
                    }

                    currTask = taskStorage.get(index);
                    currTask.setCompleted(Boolean.FALSE);
                    dataStorage.save(taskStorage);

                    System.out.println("Understood! I have unmarked this task:\n" + "[ ] " + currTask.getDetails());
                    System.out.println(lineGap);
                    break;

                case "deadline":
                    if (otherData.isEmpty()) {
                        throw new KlalopzException("I need more info about this task. Follow the format pls");
                    }

                    tempStorage = otherData.split("/", 2);

                    if (tempStorage.length < 2) {
                        throw new KlalopzException("FOLLOW THE FORMAT!!!!");
                    }

                    details = tempStorage[0];
                    startDate = tempStorage[1];
                    currTask = new Deadline(details, Boolean.FALSE, startDate);
                    taskStorage.add(currTask);
                    dataStorage.save(taskStorage);
                    System.out.println(addedTask + " \n" + currTask);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
                    break;

                case "event":
                    if (otherData.isEmpty()) {
                        throw new KlalopzException("Oi what is this event, so sad");
                    }
                    tempStorage = otherData.split("/", 3);
                    if (tempStorage.length < 3) {
                        throw new KlalopzException("FOLLOW THE FORMAT PLSSSSS");
                    }
                    details = tempStorage[0];
                    startDate = tempStorage[1];
                    endDate = tempStorage[2];
                    currTask = new Event(details, Boolean.FALSE, startDate, endDate);
                    taskStorage.add(currTask);
                    dataStorage.save(taskStorage);
                    System.out.println(addedTask + " \n" + currTask);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
                    break;

                case "todo":
                    if (otherData.isEmpty()) {
                        throw new KlalopzException("Heh, idk what you need to do");
                    }

                    currTask = new ToDo(otherData, Boolean.FALSE);
                    taskStorage.add(currTask);
                    dataStorage.save(taskStorage);
                    System.out.println(addedTask + " \n" + currTask);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
                    break;

                case "delete", "remove":
                    index = Integer.parseInt(otherData) - 1;
                    currTask = taskStorage.get(index);
                    taskStorage.remove(index);
                    dataStorage.save(taskStorage);
                    System.out.println("Removed item : " + currTask);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
                    break;

                default:
                    throw new KlalopzException("Typo ma?");
            }
        }
        System.out.println(closingMessage);
        System.out.println(lineGap);

    }
}
