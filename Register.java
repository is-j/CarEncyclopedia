
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Register extends Application {
	private ObservableList<User> users = FXCollections.observableArrayList();
	private ObservableList<User> pendingUsers = FXCollections.observableArrayList();
    @Override
    public void start(Stage stage) {
    	
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label firstNameLabel = new Label("Enter Your First Name:");
        TextField firstNameTextField = new TextField();

        Label lastNameLabel = new Label("Enter Your Last Name:");
        TextField lastNameTextField = new TextField();

        Label emailLabel = new Label("Enter Your Email:");
        TextField emailTextField = new TextField();

        Label passwordLabel = new Label("Create a New Password:");
        PasswordField passwordField = new PasswordField();

        Label accountTypeLabel = new Label("Select Account Type:");
        ToggleGroup accountTypeToggleGroup = new ToggleGroup();
        RadioButton personalAccountRadioButton = new RadioButton("Owner Account");
        personalAccountRadioButton.setToggleGroup(accountTypeToggleGroup);
        RadioButton businessAccountRadioButton = new RadioButton("Registered User Account");
        businessAccountRadioButton.setToggleGroup(accountTypeToggleGroup);
        
        Label passwordOwnerLabel = new Label("Enter Owner Password:");
        PasswordField passwordOwnerField = new PasswordField();

        Label termsLabel = new Label("Accept Terms and Conditions:");
        CheckBox termsCheckBox = new CheckBox();

        Label ageLabel = new Label("Input your age (years):");
        Spinner<Integer> ageSpinner = new Spinner<>(13, 120, 18);

        Label referrerLabel = new Label("How did you hear about us?");
        ChoiceBox<String> referrerChoiceBox = new ChoiceBox<>();
        referrerChoiceBox.getItems().addAll("(select one)", "Linkedin", "Wikipedia", "Refferal", "Other");
        referrerChoiceBox.setValue("(select one)");

        Label bioLabel = new Label("Why do you want to be a registered user?");
        TextArea bioTextArea = new TextArea();
        bioTextArea.setStyle("-fx-control-inner-background:#000000");
        
        Button back = new Button("Back");
        back.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Main main = new Main();
				try {
					main.start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        	
        });

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            // Handle form submission
        });
        Button ownerPage = new Button("Owner");
        gridPane.add(firstNameLabel, 0, 0);
        gridPane.add(firstNameTextField, 1, 0);
        gridPane.add(lastNameLabel, 0, 1);
        gridPane.add(lastNameTextField, 1, 1);
        gridPane.add(emailLabel, 0, 2);
        gridPane.add(emailTextField, 1, 2);
        gridPane.add(passwordLabel, 0, 3);
        gridPane.add(passwordField, 1, 3);
        gridPane.add(accountTypeLabel, 0, 4);
        gridPane.add(personalAccountRadioButton, 1, 4);
        gridPane.add(businessAccountRadioButton, 1, 5);
        gridPane.add(termsLabel, 0, 6);
        gridPane.add(termsCheckBox, 1, 6);
        gridPane.add(ageLabel, 0, 7);
        gridPane.add(ageSpinner, 1, 7);
        gridPane.add(referrerLabel, 0, 8);
        gridPane.add(referrerChoiceBox, 1, 8);
        gridPane.add(bioLabel, 0, 9);
        gridPane.add(bioTextArea, 1, 9);
        gridPane.add(submitButton, 1, 10);
        gridPane.add(back, 0, 11);
        gridPane.add(ownerPage, 5, 20);
       
        gridPane.setStyle("-fx-background: #000000; -fx-border-color: #CECECE;");
        Scene scene = new Scene(gridPane, 1000, 1000);
        bioTextArea.setStyle("-fx-background-color: #0a0a23");
        
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("register.css").toExternalForm());
        stage.setTitle("Registration Form");
        stage.show();
        
        
        
        submitButton.setOnAction(event -> {
            // Get the values from the form fields
            String accountType = null;

        	
            if (personalAccountRadioButton.isSelected()) {
                accountType = "Personal Account";
            } else if (businessAccountRadioButton.isSelected()) {
                accountType = "Business Account";
            }            boolean acceptsTerms = termsCheckBox.isSelected();
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String email = emailTextField.getText();
            String password = passwordField.getText();
            boolean termsAccepted = termsCheckBox.isSelected();
            int age = ageSpinner.getValue();
            String referrer = referrerChoiceBox.getValue();
            String bio = bioTextArea.getText();
           

            // Create a new User object with the form values
            User newUser = new User(firstName, lastName, email, password, accountType, acceptsTerms, age, referrer, bio);
            OwnerAnalysis.getInstance().setUser(newUser);


            // Add the new user to the list of pending users
            
            
            UserModel.getInstance().getUsers().add(newUser);
            UserModel.getInstance().getPendingUsers().add(newUser);



            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || accountType.isEmpty() || !acceptsTerms || referrer.equals("(select one)")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all required fields");
                alert.showAndWait();
            } else if (!email.matches("[^@]+@[^\\.]+\\..+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email address");
                alert.showAndWait();
            } else {
                // Save input data to a file or a database
                // ...
                // Show a confirmation message
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Registration successful");
                alert.setContentText("Your registration has been submitted and is pending approval by the site owner.");
                firstNameTextField.clear();
                lastNameTextField.clear();
                emailTextField.clear();
                passwordField.clear();
                personalAccountRadioButton.setSelected(true);
                termsCheckBox.setSelected(false);
                ageSpinner.getValueFactory().setValue(18);
                referrerChoiceBox.setValue("(select one)");
                bioTextArea.clear();
                alert.showAndWait();
                OwnerAnalysis ownerAnalysis = new OwnerAnalysis(users, pendingUsers);
                pendingUsers.add(newUser);
                OwnerAnalysis.getInstance().setUser(newUser);
               
                
                
            }
            
            
            
        });
        ownerPage.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent ownerPageRun) {
                // Prompt the user for the owner password
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Owner Password");
                dialog.setHeaderText("Enter the owner password:");
                dialog.setContentText("Password:");

                // Get the result of the dialog
                Optional<String> result = dialog.showAndWait();
                String accountType = null;

            	
                if (personalAccountRadioButton.isSelected()) {
                    accountType = "Personal Account";
                } else if (businessAccountRadioButton.isSelected()) {
                    accountType = "Business Account";
                }            boolean acceptsTerms = termsCheckBox.isSelected();
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordField.getText();
                boolean termsAccepted = termsCheckBox.isSelected();
                int age = ageSpinner.getValue();
                String referrer = referrerChoiceBox.getValue();
                String bio = bioTextArea.getText();
               

                // Create a new User object with the form values
                User newUser = new User(firstName, lastName, email, password, accountType, acceptsTerms, age, referrer, bio);
                newUser.setBio(bio);
                OwnerAnalysis.getInstance().setUser(newUser);

                // Check if the password is correct
                if (result.isPresent() && result.get().equals("ownerpassword")) {
                    // Show the owner page
                   
                    UserModel.getInstance().getUsers().add(newUser);
                    UserModel.getInstance().getPendingUsers().add(newUser);

                    OwnerAnalysis ownerAnalysis = new OwnerAnalysis(users, pendingUsers);
                    pendingUsers.add(newUser);
                    OwnerAnalysis.getInstance().setUser(newUser);
                    ownerAnalysis.start(stage);
                } else {
                    // Show an error message
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Incorrect password");
                    alert.setContentText("Please enter the correct password to access this page.");
                    alert.showAndWait();
                }
            }
        });
    }

        // Helper method to get the user details from the form fields
      

        
        
        
    

    public static void main(String[] args) {
        launch();
    }
    

    

}

