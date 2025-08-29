package klalopz.instructions;

import klalopz.storage.DataStorage;
import klalopz.exceptions.KlalopzException;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

import java.time.format.DateTimeFormatter;

public interface Instruction {

    String addedTask = "Got it. I've added this task: ";
    DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    void execute(TaskList storage, DataStorage dataStorage, TextUi textUi) throws KlalopzException;

    boolean doIExit();

}
