package klalopz.instructions;

import klalopz.exceptions.KlalopzException;
import klalopz.storage.DataStorage;
import klalopz.tasks.Deadline;
import klalopz.tasks.Task;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

import java.time.LocalDate;

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
            this.dueDate = LocalDate.parse(tempStorage[1].trim(), Instruction.inputDateFormat);
        }
        public void execute(TaskList storage, DataStorage dataStorage, TextUi textUi) throws KlalopzException {
            Task currTask = new Deadline(details, Boolean.FALSE, dueDate);
            storage.addTask(currTask);
            dataStorage.save(storage);
            textUi.showMessage(Instruction.addedTask + " \n" + currTask);
            textUi.showMessage("Now you have " + storage.size() + " tasks in the list.");
            textUi.showLine();
        }
        @Override
        public boolean doIExit() {
            return false;
        }
    }
