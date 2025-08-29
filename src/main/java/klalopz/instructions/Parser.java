package klalopz.instructions;

import klalopz.exceptions.KlalopzException;

public class Parser {

    public static Instruction parse(String input) throws KlalopzException {
        String[] splitInput = input.split(" ", 2);
        String instruction = splitInput[0];
        String arguments = splitInput.length > 1 ?  splitInput[1] : "";

        return switch (instruction.toLowerCase().trim()) {
            case "list" -> new ListInstruction();
            case "mark" -> new MarkInstruction(arguments);
            case "unmark" -> new UnmarkInstruction(arguments);
            case "deadline" -> new DeadlineInstruction(arguments);
            case "event" -> new EventInstruction(arguments);
            case "todo" -> new ToDoInstruction(arguments);
            case "delete", "remove" -> new DeleteInstruction(arguments);
            case "bye" -> new ExitInstruction();
            default -> throw new KlalopzException("Invalid instruction");
        };
    }
}
