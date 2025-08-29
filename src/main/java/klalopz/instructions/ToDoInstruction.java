package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.tasks.ToDo;
import klalopz.ui.TextUi;

public class ToDoInstruction implements Instruction {

    public String arguments;
    public ToDoInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Missing arguments");
        }
        this.arguments = arguments.trim();
    }
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        Task currTask = new ToDo(arguments, Boolean.FALSE);
        storage.addTask(currTask);
        dataStorage.save(storage);

        ui.showMessage(addedTask + " \n" + currTask);
        ui.showMessage("Now you have " + storage.size() + " tasks in the list.");
        ui.showLine();
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
