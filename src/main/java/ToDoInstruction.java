import java.util.List;

public class ToDoInstruction implements Instruction {

    public String arguments;
    public ToDoInstruction(String arguments) throws KlalopzException {
        if (arguments.isEmpty()) {
            throw new KlalopzException("Missing arguments");
        }
        this.arguments = arguments.trim();
    }
    public void execute(List<Task> storage, DataStorage dataStorage) throws KlalopzException {
        Task currTask = new ToDo(arguments, Boolean.FALSE);
        storage.add(currTask);
        dataStorage.save(storage);
        System.out.println(addedTask + " \n" + currTask);
        System.out.println("Now you have " + storage.size() + " tasks in the list.");
        System.out.println(lineGap);
    }
    @Override
    public boolean doIExit() {
        return false;
    }
}
