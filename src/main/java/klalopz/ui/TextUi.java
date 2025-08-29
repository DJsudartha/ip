package klalopz.ui;

import klalopz.exceptions.KlalopzException;

/**
 * Handles user interaction by displaying messages, lines, and errors in the console.
 * Provides methods for showing opening and closing messages, generic messages,
 * and throwing formatted exceptions.
 */

public class TextUi {
    public static final String botName = "klalopz";
    public static final String lineGap = "____________________________________________________________";
    public static final String introMessage = "Hello! I'm " + botName + "!\nWhat can I do for you today?";
    public static final String closingMessage = "Bye-bye, hope to see you soon!";
    public static final String errorMessage = "The following error has occurred: ";

    /**
     * Displays the opening message when the application starts,
     * surrounded by divider lines.
     */
    public void sayOpening() {
        showLine();
        System.out.println(introMessage);
        showLine();
    }

    /**
     * Prints a horizontal line to the console for visual separation.
     */
    public void showLine() {
        System.out.println(lineGap);
    }

    /**
     * Displays the closing message when the application exits,
     * followed by a divider line.
     */
    public void sayClosing() {
        System.out.println(closingMessage);
        showLine();
    }

    /**
     * Displays an error message and throws a KlalopzException with the given input.
     *
     * @param input The error details to include in the exception.
     * @throws KlalopzException Always thrown with the provided input.
     */
    public void showHardError(String input) throws KlalopzException {
        System.out.println(errorMessage);
        throw new KlalopzException(input);
    }

    /**
     * Displays a message to the user.
     *
     * @param input The message string to display.
     */
    public void showMessage(String input) {
        System.out.println(input);
    }



}
