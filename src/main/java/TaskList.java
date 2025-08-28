import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> storage;

    public TaskList(List<Task> tasks) {
        this.storage = tasks;
    }

    public void addTask(Task task) {
        storage.add(task);
    }

    public Task getTask(int index) {
        return storage.get(index);
    }

    public void removeTask(int index) {
        storage.remove(index);
    }

    public int size() {
        return storage.size();
    }

    public List<Task> getAll() {
        return storage;
    }

    public void reset() {
        storage = new ArrayList<>(100);
    }

    public Boolean isEmpty() {
        return this.getAll().isEmpty();
    }
}
