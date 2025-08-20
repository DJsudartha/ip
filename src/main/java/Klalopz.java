import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klalopz {
    public static void main(String[] args) {
        String botName = "Klalopz";
        String lineGap = "____________________________________________________________";
        String introMessage = "Hello! I'm " + botName + "!\nWhat can I do for you today?";
        String closingMessage = "Bye-bye, hope to see you soon!";
        Scanner scanner = new Scanner(System.in);
        String currInput;
        List<String> taskStorage = new ArrayList<>(100);

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
            switch(currInput.toLowerCase()) {
                case "list":
                    if (taskStorage.isEmpty()) {
                        System.out.println("Nothing here yet :)");
                        break;
                    }
                    for (int i = 0; i < taskStorage.size(); i++) {
                        String currItemString = (i + 1) + ". " + taskStorage.get(i);
                        System.out.println(currItemString);
                    }
                    System.out.println(lineGap);
                    break;
                default:
                    taskStorage.add(currInput);
                    System.out.println("Added item : " + currInput);
                    System.out.println(lineGap);
            }


        }
        System.out.println(closingMessage);
        System.out.println(lineGap);



    }
}
