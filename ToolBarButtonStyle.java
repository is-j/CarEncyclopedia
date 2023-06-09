package application;

import javafx.scene.control.Button;

public class ToolBarButtonStyle {
    public Button MakeToolBarButton(String nameOfButton) {

        Button button = new Button(nameOfButton);

        button.setStyle("-fx-background-color: #333333;"
                + "    -fx-background-radius: 15;"
                + "    -fx-padding: 30 35 30 35;"
                + "    -fx-font-family: \"Helvetica\";"
                + "    -fx-font-size: 18px;"
                + "    -fx-font-weight: bold;"
                + "    -fx-text-fill: #FFFFFF;"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.5) , 5, 0.0 , 0 , 1);");

        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-background-color: #4A4A4A;"
                    + "    -fx-background-radius: 15;"
                    + "    -fx-padding: 30 35 30 35;"
                    + "    -fx-font-family: \"Helvetica\";"
                    + "    -fx-font-size: 18px;"
                    + "    -fx-font-weight: bold;"
                    + "    -fx-text-fill: #FFFFFF;"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.5) , 5, 0.0 , 0 , 1);");
        });

        button.setOnMouseExited(e -> {
            button.setStyle("-fx-background-color: #333333;"
                    + "    -fx-background-radius: 15;"
                    + "    -fx-padding: 30 35 30 35;"
                    + "    -fx-font-family: \"Helvetica\";"
                    + "    -fx-font-size: 18px;"
                    + "    -fx-font-weight: bold;"
                    + "    -fx-text-fill: #FFFFFF;"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.5) , 5, 0.0 , 0 , 1);");
        });

        return button;
    }
}
