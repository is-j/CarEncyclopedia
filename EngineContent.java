package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EngineContent extends VBox {
    private Label titleLabel;
    private Label contentLabel;
    

    public EngineContent(String title, String content) {
        // Set up the overall VBox
        setSpacing(10);
        setPadding(new Insets(10));
        setStyle("-fx-background-color: #000000;");

        // Set up the title label
        titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        titleLabel.setTextFill(Color.WHITE);
        getChildren().add(titleLabel);

        // Set up the content label
        contentLabel = new Label(content);
        contentLabel.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
        contentLabel.setTextFill(Color.WHITE);
        getChildren().add(contentLabel);
    }

    public void setTitle(String title) {
        titleLabel.setText(title);
    }

    public void setContent(String content) {
        contentLabel.setText(content);
    }
}
