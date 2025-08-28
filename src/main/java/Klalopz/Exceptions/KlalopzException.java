package Klalopz.Exceptions;

public class KlalopzException extends Exception {
    public KlalopzException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "    ____________________________________________________________\n"
                + "     " + this.getMessage() + "\n"
                + "    ____________________________________________________________";
    }
}
