package Klalopz.Ui;

import Klalopz.Exceptions.KlalopzException;

public class TextUi {
    public static final String botName = "Klalopz";
    public static final String lineGap = "____________________________________________________________";
    public static final String introMessage = "Hello! I'm " + botName + "!\nWhat can I do for you today?";
    public static final String closingMessage = "Bye-bye, hope to see you soon!";
    public static final String errorMessage = "The following error has occurred: ";
    public void sayOpening() {
        showLine();
        System.out.println(introMessage);
        showLine();
    }

    public void showLine() {
        System.out.println(lineGap);
    }

    public void sayClosing() {
        System.out.println(closingMessage);
        showLine();
    }

    public void showHardError(String input) throws KlalopzException {
        System.out.println(errorMessage);
        throw new KlalopzException(input);
    }

    public void showMessage(String input) {
        System.out.println(input);
    }



}
