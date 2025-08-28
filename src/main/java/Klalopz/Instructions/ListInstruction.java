package Klalopz.Instructions;

import Klalopz.Exceptions.KlalopzException;
import Klalopz.Storage.DataStorage;
import Klalopz.Tasks.Task;
import Klalopz.Tasks.TaskList;
import Klalopz.Ui.TextUi;

public class ListInstruction implements Instruction {

    @Override
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        if (storage.isEmpty()) {
            ui.showMessage("HEY! You haven't added anything yet!");
        } else {
            ui.showMessage("No | Klalopz.Tasks.Task type | Completed? | Title");
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
