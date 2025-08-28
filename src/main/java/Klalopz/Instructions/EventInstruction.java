package Klalopz.Instructions;

import Klalopz.Exceptions.KlalopzException;
import Klalopz.Storage.DataStorage;
import Klalopz.Tasks.Event;
import Klalopz.Tasks.Task;
import Klalopz.Tasks.TaskList;
import Klalopz.Ui.TextUi;

import java.time.LocalDate;

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
    public void execute(TaskList storage, DataStorage dataStorage, TextUi ui) throws KlalopzException {
        Task currTask = new Event(details, Boolean.FALSE, startDate, endDate);
        storage.addTask(currTask);
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
