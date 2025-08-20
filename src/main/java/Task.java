public class Task {
    private String details;
    private boolean isCompleted;

    public Task(String details) {
        this.details = details;
        this.isCompleted = false;
    }

    public String getCompletedLogo() {
        return isCompleted ? "X" : " ";
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
}
