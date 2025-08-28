import java.time.LocalDate;
import java.util.List;

public class EventInstruction implements Instruction {
    public String arguments;
    private final String details;
    private final LocalDate startDate;
    private final LocalDate endDate;
    public EventInstruction(String arguments) throws KlalopzException {
        this.arguments = arguments;
        String[] parts = arguments.split("/", 3);
        if (parts.length < 3) {
            throw new KlalopzException("FOLLOW THE FORMAT!!!! (title / startDate / endDate)");
        }
        this.details = parts[0].trim();
        this.startDate = LocalDate.parse(parts[1].trim(), inputDateFormat);
        this.endDate = LocalDate.parse(parts[2].trim(), inputDateFormat);
    }
    public void execute(List<Task> storage, DataStorage dataStorage, Ui ui) throws KlalopzException {
        Task currTask = new Event(details, Boolean.FALSE, startDate, endDate);
        storage.add(currTask);
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
