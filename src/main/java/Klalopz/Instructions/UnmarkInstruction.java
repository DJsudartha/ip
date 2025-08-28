package Klalopz.Instructions;

import Klalopz.Exceptions.KlalopzException;
import Klalopz.Storage.DataStorage;
import Klalopz.Tasks.Task;
import Klalopz.Tasks.TaskList;
import Klalopz.Ui.TextUi;

public class UnmarkInstruction implements Instruction {

    public String arguments;
    private final int index;
    public UnmarkInstruction(String arguments) throws KlalopzException {

        if (arguments.isEmpty()) {
            throw new KlalopzException("Missing Index");
        }
        this.arguments = arguments;

        this.index = Integer.parseInt(arguments.trim()) - 1;
    }
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        if (index < 0 || index >= storage.size()) {
            throw new KlalopzException("What even is that task??");
        }

        Task currTask = storage.getTask(index);
        currTask.setCompleted(Boolean.FALSE);
        dataStorage.save(storage);

        ui.showMessage("Understood! I have unmarked this task:\n" + "[ ] " + currTask.getDetails());
        ui.showLine();
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
