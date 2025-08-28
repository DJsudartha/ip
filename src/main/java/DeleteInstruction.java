import java.util.List;

public class DeleteInstruction implements Instruction {
    public String arguments;
    private final int index;
    public DeleteInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Index is missing");
        }
        this.arguments = arguments;
        this.index = Integer.parseInt(arguments.trim()) - 1;
    }
    public void execute(TaskList storage, DataStorage dataStorage, Ui ui) throws KlalopzException {
        if (index < 0 || index >= storage.size()) {
            throw new KlalopzException("Index is out of bounds");
        }

        Task currTask = storage.getTask(index);
        storage.removeTask(index);
        dataStorage.save(storage);

        ui.showMessage("Removed item : " + currTask);
        ui.showMessage("Now you have " + storage.size() + " tasks in the list.");
        ui.showLine();
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
