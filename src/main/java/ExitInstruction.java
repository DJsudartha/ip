import java.util.List;

public class ExitInstruction implements Instruction {
    @Override
    public void execute(List<Task> storage, DataStorage dataStorage, Ui ui) throws KlalopzException {
        ui.sayClosing();
    }

    @Override
    public boolean doIExit() {
        return true;
    }
}
