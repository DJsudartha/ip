import java.util.List;

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
    public void execute(List<Task> storage, DataStorage dataStorage) throws KlalopzException {
        if (index < 0 || index >= storage.size()) {
            throw new KlalopzException("What even is that task??");
        }

        Task currTask = storage.get(index);
        currTask.setCompleted(Boolean.FALSE);
        dataStorage.save(storage);

        System.out.println("Understood! I have unmarked this task:\n" + "[ ] " + currTask.getDetails());
        System.out.println(lineGap);
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
