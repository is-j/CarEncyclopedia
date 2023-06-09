package application;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.util.Pair;

public class AddContent {
    private String content;

    public AddContent() {
        content = "";
    }

    public String getContent() {
        return content;
    }

    public void show() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Add Content");
        dialog.setHeaderText("Enter new content:");

        Button submitButton = new Button("Submit");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane gridPane = new GridPane();
        gridPane.setMaxWidth(Double.MAX_VALUE);
        gridPane.add(textArea, 0, 0);

        dialog.getDialogPane().setContent(gridPane);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                content = textArea.getText();
                return content;
            }
            return null;
        });

        dialog.showAndWait();
    }
}
