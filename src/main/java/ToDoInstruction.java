import java.util.List;

public class ToDoInstruction implements Instruction {

    public String arguments;
    public ToDoInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Missing arguments");
        }
        this.arguments = arguments.trim();
    }
    public void execute(TaskList storage, DataStorage dataStorage, Ui ui) throws KlalopzException {
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
