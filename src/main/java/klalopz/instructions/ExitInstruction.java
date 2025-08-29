package klalopz.instructions;

import klalopz.storage.DataStorage;
import klalopz.exceptions.KlalopzException;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

public class ExitInstruction implements Instruction {
    @Override
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        ui.sayClosing();
    }

    @Override
    public boolean doIExit() {
        return true;
    }
}
