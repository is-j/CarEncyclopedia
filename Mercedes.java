package application;

import java.io.File;

import javafx.application.Application;
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

public class Mercedes extends Main {

	public static void main(String[] args) {

		launch(args);

	}
	

	@Override
	public void start(Stage mercedesStage) throws Exception {
		// TODO Auto-generated method stub
		// MediaPlayer

		File mediaFile = new File("mercedes.mp4");

		Media media = new Media(mediaFile.toURI().toURL().toString());

		MediaPlayer mp = new MediaPlayer(media);

		MediaView mv = new MediaView(mp);

		mp.setAutoPlay(true);

		mv.setX(0);
		mv.setFitHeight(1000);
		mv.setY(0);
		mv.setFitWidth(1000);

		// Mercedes Icon
		Image mercedesIcon = new Image("mercedesIcon.png");
		ImageView iconView = new ImageView(mercedesIcon);

		iconView.setFitWidth(170);
		iconView.setFitHeight(80);
		
		//Mercedes Engine Image
		Image mercedesEngine = new Image("mercedesEngine.png");
		ImageView engineView = new ImageView(mercedesEngine);
		engineView.setFitHeight(330);
		engineView.setFitWidth(500);
		
		//Mercedes Model Image
		Image mercedesModel = new Image("mercedesModel.png");
		ImageView modelView = new ImageView(mercedesModel);
		modelView.setFitHeight(330);
		modelView.setFitWidth(500);

		// Title

		// Buttons for the Toolbar
		ToolBarButtonStyle buttonStyle = new ToolBarButtonStyle();
		
		Button homeButton = buttonStyle.MakeToolBarButton("Home");
		Button bmwButton = buttonStyle.MakeToolBarButton("BMW");
		Button porscheButton = buttonStyle.MakeToolBarButton("Porsche");
		Button audiButton = buttonStyle.MakeToolBarButton("Audi");
		Button ferrariButton = buttonStyle.MakeToolBarButton("Ferrari");
		Button mclarenButton = buttonStyle.MakeToolBarButton("McLaren");
		
		//Buttons for content
		
		MakeContentButton contentButton = new MakeContentButton();
		Button engineButton = contentButton.MakeContentButton("The Engine");
		Button modelButton = contentButton.MakeContentButton("The Models");

		//BorderPane 
		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = new ToolBar(homeButton, bmwButton, porscheButton, iconView, audiButton, ferrariButton,
				mclarenButton);
		toolbar.setStyle("-fx-background-color: black;");

		HBox statusbar = new HBox();

		borderPane.setTop(toolbar);
		borderPane.setBottom(statusbar);
		borderPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");
		
		//VBox and HBox		
		HBox mercedesEngineLayout = new HBox();
		mercedesEngineLayout.getChildren().addAll(engineView, engineButton);
		
		HBox mercedesModelsLayout = new HBox();
		mercedesModelsLayout.getChildren().addAll(modelView, modelButton);
		
		VBox mainScrollScreen = new VBox();
		mainScrollScreen.getChildren().addAll(mv, mercedesEngineLayout, mercedesModelsLayout);
		mainScrollScreen.setSpacing(100);
		
		//ScrollPane
		ScrollPane scrollPane = new ScrollPane();

		scrollPane.setContent(mainScrollScreen);
		borderPane.setCenter(scrollPane);
		scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		Scene scene = new Scene(borderPane, Color.BLACK);
		
		//Animation for Content Buttons
		AnimationOfContent animate = new AnimationOfContent();
		animate.animationContent(engineView, modelView, engineButton, modelButton, scrollPane);

		mercedesStage.setScene(scene);
		mercedesStage.setHeight(1000);
		mercedesStage.setWidth(1000);

		mercedesStage.show();

		//Button Action Events 

		homeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent homeEvent) {
				// TODO Auto-generated method stub
				Main main = new Main();
				try {
					main.start(mercedesStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		mclarenButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent mclarenEvent) {
				// TODO Auto-generated method stub
				Mclaren mclaren = new Mclaren();

				try {
					mclaren.start(mercedesStage);
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
					bmw.start(mercedesStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
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
					porsche.start(mercedesStage);
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
					ferrari.start(mercedesStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		audiButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent audiEvent) {
				// TODO Auto-generated method stub
				Audi audi = new Audi();
				try {
					audi.start(mercedesStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		engineButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				MercedesEngine engine = new MercedesEngine();
				try {
					engine.start(mercedesStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		});

	}

}
