import java.util.Scanner;

public class Klalopz {
    public static void main(String[] args) {
        String botName = "Klalopz";
        String lineGap = "____________________________________________________________";
        String introMessage = "Hello! I'm " + botName + "!\nWhat can I do for you today?";
        String closingMessage = "Bye-bye, hope to see you soon!";
        Scanner scanner = new Scanner(System.in);
        String currInput;

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
            System.out.println(currInput);
            System.out.println(lineGap);


        }
        System.out.println(closingMessage);
        System.out.println(lineGap);



    }
}
