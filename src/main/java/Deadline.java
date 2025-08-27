public class Deadline extends Task {
    private String dueDate;
    public Deadline(String description, Boolean isCompleted, String dueDate) {
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
                + " (by: " + getDueDate() + ")";
    }

    @Override
    public String serialize() {
        return this.getTaskLogo() + " | "  + this.getDetails() + " | " +
                this.getCompleted() + " | " + this.getDueDate();
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

}
