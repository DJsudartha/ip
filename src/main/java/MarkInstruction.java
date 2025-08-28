import java.util.List;

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
    public void execute(List<Task> storage, DataStorage dataStorage, Ui ui) {

        Task currTask = storage.get(index);
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
