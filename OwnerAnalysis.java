package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OwnerAnalysis extends Application {

    private TextArea textArea;
    private static OwnerAnalysis instance;


    private ObservableList<User> users;
    private ObservableList<User> pendingUsers;
    

    public OwnerAnalysis(ObservableList<User> users, ObservableList<User> pendingUsers) {
    	this.users = UserModel.getInstance().getUsers();
    	this.pendingUsers = UserModel.getInstance().getPendingUsers();

    }
    private User user;

    private OwnerAnalysis() {
        // private constructor to prevent instantiation
    }

    public static OwnerAnalysis getInstance() {
        if (instance == null) {
            instance = new OwnerAnalysis();
        }
        return instance;
    }

    // add a setter method to set the user instance
    public void setUser(User user) {
        this.user = user;
    }

    // add getter methods to retrieve user information
    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }

    public String getEmail() {
        return user.getEmail();
    }
    public String getBio() {
    	
    	return user.getBio();
    }

    public String getAccountType() {
        return user.getAccountType();
    }

    @Override
    public void start(Stage stage) {
    	

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Register reg = new Register();
        

        Label titleLabel = new Label("Pending User Requests:");
        GridPane.setConstraints(titleLabel, 0, 0);

        ListView<User> pendingUsersListView = new ListView<>();
        pendingUsersListView.setItems(pendingUsers);
        pendingUsersListView.setStyle("-fx-control-inner-background:#0a0a23");
        GridPane.setConstraints(pendingUsersListView, 0, 1);

        Label infoLabel = new Label("User Information:");
        GridPane.setConstraints(infoLabel, 1, 0);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 1, 1);

        Label emailLabel = new Label("Email:");
        GridPane.setConstraints(emailLabel, 1, 2);

        Label bioLabel = new Label("Bio:");
        GridPane.setConstraints(bioLabel, 1, 3);

        TextField nameTextField = new TextField();
        nameTextField.setEditable(false);
        GridPane.setConstraints(nameTextField, 2, 1);

        TextField emailTextField = new TextField();
        emailTextField.setEditable(false);
        GridPane.setConstraints(emailTextField, 2, 2);

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setStyle("-fx-control-inner-background:#0a0a23");
        GridPane.setConstraints(textArea, 2, 3);
        Button backButton = new Button("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Main main = new Main();
				try {
					main.start(stage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
        	
        });
       
        gridPane.setStyle("-fx-background: #000000; -fx-border-color: #CECECE;");

        GridPane.setConstraints(backButton, 0, 4);
        gridPane.getChildren().add(backButton);

        Button approveButton = new Button("Approve");
        approveButton.setOnAction(event -> {
            User selectedUser = pendingUsersListView.getSelectionModel().getSelectedItem();
            if (selectedUser != null) {
                selectedUser.setApproved(true);
                users.add(selectedUser);
                pendingUsers.remove(selectedUser);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("User approved successfully!");
                alert.showAndWait();
            }
        });
        GridPane.setConstraints(approveButton, 0, 2);

        Button rejectButton = new Button("Reject");
        rejectButton.setOnAction(event -> {
            User selectedUser = pendingUsersListView.getSelectionModel().getSelectedItem();
            if (selectedUser != null) {
                pendingUsers.remove(selectedUser);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("User rejected successfully!");
                alert.showAndWait();
            }
        });
        GridPane.setConstraints(rejectButton, 0, 3);

        pendingUsersListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldUser, newUser) -> {
            if (newUser != null) {
                nameTextField.setText(newUser.getFirstName() + " " + newUser.getLastName());
                emailTextField.setText(newUser.getEmail());
                textArea.setText(newUser.getBio());
                if (newUser.isApproved()) {
                    textArea.setText(newUser.getBio());
                    textArea.setEditable(true);
                } else {
                    textArea.clear();
                    textArea.setEditable(false);
                }
            } else {
                nameTextField.clear();
                emailTextField.clear();
                textArea.clear();
                textArea.setEditable(false);
            }
        });
        gridPane.getChildren().addAll(titleLabel, pendingUsersListView, infoLabel, nameLabel, emailLabel, bioLabel,
                nameTextField, emailTextField, textArea, approveButton, rejectButton);

        Scene scene = new Scene(gridPane, 1000, 1000);

        // Show the scene
        stage.setScene(scene);
        stage.setTitle("Owner's Form");
        scene.getStylesheets().add(getClass().getResource("Owner.css").toExternalForm());

        stage.show();
    }
}
