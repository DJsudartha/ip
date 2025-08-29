package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

public class ListInstruction implements Instruction {

    @Override
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        if (storage.isEmpty()) {
            ui.showMessage("HEY! You haven't added anything yet!");
        } else {
            ui.showMessage("No | Task type | Completed? | Title");
            ui.showMessage("-----------------------------------");
            // Formatting TO DO
            for (int i = 0; i < storage.size(); i++) {
                Task currTask = storage.getTask(i);
                ui.showMessage((i + 1) + ". " + currTask);
                ui.showLine();
            }
        }
    }

    @Override
    public boolean doIExit() {
        return false;
    }
}
