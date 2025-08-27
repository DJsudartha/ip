public class ToDo extends Task {

    public ToDo(String description, Boolean isCompleted) {
        super(description, isCompleted);
    }

    @Override
    public String getTaskLogo() {
        return "[T]";
    }

}
