package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserModel {
    private static UserModel instance;

    private ObservableList<User> users;
    private ObservableList<User> pendingUsers;

     UserModel() {
        users = FXCollections.observableArrayList();
        pendingUsers = FXCollections.observableArrayList();
    }

    public static UserModel getInstance() {
        if (instance == null) {
            instance = new UserModel();
        }
        return instance;
    }

    public ObservableList<User> getUsers() {
        return users;
    }

    public ObservableList<User> getPendingUsers() {
        return pendingUsers;
    }
}
