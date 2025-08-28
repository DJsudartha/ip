package Klalopz.Tasks;

import java.time.LocalDate;

public class Event extends Task {

    private LocalDate startDate;
    private LocalDate endDate;
    public Event(String description, Boolean isCompleted, LocalDate startDate, LocalDate endDate) {
        super(description, isCompleted);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String getTaskLogo() {
        return "[E]";
    }

    @Override
    public String toString() {
        return this.getTaskLogo() + this.getCompletedLogo() + " " + this.getDetails()
                + " (from: " + this.getStartDate().format(Task.dateFormatter)
                + " to: " + this.getEndDate().format(Task.dateFormatter) + ")";
    }

    @Override
    public String serialize() {
        return this.getTaskLogo() + " | "  + this.getDetails() + " | " +
                this.getCompleted() + " | " + this.getStartDate().format(Task.dateFormatter)
                + " | " + this.getEndDate().format(Task.dateFormatter);
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
