package application;
//app
import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Audi extends Main {

	public static void main(String[] args) {

		launch(args);

	}
	

	@Override
	public void start(Stage audiStage) throws Exception {
		// TODO Auto-generated method stub
		// MediaPlayer
		 
		File mediaFile = new File("audiVideo.mp4");

		Media media = new Media(mediaFile.toURI().toURL().toString());

		MediaPlayer mp = new MediaPlayer(media);

		MediaView mv = new MediaView(mp);

		mp.setMute(true);

		mp.setAutoPlay(true);

		mv.setX(200);
		mv.setFitHeight(1000);
		mv.setY(100);
		mv.setFitWidth(1000);

		// Audi Icon
		Image audiIcon = new Image("audiIcon.png");
		ImageView iconView = new ImageView(audiIcon);
		iconView.setFitWidth(130);
		iconView.setFitHeight(45);
		
		//Audi Engine Image
		Image audiEngine = new Image("audiEngine.png");
		ImageView engineView = new ImageView(audiEngine);
		engineView.setFitHeight(330);
		engineView.setFitWidth(500);
		
		//Audi Models Image 
		Image audiModel = new Image("audiModels.png");
		ImageView modelView = new ImageView(audiModel);
		modelView.setFitHeight(330);
		modelView.setFitWidth(500);

		// Title

		// Tool Bar Buttons
		
		ToolBarButtonStyle buttonRun = new ToolBarButtonStyle();
		
		Button homeButton = buttonRun.MakeToolBarButton("Home");
		Button bmwButton = buttonRun.MakeToolBarButton("BMW");
		Button porscheButton = buttonRun.MakeToolBarButton("Porsche");
		Button mercButton = buttonRun.MakeToolBarButton("Mercedes");
		Button ferrariButton = buttonRun.MakeToolBarButton("Ferrari");
		Button mcLarenButton = buttonRun.MakeToolBarButton("McLaren");
		
		//Content Buttons
		
		MakeContentButton contentButton = new MakeContentButton();
		Button engineButton = contentButton.MakeContentButton("The Engine");
		Button modelButton = contentButton.MakeContentButton("The Models");
		
		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = new ToolBar(homeButton, mercButton, bmwButton, iconView, porscheButton, ferrariButton,
				mcLarenButton);
		toolbar.setStyle("-fx-background-color: black;");

		HBox statusbar = new HBox();

		borderPane.setTop(toolbar);
		borderPane.setBottom(statusbar);
		borderPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");
		
		//HBox and VBox
		HBox audiEngineLayout = new HBox();
		audiEngineLayout.getChildren().addAll(engineView, engineButton);
		
		HBox audiModelsLayout = new HBox();
		audiModelsLayout.getChildren().addAll(modelView, modelButton);
		
		VBox mainScrollScreen = new VBox();
		mainScrollScreen.getChildren().addAll(mv, audiEngineLayout, audiModelsLayout);
		mainScrollScreen.setSpacing(130);
		
		//ScrollPane
		ScrollPane scrollPane = new ScrollPane();

		scrollPane.setContent(mainScrollScreen);
		borderPane.setCenter(scrollPane);
		scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		Scene scene = new Scene(borderPane, Color.BLACK);
		
		//Animation
		AnimationOfContent animate = new AnimationOfContent();
		animate.animationContent(engineView, modelView, engineButton, modelButton, scrollPane);

		audiStage.setScene(scene);

		audiStage.setHeight(1000);
		audiStage.setWidth(1000);

		audiStage.show();

		// homeButton action event

		homeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent homeEvent) {
				// TODO Auto-generated method stub
				Main main = new Main();
				try {
					main.start(audiStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		mcLarenButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent mclarenEvent) {
				// TODO Auto-generated method stub
				Mclaren mclaren = new Mclaren();

				try {
					mclaren.start(audiStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		bmwButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				BMW bmw = new BMW();
				try {
					bmw.start(audiStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		ferrariButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Ferrari ferrari = new Ferrari();

				try {
					ferrari.start(audiStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		mercButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent mercEvent) {

				Mercedes merc = new Mercedes();

				try {
					merc.start(audiStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		porscheButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Porsche porsche = new Porsche();

				try {
					porsche.start(audiStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		engineButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AudiEngine audiengine = new AudiEngine();
				try {
					audiengine.start(audiStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		});

	}

}
