import java.time.format.DateTimeFormatter;
import java.util.List;

public interface Instruction {
    public static final String FILE_NAME = "data/tasks.txt";
    public static final String addedTask = "Got it. I've added this task: ";
    public static final DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public void execute(List<Task> storage, DataStorage dataStorage, Ui ui) throws KlalopzException;

    public boolean doIExit();

}
