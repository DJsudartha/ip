import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DeadlineInstruction implements Instruction {

    public String arguments;
    private final LocalDate dueDate;
    private final String details;
    public DeadlineInstruction(String arguments) throws KlalopzException {
        this.arguments = arguments;
        String[] tempStorage = arguments.split("/", 2);

        if (tempStorage.length < 2) {
            throw new KlalopzException("FOLLOW THE FORMAT!!!! (title / date))");
        }

        this.details = tempStorage[0].trim();
        this.dueDate = LocalDate.parse(tempStorage[1].trim(), inputDateFormat);
    }
    public void execute(List<Task> storage, DataStorage dataStorage) throws KlalopzException {
        Task currTask = new Deadline(details, Boolean.FALSE, dueDate);
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
