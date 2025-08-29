package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

public class DeleteInstruction implements Instruction {
    public String arguments;
    private final int index;
    public DeleteInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Index is missing");
        }
        this.arguments = arguments;
        this.index = Integer.parseInt(arguments.trim()) - 1;
    }
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
