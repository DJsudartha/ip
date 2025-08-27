public class Event extends Task {

    private String startDate;
    private String endDate;
    public Event(String description, Boolean isCompleted, String startDate, String endDate) {
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
                + " (from: " + this.getStartDate() + " to: " + this.getEndDate() + ")";
    }

    @Override
    public String serialize() {
        return this.getTaskLogo() + " | "  + this.getDetails() + " | " +
                this.getCompleted() + " | " + this.getStartDate() + " | " + this.getEndDate();
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
