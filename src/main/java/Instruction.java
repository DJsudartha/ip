import java.time.format.DateTimeFormatter;
import java.util.List;

public interface Instruction {
    public static final String FILE_NAME = "data/tasks.txt";
    public static final String botName = "Klalopz";
    public static final String lineGap = "____________________________________________________________";
    public static final String introMessage = "Hello! I'm " + botName + "!\nWhat can I do for you today?";
    public static final String addedTask = "Got it. I've added this task: ";
    public static final String closingMessage = "Bye-bye, hope to see you soon!";
    public static final DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public void execute(List<Task> storage, DataStorage dataStorage) throws KlalopzException;

    public boolean doIExit();

}
