package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

public class SetTagInstruction implements Instruction {
    private int index;
    private String tag;

    public SetTagInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Missing arguments");
        }
        String[] splitArguments = arguments.split(" ", 2);
        this.index = Integer.parseInt(splitArguments[0]) - 1;
        this.tag = splitArguments[1];

    }

    @Override
    public void execute(TaskList storage, DataStorage dataStorage, TextUi textUi) throws KlalopzException {
        Task currTask = storage.getTask(index);
        currTask.setTag(tag);
        dataStorage.save(storage);

        textUi.showMessage("I have added this tag to the following task:\n" + currTask);
        textUi.showLine();
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
