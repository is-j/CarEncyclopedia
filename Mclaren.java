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

public class Mclaren extends Main {

	public static void main(String[] args) {

		launch(args);

	}
	private Button MakeToolBarButton(String nameOfButton) {
		
		Button button = new Button(nameOfButton);
		
		button.setStyle("-fx-background-color: \n"
				+ "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n"
				+ "        linear-gradient(#020b02, #3a3a3a),\n"
				+ "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n"
				+ "        linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%);\n"
				+ "    -fx-background-insets: 0,1,4,5;\n" + "    -fx-background-radius: 9,8,5,4;\n"
				+ "    -fx-padding: 25 40 25 40;\n" + "    -fx-font-family: \"Helvetica\";\n"
				+ "    -fx-font-size: 18px;\n" + "    -fx-font-weight: bold;\n" + "    -fx-text-fill: #333333;\n"
				+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
		
		return(button);
		
	}

	@Override
	public void start(Stage mcLarenStage) throws Exception {
		// TODO Auto-generated method stub

		// Mclaren Icon
		File mediaFile = new File("mclaren.mp4");
		Media media = new Media(mediaFile.toURI().toURL().toString());
		MediaPlayer mp = new MediaPlayer(media);
		MediaView mv = new MediaView(mp);

		mp.setAutoPlay(true);

		mv.setX(200);
		mv.setFitHeight(1000);
		mv.setY(100);
		mv.setFitWidth(1000);
		
		//McLaren Icon
		Image mclarenIcon = new Image("mclaren.png");
		ImageView iconView = new ImageView(mclarenIcon);
		iconView.setFitWidth(150);
		iconView.setFitHeight(100);
		
		//McLaren Engine Image
		Image mcLarenEngine = new Image("mcLarenEngine.png");
		ImageView engineView = new ImageView(mcLarenEngine);
		engineView.setFitHeight(330);
		engineView.setFitWidth(500);
		
		//McLaren Model Image
		Image mcLarenModel = new Image("mcLarenModel.png");
		ImageView modelView = new ImageView(mcLarenModel);
		modelView.setFitHeight(330);
		modelView.setFitWidth(500);

		// Title

		// Tool Bar Buttons
		ToolBarButtonStyle buttonStyle = new ToolBarButtonStyle();
		
		Button homeButton = buttonStyle.MakeToolBarButton("Home");
		Button bmwButton = buttonStyle.MakeToolBarButton("BMW");
		Button mercButton = buttonStyle.MakeToolBarButton("Mercedes");
		Button porscheButton = buttonStyle.MakeToolBarButton("Porshe");
		Button audiButton = buttonStyle.MakeToolBarButton("Audi");
		Button ferrariButton = buttonStyle.MakeToolBarButton("Ferrari");
		
		//Content Buttons
		MakeContentButton contentButton = new MakeContentButton();
		Button engineButton = contentButton.MakeContentButton("The Engine");
		Button modelButton = contentButton.MakeContentButton("The Models");
		

		BorderPane borderPane = new BorderPane();
		ToolBar toolbar = new ToolBar(homeButton, bmwButton, mercButton, iconView, porscheButton, audiButton,
				ferrariButton);
		toolbar.setStyle("-fx-background-color: black;");

		HBox statusbar = new HBox();

		borderPane.setTop(toolbar);

		borderPane.setBottom(statusbar);

		borderPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");
		//HBox and VBox
		HBox mcLarenEngineLayout = new HBox();
		mcLarenEngineLayout.getChildren().addAll(engineView, engineButton);
				
		HBox mcLarenModelsLayout = new HBox();
		mcLarenModelsLayout.getChildren().addAll(modelView, modelButton);
				
		VBox mainScrollScreen = new VBox();
		mainScrollScreen.getChildren().addAll(mv, mcLarenEngineLayout, mcLarenModelsLayout);
		mainScrollScreen.setSpacing(130);


		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(mainScrollScreen);
		borderPane.setCenter(scrollPane);
		scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

		Scene scene = new Scene(borderPane, Color.BLACK);

		AnimationOfContent animate = new AnimationOfContent();
		animate.animationContent(engineView, modelView, engineButton, modelButton, scrollPane);
		mcLarenStage.setScene(scene);

		mcLarenStage.setHeight(1000);
		mcLarenStage.setWidth(1000);

		mcLarenStage.show();

		// homeButton action event

		homeButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent bmwEvent) {
				// TODO Auto-generated method stub
				Main main = new Main();
				try {
					main.start(mcLarenStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});

		bmwButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent mclarenEvent) {
				// TODO Auto-generated method stub
				BMW bmw = new BMW();

				try {
					bmw.start(mcLarenStage);
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
					ferrari.start(mcLarenStage);
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
					merc.start(mcLarenStage);
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
					porsche.start(mcLarenStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		audiButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Audi audi = new Audi();
				try {
					audi.start(mcLarenStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		engineButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mcLarenEngine engine = new mcLarenEngine();
				try {
					engine.start(mcLarenStage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
		});

	}

}
