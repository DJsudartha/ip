package klalopz.instructions;

import klalopz.exceptions.KlalopzException;

/**
 * Responsible for parsing user input and returning the corresponding instruction.
 * The parser separates the command keyword from its arguments and creates
 * the appropriate Instruction object.
 */
public class Parser {

    /**
     * Parses the input string and returns the corresponding Instruction.
     * The first word of the input is treated as the command, and the remainder
     * (if any) as arguments for that command.
     *
     * @param input User input string containing the command and optional arguments.
     * @return The Instruction object corresponding to the parsed command.
     * @throws KlalopzException If the input does not match any valid instruction
     *                          or if required arguments are missing.
     */
    public static Instruction parse(String input) throws KlalopzException {
        String[] splitInput = input.split(" ", 2);
        String instruction = splitInput[0];
        String arguments = splitInput.length > 1 ?  splitInput[1] : "";

        return switch (instruction.toLowerCase().trim()) {
            case "list" -> new ListInstruction();
            case "mark" -> new MarkInstruction(arguments);
            case "unmark" -> new UnmarkInstruction(arguments);
            case "find" -> new FindInstruction(arguments);
            case "deadline" -> new DeadlineInstruction(arguments);
            case "event" -> new EventInstruction(arguments);
            case "todo" -> new ToDoInstruction(arguments);
            case "delete", "remove" -> new DeleteInstruction(arguments);
            case "bye" -> new ExitInstruction();
            default -> throw new KlalopzException("Invalid instruction");
        };
    }
}
