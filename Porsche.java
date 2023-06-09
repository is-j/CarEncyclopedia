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

public class Porsche extends Main {

	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage porscheStage) throws Exception {
		//MediaPlayer
		
		File mediaFile = new File("porsche.mp4");
		
        Media media = new Media(mediaFile.toURI().toURL().toString());
		
		MediaPlayer mp = new MediaPlayer(media);
		
		MediaView mv = new MediaView(mp);
		
		mp.setMute(true);
		
		mp.setAutoPlay(true);
		
		mv.setX(200);
		mv.setFitHeight(1000);
		mv.setY(100);
		mv.setFitWidth(1000);
		
		//Porsche Icon
		Image porscheIcon = new Image("porsheIcon.png");
		ImageView iconView = new ImageView(porscheIcon);
		
		
		iconView.setFitWidth(120);
		iconView.setFitHeight(75);
		
		//Porsche Engine Image
		
		Image engineImage = new Image("porscheEngine.png");
		ImageView engineView = new ImageView(engineImage);
		engineView.setFitHeight(330);
		engineView.setFitWidth(500);

		
		//Porsche Models Image
		Image modelImage = new Image("porscheModel.png");
		ImageView modelView = new ImageView(modelImage);
		modelView.setFitHeight(330);
		modelView.setFitWidth(500);

		
		//Title
		
		
		//ToolBar Buttons 
		ToolBarButtonStyle buttonRun = new ToolBarButtonStyle();
		Button homeButton = buttonRun.MakeToolBarButton("Home");
		Button bmwButton = buttonRun.MakeToolBarButton("BMW");
		Button mercButton = buttonRun.MakeToolBarButton("Mercedes");
		Button ferrariButton = buttonRun.MakeToolBarButton("Ferrari");
		Button mcLarenButton = buttonRun.MakeToolBarButton("McLaren");
		Button audiButton = buttonRun.MakeToolBarButton("Audi");
		
		//Content Buttons
		MakeContentButton contentButton = new MakeContentButton();
		Button engineButton = contentButton.MakeContentButton("The Engine");
		Button modelButton = contentButton.MakeContentButton("The Models");
		
		//BorderPanes 
		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = new ToolBar(homeButton, mercButton, bmwButton, iconView, audiButton,ferrariButton, mcLarenButton);
		toolbar.setStyle("-fx-background-color: black;");
		
		HBox statusbar = new HBox();
		
		//HBox and VBox
		HBox engineLayout = new HBox();
		engineLayout.getChildren().addAll(engineView, engineButton);
		
		HBox modelLayout = new HBox();
		modelLayout.getChildren().addAll(modelView, modelButton);
		
		VBox mainScrollScreen = new VBox();
		mainScrollScreen.getChildren().addAll(mv, engineLayout, modelLayout);
		mainScrollScreen.setSpacing(90);
		
			     
		borderPane.setTop(toolbar);
			     
		borderPane.setBottom(statusbar);
		
		borderPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(mainScrollScreen);

		//Animation
		AnimationOfContent animate = new AnimationOfContent();
		animate.animationContent(engineView, modelView, engineButton, modelButton, scrollPane);
		
		borderPane.setCenter(scrollPane);
		
		scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		Scene scene = new Scene(borderPane, Color.BLACK);
		
		porscheStage.setScene(scene);
		
		porscheStage.setHeight(1000);
		
		porscheStage.setWidth(1000);
		
		porscheStage.show();
		
		
		//homeButton action event
		
		homeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent bmwEvent) {
				Main main = new Main();
				try {
					main.start(porscheStage);
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
					mclaren.start(porscheStage);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
			
		});
		
		mercButton.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent mercEvent) {
				
				Mercedes merc = new Mercedes();
				
				try {
					merc.start(porscheStage);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		audiButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent audiEvent) {
				Audi audi = new Audi();
				try {
					audi.start(porscheStage);
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
					bmw.start(porscheStage);
				} catch (Exception e) {
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
					ferrari.start(porscheStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
			
		});
		engineButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				PorscheEngine engine = new PorscheEngine();
				try {
					engine.start(porscheStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		});
		
		
	}

}
