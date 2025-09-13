package klalopz.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a generic task with a description and completion status.
 * This class is extended by specific task types such as ToDo, Deadline, and Event.
 */
public class Task {
    private String details;
    private boolean isCompleted;

    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d MMM yyyy");

    /**
     * Constructs a Task with the given description and completion status.
     *
     * @param details The description of the task.
     * @param isCompleted True if the task is completed, false otherwise.
     */
    public Task(String details, boolean isCompleted) {
        this.details = details;
        this.isCompleted = isCompleted;
    }

    /**
     * Returns a visual representation of the completion status.
     *
     * @return "[X]" if completed, "[ ]" otherwise.
     */
    public String getCompletedLogo() {
        return isCompleted ? "[X]" : "[ ]";
    }

    /**
     * Returns the task type logo. Default is "[?]" for generic tasks.
     *
     * @return The task logo string.
     */
    public String getTaskLogo() {
        return "[?]";
    }
    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return this.details;
    }

    public void setCompleted(Boolean status) {
        this.isCompleted = status;
    }

    public boolean getCompleted() {
        return this.isCompleted;
    }

    /**
     * Serializes the task into a string for storage.
     *
     * @return Serialized string representing the task.
     */
    public String serialize() { return this.getTaskLogo() + " | " +
                                this.details + " | " + this.isCompleted; }

    /**
     * Deserializes a string from storage back into a Task or its subclass.
     *
     * @param data The serialized task string.
     * @return A Task object corresponding to the serialized data.
     * @throws IllegalArgumentException If the task type is unknown.
     */
    public static Task deserialize(String data) {
        String[] splitData = data.split( " \\| ");
        String type = splitData[0]; // for example, maybe first part indicates type
        String detail = splitData[1];
        boolean isCompleted = Boolean.parseBoolean(splitData[2]);


        return switch (type) {
            case "[?]" -> new Task(detail, isCompleted);
            case "[T]" -> new ToDo(detail, isCompleted);
            case "[D]" -> new Deadline(detail, isCompleted, LocalDate.parse(splitData[3], Task.DATE_FORMATTER));
            case "[E]" -> new Event(detail, isCompleted, LocalDate.parse(splitData[3], Task.DATE_FORMATTER),
                    LocalDate.parse(splitData[4], Task.DATE_FORMATTER));
            default -> throw new IllegalArgumentException("Unknown Klalopz.Tasks.Task detected");
        };
    }

    @Override
    public String toString() {
        return this.getTaskLogo() + this.getCompletedLogo() + " " + this.getDetails();
    }
}

