package Klalopz.Instructions;

import Klalopz.Storage.DataStorage;
import Klalopz.Exceptions.KlalopzException;
import Klalopz.Tasks.TaskList;
import Klalopz.Ui.TextUi;

import java.time.format.DateTimeFormatter;

public interface Instruction {
    public static final String FILE_NAME = "data/tasks.txt";
    public static final String addedTask = "Got it. I've added this task: ";
    public static final DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public void execute(TaskList storage, DataStorage dataStorage, TextUi textUi) throws KlalopzException;

    public boolean doIExit();

}
