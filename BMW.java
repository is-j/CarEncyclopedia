package application;
//app
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

public class BMW extends Main {

	public static void main(String[] args) {

		launch(args);

	}
	

	@Override
	public void start(Stage bmwStage) throws Exception {
		// TODO Auto-generated method stub
		// MediaPlayer

		File mediaFile = new File("bmwVideo.mp4");

		Media media = new Media(mediaFile.toURI().toURL().toString());

		MediaPlayer mp = new MediaPlayer(media);

		MediaView mv = new MediaView(mp);

		mp.setAutoPlay(true);
		mp.setMute(true);

		mv.setX(200);
		mv.setFitHeight(1000);
		mv.setY(100);
		mv.setFitWidth(1000);

		// BMW Icon
		Image bmwIcon = new Image("bmwIcon.png");
		ImageView iconView = new ImageView(bmwIcon);
		iconView.setFitWidth(110);
		iconView.setFitHeight(110);
		
		//BMW Engine Image
		Image bmwEngine = new Image("bmwEngine.png");
		ImageView engineView = new ImageView(bmwEngine);
		engineView.setFitHeight(330);
		engineView.setFitWidth(500);
		
		//BMW Model Image
		Image bmwModel = new Image("bmwModels.png");
		ImageView modelView = new ImageView(bmwModel);
		modelView.setFitHeight(330);
		modelView.setFitWidth(500);
		// Title

		// Toolbar buttons
		ToolBarButtonStyle buttonStyle = new ToolBarButtonStyle();
		
		Button homeButton = buttonStyle.MakeToolBarButton("Home");
		Button mercButton = buttonStyle.MakeToolBarButton("Mercedes");
		Button porscheButton = buttonStyle.MakeToolBarButton("Porsche");
		Button audiButton = buttonStyle.MakeToolBarButton("Audi");
		Button ferrariButton = buttonStyle.MakeToolBarButton("Ferrari");
		Button mclarenButton = buttonStyle.MakeToolBarButton("McLaren");

		//Content buttons
		MakeContentButton contentButton = new MakeContentButton();
		Button engineButton = contentButton.MakeContentButton("The Engine");
		Button modelButton = contentButton.MakeContentButton("The Models");
		
		HBox statusbar = new HBox();
		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = new ToolBar(homeButton, mercButton, porscheButton, iconView, audiButton, ferrariButton,
				mclarenButton);
		toolbar.setStyle("-fx-background-color: black;");
		borderPane.setTop(toolbar);
		borderPane.setBottom(statusbar);
		borderPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");
		
		//HBox and VBox 
		
		HBox bmwEngineLayout = new HBox();
		bmwEngineLayout.getChildren().addAll(engineView, engineButton);
		
		HBox bmwModelsLayout = new HBox();
		bmwModelsLayout.getChildren().addAll(modelView, modelButton);
		
		VBox mainScrollScreen = new VBox();
		mainScrollScreen.getChildren().addAll(mv, bmwEngineLayout, bmwModelsLayout);
		mainScrollScreen.setSpacing(100);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(mainScrollScreen);


		borderPane.setCenter(scrollPane);

		scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		Scene scene = new Scene(borderPane, Color.BLACK);
		
		AnimationOfContent animate = new AnimationOfContent();
		animate.animationContent(engineView, modelView, engineButton, modelButton, scrollPane);

		bmwStage.setScene(scene);

		bmwStage.setHeight(1000);
		bmwStage.setWidth(1000);

		bmwStage.show();

		// homeButton action event

		homeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent bmwEvent) {
				// TODO Auto-generated method stub
				Main main = new Main();
				try {
					main.start(bmwStage);
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
					mclaren.start(bmwStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		mercButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent mercEvent) {

				Mercedes merc = new Mercedes();

				try {
					merc.start(bmwStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		audiButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent audiEvent) {
				// TODO Auto-generated method stub
				Audi audi = new Audi();
				try {
					audi.start(bmwStage);
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
					ferrari.start(bmwStage);
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
					porsche.start(bmwStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		engineButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				BMWEngine bmwengine = new BMWEngine();
				try {
					bmwengine.start(bmwStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		});

	}

}
