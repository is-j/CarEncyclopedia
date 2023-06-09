package application;
//app
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
    private UserModel userModel;

	public static void main(String[] args) {
		launch(args);
	}
	private ObservableList<User> users;
    private ObservableList<User> pendingUsers;
	private Button MakeToolBarButton(String nameOfButton) {
		
		Button button = new Button(nameOfButton);
		
		button.setStyle("-fx-background-color: #333333;"
                + "    -fx-background-radius: 15;"
                + "    -fx-padding: 20 30 20 30;"
                + "    -fx-font-family: \"Helvetica\";"
                + "    -fx-font-size: 18px;"
                + "    -fx-font-weight: bold;"
                + "    -fx-padding: 20 30 20 30;"
                + "    -fx-text-fill: #FFFFFF;"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.5) , 5, 0.0 , 0 , 1);");

        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-background-color: #4A4A4A;"
                    + "    -fx-background-radius: 15;"
                    + "    -fx-padding: 20 30 20 30;"
                    + "    -fx-font-family: \"Helvetica\";"
                    + "    -fx-font-size: 18px;"
                    + "    -fx-font-weight: bold;"
                    + "    -fx-text-fill: #FFFFFF;"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.5) , 5, 0.0 , 0 , 1);");
        });

        button.setOnMouseExited(e -> {
            button.setStyle("-fx-background-color: #333333;"
                    + "    -fx-background-radius: 15;"
                    + "    -fx-padding: 20 30 20 30;"
                    + "    -fx-font-family: \"Helvetica\";"
                    + "    -fx-font-size: 18px;"
                    + "    -fx-font-weight: bold;"
                    + "    -fx-text-fill: #FFFFFF;"
                    + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.5) , 5, 0.0 , 0 , 1);");
        });
		
		
		
		
		return(button);
		
	}
	
	
	
	
	public void start(Stage primaryStage) throws Exception {
				

		// creating a root node to arrange all of the nodes that we have are components

		Image slaycar = new Image("lighteningMqueen.png");

		primaryStage.getIcons().add(slaycar);

		primaryStage.setTitle("Cars r slay");

		// IMAGES

		Image blackImage = new Image("blackScreen.png");
		
		ImageView iv = new ImageView(blackImage);

		File mediaFile = new File("Orange-Mclaren-DriveBy.mp4");

		Media media = new Media(mediaFile.toURI().toURL().toString());

		MediaPlayer mp = new MediaPlayer(media);

		MediaView mv = new MediaView(mp);

		mp.setAutoPlay(true);

		mv.setX(0);
		mv.setFitHeight(1000);
		mv.setY(0);
		mv.setFitWidth(1000);
		
		iv.setFitHeight(200);
		iv.setFitWidth(40);

		// BORDERPANE TOP - COMBOBOXES

	
		
		

		// BORDERPANE TOP - BUTTONS

		Button bmwButton = MakeToolBarButton("BMW");
		Button mercButton = MakeToolBarButton("Mercedes");
		Button porscheButton = MakeToolBarButton("Porsche");
		Button audiButton = MakeToolBarButton("Audi");
		Button ferrariButton = MakeToolBarButton("Ferrari");
		Button mcLarenButton = MakeToolBarButton("McLaren");
		
		//CONTENT
		
		Text missingInformationLabel = new Text("Would you like to add any missing information?\n\t     Sign up to be a registered user!");
		missingInformationLabel.setFill(Color.WHITE);
		missingInformationLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
		missingInformationLabel.setOpacity(1);
		Button registerButton = MakeToolBarButton("Register to be a User");

		// BORDERPANE TOP - TEXT

		Text title = new Text("Car Encyclopedia");
		title.setStyle(" -fx-font-smoothing-type: lcd;\n" + " -fx-fill: white;\n" + " -fx-font-size: 20pt;"
				+ "-fx-font-weight: bold;");

		
		// BORDERPANE

		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = new ToolBar(mcLarenButton, bmwButton, mercButton, title, porscheButton, audiButton,
				ferrariButton);
		toolbar.setStyle("-fx-background-color: black;");

		HBox statusbar = new HBox();

		borderPane.setTop(toolbar);

		borderPane.setBottom(statusbar);

		borderPane.setStyle("-fx-background-color: black;");
		
		

		//HBOX
		
		
		//VBox
		VBox mainMenuContent = new VBox();
		mainMenuContent.getChildren().addAll(mv,missingInformationLabel,registerButton);
		mainMenuContent.setAlignment(Pos.CENTER);
		mainMenuContent.setSpacing(40);
		// SCOLLPANE
		Scene scene = new Scene(borderPane, Color.BLACK);
		


		ScrollPane scrollPane = new ScrollPane();

	
		scrollPane.setContent(mainMenuContent);

		//scrollPane.setPannable(true);

		scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		// STACKPANE
		 
		
		// ADD THE CHILDREN AND SET THE BORDERPANE

		borderPane.setTop(toolbar);
		borderPane.setBottom(statusbar);
		borderPane.setCenter(scrollPane);

		primaryStage.setWidth(1000);
		primaryStage.setHeight(1000);

		primaryStage.setResizable(true);
		

		// BMW BUTTON
		bmwButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				BMW bmw = new BMW();
				try {
					bmw.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// McLaren Button

		mcLarenButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				Mclaren mcLaren = new Mclaren();
				try {
					mcLaren.start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		mercButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Mercedes mercedes = new Mercedes();
				try {
					mercedes.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		audiButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent audiEvent) {
				Audi audi = new Audi();
				try {
					audi.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		ferrariButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Ferrari ferrari = new Ferrari();

				try {
					ferrari.start(primaryStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		porscheButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Porsche porsche = new Porsche();

				try {
					porsche.start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		registerButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				Register register = new Register();
				
				try {
					register.start(primaryStage);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			
		});
		
			
			
			
		// primaryStage.setFullScreenExitHint("!");

		primaryStage.setScene(scene);

		primaryStage.show();

	}

}
