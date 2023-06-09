package application;
//app
import java.io.File;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ferrari extends Main {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage ferrariStage) throws Exception {
		// MediaPlayer

		// Create Buttons for the Toolbar

		// Create the Buttons for the Content

		File mediaFile = new File("ferrari.mp4");

		Media media = new Media(mediaFile.toURI().toURL().toString());

		MediaPlayer mp = new MediaPlayer(media);

		MediaView mv = new MediaView(mp);

		mp.setAutoPlay(true);

		mv.setX(0);
		mv.setFitHeight(1000);
		mv.setY(0);
		mv.setFitWidth(1000);

		// Text

		// Ferrari Icon
		Image ferrariIcon = new Image("ferrariIcon.png");

		Image ferrariEngine = new Image("ferrariEngine.png");

		Image ferrariGroup = new Image("ferrariGroupCars.png");

		Image blackPicture = new Image("blackScreen.png");

		ImageView iconView = new ImageView(ferrariIcon);

		ImageView engineView = new ImageView(ferrariEngine);

		ImageView groupView = new ImageView(ferrariGroup);

		ImageView blackView = new ImageView(blackPicture);

		iconView.setFitWidth(90);
		iconView.setFitHeight(120);

		engineView.setFitHeight(300);
		engineView.setFitWidth(500);

		groupView.setFitHeight(300);
		groupView.setFitWidth(500);

		blackView.setFitWidth(1000);
		blackView.setFitHeight(100);

		engineView.setY(1500);

		// Title

		// ENGINE BUTTON

		MakeContentButton contentButton = new MakeContentButton();

		Button engineButton = contentButton.MakeContentButton("The Engine");

		Button modelButton = contentButton.MakeContentButton("The Models");
		
		

		// MODEL BUTTON

		// Buttons

		ToolBarButtonStyle buttonRun = new ToolBarButtonStyle();
		Button homeButton = buttonRun.MakeToolBarButton("Home");

		Button bmwButton = buttonRun.MakeToolBarButton("BMW");

		Button mercButton = buttonRun.MakeToolBarButton("Mercedes");

		Button porscheButton = buttonRun.MakeToolBarButton("Porsche");

		Button mcLarenButton = buttonRun.MakeToolBarButton("McLaren");

		Button audiButton = buttonRun.MakeToolBarButton("Audi");

		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = new ToolBar(homeButton, mercButton, porscheButton, iconView, audiButton, bmwButton,
				mcLarenButton);
		toolbar.setStyle("-fx-background-color: black;");

		HBox statusbar = new HBox();

		borderPane.setTop(toolbar);

		borderPane.setBottom(statusbar);

		borderPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		VBox mainScrollScreen = new VBox();

		HBox engineBlock = new HBox();

		HBox modelBlock = new HBox();

		modelBlock.getChildren().addAll(groupView, modelButton);

		engineBlock.getChildren().addAll(engineView, engineButton);

		Text text = new Text("HEY");
		text.setFill(Color.ALICEBLUE);

		// ScrollPane selection = new ScrollPane();

		ScrollPane scrollPane = new ScrollPane();

		// scrollPane.setContent(mv);

		mainScrollScreen.getChildren().addAll(mv, blackView, engineBlock, modelBlock);
		// pane.getChildren().add(engineView);

		scrollPane.setContent(mainScrollScreen);
		// scrollPane.setContent(engineView);
		// selection.setContent(engineView);

		borderPane.setCenter(scrollPane);

		scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		AnimationOfContent animationContent = new AnimationOfContent();

		animationContent.animationContent(engineView, groupView, engineButton, modelButton, scrollPane);

		Scene scene = new Scene(borderPane, Color.BLACK);

		ferrariStage.setScene(scene);

		ferrariStage.setHeight(1000);
		ferrariStage.setWidth(1000);

		ferrariStage.show();

		// EVENT HANDLERS OF CONTENT

		engineButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent engineEvent) {

				FerrariEngine ferrariEngine = new FerrariEngine();

				try {
					ferrariEngine.start(ferrariStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
		// EVENT HANDLERS FROM TOOLBAR

		homeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent bmwEvent) {
				Main main = new Main();
				try {
					main.start(ferrariStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		mcLarenButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent mclarenEvent) {
				Mclaren mclaren = new Mclaren();

				try {
					mclaren.start(ferrariStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		mercButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent mercEvent) {

				Mercedes merc = new Mercedes();

				try {
					merc.start(ferrariStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		audiButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent audiEvent) {
				Audi audi = new Audi();
				try {
					audi.start(ferrariStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

		bmwButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				BMW bmw = new BMW();

				try {
					bmw.start(ferrariStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		porscheButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Porsche porsche = new Porsche();

				try {
					porsche.start(ferrariStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
		modelButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				FerrariModel fm = new FerrariModel();
				try {
					fm.start(ferrariStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		});

	}

}

/*
 * ScrollPane MAIN--> VBox for panes in center --> Tile panes for descriptions
 * and images
 * 
 * 
 */
