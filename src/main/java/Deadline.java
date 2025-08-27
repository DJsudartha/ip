import java.time.LocalDate;

public class Deadline extends Task {
    private LocalDate dueDate;
    public Deadline(String description, Boolean isCompleted, LocalDate dueDate) {
        super(description, isCompleted);
        this.dueDate = dueDate;
    }

    @Override
    public String getTaskLogo() {
        return "[D]";
    }

    @Override
    public String toString() {
        return this.getTaskLogo() + this.getCompletedLogo() + " " + this.getDetails()
                + " (by: " + getDueDate().format(Task.dateFormatter) + ")";
    }

    @Override
    public String serialize() {
        return this.getTaskLogo() + " | "  + this.getDetails() + " | " +
                this.getCompleted() + " | " + this.getDueDate().format(Task.dateFormatter);
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}
