package Klalopz.Instructions;

import Klalopz.Storage.DataStorage;
import Klalopz.Exceptions.KlalopzException;
import Klalopz.Tasks.TaskList;
import Klalopz.Ui.TextUi;

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
