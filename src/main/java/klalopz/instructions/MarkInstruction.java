package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

public class MarkInstruction implements Instruction {
    public String arguments;
    private final int index;

    public MarkInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Tell me which task to mark");
        }
        this.arguments = arguments;
        this.index = Integer.parseInt(arguments.trim()) - 1;
    }
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) {

        Task currTask = storage.getTask(index);
        currTask.setCompleted(Boolean.TRUE);
        dataStorage.save(storage);

        ui.showMessage("Well done! I have marked this task:\n" + "[X] " + currTask.getDetails());
        ui.showLine();
    }

    @Override
    public boolean doIExit() {
        return false;
    }

}
