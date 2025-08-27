import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {

    private final Path directoryPath;
    private final Path filePath;
    public DataStorage() {
        String home = System.getProperty("user.home");
        this.directoryPath = Paths.get(home, "Klalopz", "data");
        this.filePath = directoryPath.resolve("tasks.txt");

        try {
            Files.createDirectories(directoryPath); // make sure folders exist
        } catch (IOException e) {
            System.out.println("Error creating data directory: " + e.getMessage());
        }
    }

    // TO DO Handle data corruption
    public List<Task> load() {
        List<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.deserialize(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading: " + e.getMessage());
        }

        return tasks;
    }

    // Taken from https://www.javaguides.net/2025/02/top-10-best-practices-for-file-handling-in-java.html
    public void save(List<Task> tasks) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (Task task : tasks) {
                writer.write(task.serialize());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }
}
