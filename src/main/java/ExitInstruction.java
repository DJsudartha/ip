import java.util.List;

public class ExitInstruction implements Instruction {
    @Override
    public void execute(List<Task> storage, DataStorage dataStorage) throws KlalopzException {
        System.out.println(closingMessage);
        System.out.println(lineGap);
    }

    @Override
    public boolean doIExit() {
        return true;
    }
}
