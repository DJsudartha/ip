package klalopz.exceptions;

/**
 * Represents exceptions specific to the Klalopz application.
 * This exception can be thrown when the program encounters errors
 * related to user input, task operations, or other domain-specific issues.
 * in a formatted style.
 */
public class KlalopzException extends Exception {

    /**
     * Creates a new {@code KlalopzException} with the specified detail message.
     *
     * @param message The detail message to describe the exception.
     */
    public KlalopzException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
