public class Task {
    private String details;
    private boolean isCompleted;

    public Task(String details, boolean isCompleted) {
        this.details = details;
        this.isCompleted = isCompleted;
    }

    public String getCompletedLogo() {
        return isCompleted ? "[X]" : "[ ]";
    }

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

    public String serialize() { return this.getTaskLogo() + " | " +
                                this.details + " | " + this.isCompleted; }

    public static Task deserialize(String data) {
        String[] splitData = data.split( " \\| ");
        String type = splitData[0]; // for example, maybe first part indicates type
        String detail = splitData[1];
        boolean isCompleted = Boolean.parseBoolean(splitData[2]);


        switch(type) {
            case "[?]": return new Task(detail, isCompleted);
            case "[T]": return new ToDo(detail, isCompleted);
            case "[D]": return new Deadline(detail, isCompleted, splitData[3]);
            case "[E]": return new Event(detail, isCompleted, splitData[3], splitData[4]);
            default: throw new IllegalArgumentException("Unknown Task detected");
        }
    }

    @Override
    public String toString() {
        return this.getTaskLogo() + this.getCompletedLogo() + " " + this.getDetails();
    }
}

