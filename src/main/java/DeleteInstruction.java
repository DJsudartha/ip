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
    public void execute(List<Task> storage, DataStorage dataStorage) throws KlalopzException {
        if (index < 0 || index >= storage.size()) {
            throw new KlalopzException("Index is out of bounds");
        }

        Task currTask = storage.get(index);
        storage.remove(index);
        dataStorage.save(storage);
        System.out.println("Removed item : " + currTask);
        System.out.println("Now you have " + storage.size() + " tasks in the list.");
        System.out.println(lineGap);
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
