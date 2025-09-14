package klalopz.instructions;

import klalopz.enums.InstructionKeyword;
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
        assert input != null : "Input string should not be null";

        String[] splitInput = input.split(" ", 2);
        String instruction = splitInput[0];
        assert !instruction.isBlank() : "Command keyword must not be blank";

        String arguments = splitInput.length > 1 ?  splitInput[1] : "";

        InstructionKeyword keyword;
        try {
            keyword = InstructionKeyword.fromString(instruction);
        } catch (IllegalArgumentException e) {
            throw new KlalopzException("Invalid instruction");
        }

        return switch (keyword) {
            case LIST -> new ListInstruction(); // 0 Arguments
            case MARK -> new MarkInstruction(arguments); // 1 Argument
            case UNMARK -> new UnmarkInstruction(arguments); // 1 Argument
            case FIND -> new FindInstruction(arguments); // 1 Argument
            case DEADLINE -> new DeadlineInstruction(arguments); // 2 Argument
            case EVENT -> new EventInstruction(arguments); // 3 Argument
            case TODO -> new ToDoInstruction(arguments); // 1 Argument
            case DELETE -> new DeleteInstruction(arguments); // 1 Argument
            case ADD_TAG -> new SetTagInstruction(arguments); // 2 Arguments
            case DELETE_TAG -> new DeleteTagInstruction(arguments); // 2 Arguments
            case EXIT -> new ExitInstruction();
        };
    }
}
