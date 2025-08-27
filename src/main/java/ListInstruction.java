import java.util.List;

public class ListInstruction implements Instruction {

    @Override
    public void execute(List<Task> storage, DataStorage dataStorage) throws KlalopzException {
        if (storage.isEmpty()) {
            System.out.println("HEY! You haven't added anything yet!");
        } else {
            System.out.println("No | Task type | Completed? | Title");
            System.out.println("-----------------------------------");
            // Formatting TO DO
            for (int i = 0; i < storage.size(); i++) {
                Task currTask = storage.get(i);
                System.out.println((i + 1) + ". " + currTask);
                System.out.println(lineGap);
            }
        }
    }

    @Override
    public boolean doIExit() {
        return false;
    }
}
