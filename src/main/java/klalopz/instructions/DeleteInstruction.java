package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

/**
 * Represents an instruction to delete a task from the task list
 * based on a specified index.
 */

public class DeleteInstruction implements Instruction {
    public String arguments;
    private final int index;

    /**
     * Constructs a DeleteInstruction with the given arguments.
     * The argument should be the 1-based index of the task to delete.
     *
     * @param arguments Input string containing the task index to delete.
     * @throws KlalopzException If the arguments are empty or not a valid number.
     */
    public DeleteInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Index is missing");
        }

        this.arguments = arguments;
        this.index = Integer.parseInt(arguments.trim()) - 1;
    }
    @Override
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        if (index < 0 || index >= storage.size()) {
            throw new KlalopzException("Index is out of bounds");
        }

        Task currTask = storage.getTask(index);
        storage.removeTask(index);
        dataStorage.save(storage);

        ui.showMessage("Removed item : " + currTask);
        ui.showMessage("Now you have " + storage.size() + " tasks in the list.");
        ui.showLine();
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
