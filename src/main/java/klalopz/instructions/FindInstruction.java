package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

public class FindInstruction implements Instruction {
    public String arguments;

    public FindInstruction(String input) throws KlalopzException{
        if (input.isEmpty()) {
            throw new KlalopzException("Tell me what you want to find!");
        }
        this.arguments = input.trim();
    }
    @Override
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        boolean areAnyWordsFound = false;

        ui.showMessage("Tasks containing " +  arguments + ":");
        for (int i = 0; i < storage.size(); i++) {
            Task task = storage.getTask(i);
            if (task.getDetails().toLowerCase().contains(arguments.toLowerCase())) {
                ui.showMessage((i + 1) + ". " + task);
                areAnyWordsFound = true;
            }
        }

        if (!areAnyWordsFound) {
            ui.showMessage("No tasks are found");
        }

        ui.showLine();
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
