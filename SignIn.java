package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SignIn {
    private Stage stage;
    private TextField emailField;
    private PasswordField passwordField;
    private boolean isSignedIn;
    private String userEmail;
    private String userPassword;

    public SignIn() {
        isSignedIn = false;
        userEmail = "";
        userPassword = "";
        buildStage();
    }

    public boolean isSignedIn() {
        return isSignedIn;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    private void buildStage() {
        stage = new Stage();
        stage.setTitle("Sign In");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 0, 0);

        emailField = new TextField();
        GridPane.setConstraints(emailField, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        passwordField = new PasswordField();
        GridPane.setConstraints(passwordField, 1, 1);

        Button signInButton = new Button("Sign In");
        signInButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            // Check if the user is registered and approved by the owner
            boolean isUserApproved = false;
            for (User user : UserModel.getInstance().getUsers()) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    if (user.isTermsAccepted()) {
                        isUserApproved = true;
                        break;
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("User not approved");
                        alert.setContentText("Your account is not yet approved by the site owner. Please try again later.");
                        alert.showAndWait();
                        return;
                    }
                }
            }

            if (isUserApproved) {
                // Set isSignedIn to true and store email and password
                isSignedIn = true;
                userEmail = email;
                userPassword = password;
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid credentials");
                alert.setContentText("Please enter a valid email and password.");
                alert.showAndWait();
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            isSignedIn = false;
            stage.close();
        });

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(signInButton, cancelButton);
        GridPane.setConstraints(buttonBox, 1, 2);

        grid.getChildren().addAll(emailLabel, emailField, passwordLabel, passwordField, buttonBox);

        Scene scene = new Scene(grid);
        stage.setScene(scene);
    }

    public void show() {
        stage.showAndWait();
    }

}
