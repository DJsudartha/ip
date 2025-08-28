import java.util.List;

public class ListInstruction implements Instruction {

    @Override
    public void execute(List<Task> storage, DataStorage dataStorage, Ui ui) throws KlalopzException {
        if (storage.isEmpty()) {
            ui.showMessage("HEY! You haven't added anything yet!");
        } else {
            ui.showMessage("No | Task type | Completed? | Title");
            ui.showMessage("-----------------------------------");
            // Formatting TO DO
            for (int i = 0; i < storage.size(); i++) {
                Task currTask = storage.get(i);
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
