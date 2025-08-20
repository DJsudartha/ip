import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klalopz {
    public static void main(String[] args) {
        String botName = "Klalopz";
        String lineGap = "____________________________________________________________";
        String introMessage = "Hello! I'm " + botName + "!\nWhat can I do for you today?";
        String addedTask = "Got it. I've added this task: ";
        String closingMessage = "Bye-bye, hope to see you soon!";
        Scanner scanner = new Scanner(System.in);
        String currInput, instruction, otherData, details, startDate, endDate;
        String[] tempStorage;
        int index;
        Task currTask;
        List<Task> taskStorage = new ArrayList<>(100);

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

            switch(instruction.toLowerCase()) {
                case "list":
                    if (taskStorage.isEmpty()) {
                        System.out.println("Nothing here yet :)");
                        break;
                    }
                    System.out.println("No | Task type | Completed? | Title");
                    System.out.println("-----------------------------------");
                    // Formatting TO DO
                    for (int i = 0; i < taskStorage.size(); i++) {
                        currTask = taskStorage.get(i);
                        String currItemString = (i + 1) + ". " + currTask.toString();
                        System.out.println(currItemString);
                    }
                    System.out.println(lineGap);
                    break;

                case "mark":
                    index = Integer.parseInt(otherData) - 1;
                    currTask = taskStorage.get(index);
                    currTask.setCompleted(Boolean.TRUE);

                    System.out.println("Well done! I have marked this task:\n" + "[X] " + currTask.getDetails());
                    System.out.println(lineGap);
                    break;

                case "unmark":
                    index = Integer.parseInt(otherData) - 1;
                    currTask = taskStorage.get(index);
                    currTask.setCompleted(Boolean.FALSE);

                    System.out.println("Understood! I have unmarked this task:\n" + "[ ] " + currTask.getDetails());
                    System.out.println(lineGap);
                    break;
                case "deadline":
                    tempStorage = otherData.split("/");
                    details = tempStorage[0];
                    startDate = tempStorage[1];
                    currTask = new Deadline(details, startDate);
                    taskStorage.add(currTask);
                    System.out.println(addedTask + " \n" + currTask);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
                    break;
                case "event":
                    tempStorage = otherData.split("/");
                    details = tempStorage[0];
                    startDate = tempStorage[1];
                    endDate = tempStorage[2];
                    currTask = new Event(details, startDate, endDate);
                    taskStorage.add(currTask);
                    System.out.println(addedTask + " \n" + currTask);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
                    break;
                case "todo":
                    currTask = new ToDo(otherData);
                    taskStorage.add(currTask);
                    System.out.println(addedTask + " \n" + currTask);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
                    break;
                default: // later change into error handling
                    taskStorage.add(new Task(currInput));
                    System.out.println("Added item : " + currInput);
                    getTaskCount(taskStorage);
                    System.out.println(lineGap);
            }


        }
        System.out.println(closingMessage);
        System.out.println(lineGap);

    }

    public static void getTaskCount(List<Task> storage) {
        int count = storage.size();
        System.out.println("Now you have " + count + " tasks in the list.");
    }
}
