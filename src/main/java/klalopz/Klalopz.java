package klalopz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import klalopz.exceptions.KlalopzException;
import klalopz.instructions.Instruction;
import klalopz.instructions.Parser;
import klalopz.javafx.DialogBox;
import klalopz.storage.DataStorage;
import klalopz.tasks.TaskList;
import klalopz.ui.TextUi;

import java.util.Scanner;

public class Klalopz extends Application {
    private static final String botName = "klalopz";
    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));
    public static void main(String[] args) throws KlalopzException {
        Scanner scanner = new Scanner(System.in);
        DataStorage dataStorage = new DataStorage(null);
        TextUi textUi = new TextUi();
        TaskList taskList = new TaskList(dataStorage.load());

        textUi.sayOpening();

        while(true) {
            System.out.println("Your input: ");
            String currInput = scanner.nextLine().trim();
            textUi.showLine();
            try {
                Instruction instruction = Parser.parse(currInput);
                instruction.execute(taskList, dataStorage, textUi);
                if (instruction.doIExit()) {
                    break;
                }
            } catch (KlalopzException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void start(Stage stage) {
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        DialogBox dialogBox = new DialogBox("Hello!", userImage);
        dialogContainer.getChildren().addAll(dialogBox);

        AnchorPane mainLayout = new AnchorPane();

        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput, 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();
    }
}
