package application;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PorscheEngine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage porscheEngineStage) throws Exception {
        // Create a toolbar with a back button
        ToolBar toolbar = new ToolBar();
        toolbar.setStyle("-fx-background-color: #000000;");
        ToolBarButtonStyle toolbarButton = new ToolBarButtonStyle();
        Button backButton = toolbarButton.MakeToolBarButton("Back");
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-color: black;"); 

    
        Image porscheEngineImage = new Image("ferrariEngine2.png");
        ImageView imageView = new ImageView(porscheEngineImage);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100);
        HBox imageBox = new HBox(imageView);
        imageBox.setAlignment(Pos.CENTER);
        VBox imageVBox = new VBox();
        imageVBox.setAlignment(Pos.CENTER);
        imageVBox.getChildren().add(imageView);
       
        // Create a media player and media view
        File mediaFile = new File("porscheEngineVideo.mp4");
        Media media = new Media(mediaFile.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setMute(true);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setX(200);
        mediaView.setFitHeight(800);
        mediaView.setY(100);
        mediaView.setFitWidth(800);

        // Create a VBox to hold the media view and button
        VBox mediaBox = new VBox();
        mediaBox.setAlignment(Pos.CENTER);
        mediaBox.setStyle("-fx-background-color: #000000;");
        mediaBox.getChildren().add(mediaView);
        // Create a VBox to hold the engine overview text
        VBox engineOverview = new VBox();
        engineOverview.setPadding(new Insets(50));
        engineOverview.setStyle("-fx-background-color: #000000; -fx-opacity: 0.85;");
        engineOverview.getChildren().add(mediaBox);

        // Create a heading and add it to the VBox
        Text heading = new Text("\nTHE PORSCHE ENGINE");
        heading.setFill(Color.WHITE);
        heading.setFont(Font.font("Helvetica", FontWeight.BOLD, 48));
        engineOverview.getChildren().add(heading);

        // Create a label to hold the text area and set its properties
        Label label = new Label("Porsche Engine Overview");
        label.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        label.setTextFill(Color.WHITE);
        engineOverview.getChildren().add(label);

        // Create a TextFlow to hold the styled text
        TextFlow textFlow = new TextFlow();
        textFlow.setPadding(new Insets(20, 0, 0, 0));

        // Create Text objects to hold the engine overview text
       
     // Add the text objects to the TextFlow
     // Create Text objects to hold the engine overview text
        Label designText = new Label("Design: ");
        designText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        designText.setTextFill(Color.WHITE);
        Label designDetailsText = new Label("The Porsche engine design is a combination of cutting-edge technology and traditional craftsmanship. Each component is engineered with \nprecision and care, with a focus on both performance and aesthetics. From the engine block to the valve train, every \npart of the engine is carefully designed and crafted to deliver maximum power and efficiency.");
        designDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        designDetailsText.setTextFill(Color.WHITE);
        Label materialsText = new Label("Materials: ");
        materialsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        materialsText.setTextFill(Color.WHITE);
        Label materialsDetailsText = new Label("The Porsche engine is made using only the highest quality materials, including lightweight alloys like aluminum and magnesium. These materials are \ncarefully selected for their strength, durability, and performance characteristics, and are subjected to rigorous testing \nto ensure their quality and reliability.");
        materialsDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        materialsDetailsText.setTextFill(Color.WHITE);
        Label castingText = new Label("Casting and Machining: ");
        castingText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        castingText.setTextFill(Color.WHITE);
        Label castingDetailsText = new Label("The engine components are cast using precision molds and then machined to exacting tolerances using state-of-the-art equipment. This process \nis carried out by highly skilled technicians who take great care to ensure that every part of the engine is perfect. \nFrom the engine block to the pistons, every component is crafted with precision and attention to detail.");
        castingDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        castingDetailsText.setTextFill(Color.WHITE);
        Label assemblyText = new Label("Assembly: ");
        assemblyText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        assemblyText.setTextFill(Color.WHITE);
        Label assemblyDetailsText = new Label("The engine components are then assembled by highly trained technicians who take great care to ensure that every part of the engine is \npositioned correctly and functioning properly. The assembly process is carried out with precision and attention to detail, \nwith each component carefully checked and rechecked to ensure that it meets the highest standards of quality and performance.");
        assemblyDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        assemblyDetailsText.setTextFill(Color.WHITE);
        Label testingText = new Label("Testing and Tuning: ");
        testingText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        testingText.setTextFill(Color.WHITE);
        Label testingDetailsText = new Label("Once the Porsche engine is assembled, it undergoes a rigorous testing and tuning process to ensure that it meets the highest standards of \nquality and performance. The engine is tested under simulated racing conditions to ensure that it can withstand the \nstresses of high-speed driving, and is then tuned to optimize its power and torque output. Every Porsche engine is \na masterpiece of engineering and design.");
        testingDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        testingDetailsText.setTextFill(Color.WHITE);


        // Add the text objects to the VBox
        

        

        // Set up the scroll pane and add the label and text flow to it
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textFlow);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #000000; -fx-border-color: #000000;");

        // Set up the tool bar with the back button
        ToolBar toolBar = new ToolBar(backButton);
        toolBar.setStyle("-fx-background-color: #212121; -fx-border-color: #000000; -fx-border-width: 2px;");

        // Set up the VBox and add the label and scroll pane to it
        VBox vBox = new VBox(engineOverview, scrollPane);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10));
        vBox.setStyle("-fx-background-color: #21201E; -fx-border-color: #000000;");
        
        vBox.getChildren().addAll(
                designText, new Text("\n"), designDetailsText, new Text("\n"),
                materialsText, new Text("\n"), materialsDetailsText, new Text("\n"),
                castingText, new Text("\n"), castingDetailsText, new Text("\n"),
                assemblyText, new Text("\n"), assemblyDetailsText, new Text("\n"),
                testingText, new Text("\n"), testingDetailsText
        );
       

        // Add the tool bar, image, and VBox to the border pane
        


        // Create the bottom section with additional content
        Text bottomText1 = new Text("Porsche Owners Club");
        bottomText1.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 28));
        bottomText1.setFill(Color.WHITE);
        bottomText1.setTextAlignment(TextAlignment.CENTER);

        Text bottomText2 = new Text("Become a part of the exclusive world of Porsche");
        bottomText2.setFont(Font.font("Ferrari SF", 18));
        bottomText2.setFill(Color.WHITE);
        bottomText2.setTextAlignment(TextAlignment.CENTER);

        Button bottomButton = new Button("Discover more");
        bottomButton.setStyle("-fx-background-color:#B12B28; -fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
        bottomButton.setOnAction(e -> {
            // TODO: Handle button click
        });

        HBox bottomHBox = new HBox(bottomText1);
        bottomHBox.setAlignment(Pos.CENTER);
        bottomHBox.setStyle("-fx-background-color: #212121; -fx-border-color: #000000; -fx-border-width: 2px;");

        VBox bottomVBox = new VBox(bottomHBox, bottomText2, bottomButton);
        bottomVBox.setSpacing(10);
        bottomVBox.setPadding(new Insets(20));
        bottomVBox.setAlignment(Pos.CENTER);
        bottomVBox.setStyle("-fx-background-color: #000000; -fx-border-color: #000000;");

        // Add the bottom section to the border pane
        bp.setBottom(bottomVBox);

        // Set up the scene and show the stage
        ScrollPane sp = new ScrollPane();
        sp.setContent(bp);
        sp.setStyle("-fx-background-color: #000000; -fx-border-color: #000000;");

        Scene scene = new Scene(sp, 1000, 1000);
        porscheEngineStage.setScene(scene);
        porscheEngineStage.setTitle("The Porsche Engine");
        porscheEngineStage.show();
        vBox.setPrefWidth(scene.getWidth());
        scrollPane.setFitToWidth(true);
        bp.setTop(toolBar);
        bp.setCenter(vBox);
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	porscheEngineStage.close();
                BMW bmwEngine = new BMW();
                try {
                	bmwEngine.start(porscheEngineStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bottomButton.setOnAction(e -> {
            SignIn signIn = new SignIn();
            signIn.show();
            if (signIn.isSignedIn()) {
                AddContent addContent = new AddContent();
                addContent.show();
                if (!addContent.getContent().isEmpty()) {
                    Label newContentLabel = new Label(addContent.getContent());
                    newContentLabel.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
                    newContentLabel.setTextFill(Color.WHITE);
                    vBox.getChildren().add(newContentLabel);
                }
            }
        });



        // Add the media view and button to the VBox

        // Add the VBox to the border pane
        
        
}
   
}
