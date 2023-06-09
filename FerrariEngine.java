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

public class FerrariEngine extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ferrariEngineStage) throws Exception {
        // Create a toolbar with a back button
        ToolBar toolbar = new ToolBar();
        toolbar.setStyle("-fx-background-color: #000000;");
        ToolBarButtonStyle toolbarButton = new ToolBarButtonStyle();
        Button backButton = toolbarButton.MakeToolBarButton("Back");
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-color: black;"); 


    
        Image ferrariEngineImage = new Image("ferrariEngine2.png");
        ImageView imageView = new ImageView(ferrariEngineImage);
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(100);
        HBox imageBox = new HBox(imageView);
        imageBox.setAlignment(Pos.CENTER);
        VBox imageVBox = new VBox();
        imageVBox.setAlignment(Pos.CENTER);
        imageVBox.getChildren().add(imageView);
       
        // Create a media player and media view
        File mediaFile = new File("ferrariEngineVideo.mp4");
        Media media = new Media(mediaFile.toURI().toURL().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.setMute(true);
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
        Text heading = new Text("\nTHE FERRARI ENGINE");
        heading.setFill(Color.WHITE);
        heading.setFont(Font.font("Helvetica", FontWeight.BOLD, 48));
        engineOverview.getChildren().add(heading);

        // Create a label to hold the text area and set its properties
        Label label = new Label("Ferrari Engine Overview");
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
        designText.setFont(Font.font(" Impact", FontWeight.BOLD, 22));
        designText.setTextFill(Color.WHITE);
        Label designDetailsText = new Label("The Ferrari engine is a marvel of engineering and design, featuring a combination of innovative technologies and traditional craftsmanship. \nFrom the design phase to the final assembly, every aspect of the engine is carefully crafted to deliver \n maximum performance and reliability.");
        designDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        designDetailsText.setTextFill(Color.WHITE);
        Label materialsText = new Label("Materials: ");
        materialsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        materialsText.setTextFill(Color.WHITE);
        Label materialsDetailsText = new Label("The Ferrari engine is constructed using only the finest materials, including lightweight alloys like aluminum and titanium, which help to \n reduce weight and increase performance. These materials are carefully selected and tested to ensure the highest \n levels of strength, durability, and reliability.");
        materialsDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        materialsDetailsText.setTextFill(Color.WHITE);
        Label castingText = new Label("Casting and Machining: ");
        castingText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        castingText.setTextFill(Color.WHITE);
        Label castingDetailsText = new Label("The engine components are cast using precision molds and then machined to create the final shape and size of the components. This process is \ncarried out by highly skilled technicians using state-of-the-art equipment, ensuring that each component meets the \n strictest tolerances and specifications.");
        castingDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        castingDetailsText.setTextFill(Color.WHITE);
        Label assemblyText = new Label("Assembly: ");
        assemblyText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        assemblyText.setTextFill(Color.WHITE);
        Label assemblyDetailsText = new Label("The engine components are then assembled by highly skilled technicians, who carefully fit each part together to ensure that the e\nngine operates smoothly and efficiently. The assembly process is carried out with extreme precision, with each component checked and \n double-checked for accuracy and quality.");
        assemblyDetailsText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 16));
        assemblyDetailsText.setTextFill(Color.WHITE);
        Label testingText = new Label("Testing and Tuning: ");
        testingText.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 22));
        testingText.setTextFill(Color.WHITE);
        Label testingDetailsText = new Label("Once the engine is assembled, it undergoes rigorous testing to ensure that it meets the highest standards of performance and reliability. \nThis includes both bench testing and on-track testing, where the engine is put through its paces in simulated racing conditions. \nThe engine is also tuned to optimize its performance and ensure that it delivers maximum power and torque.");
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
        Text bottomText1 = new Text("Ferrari Owners Club");
        bottomText1.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 28));
        bottomText1.setFill(Color.WHITE);
        bottomText1.setTextAlignment(TextAlignment.CENTER);

        Text bottomText2 = new Text("Become a part of the exclusive world of Ferrari");
        bottomText2.setFont(Font.font("Ferrari SF", 18));
        bottomText2.setFill(Color.WHITE);
        bottomText2.setTextAlignment(TextAlignment.CENTER);

        Button bottomButton = new Button("Discover more");
        bottomButton.setStyle("-fx-background-color: #c60000; -fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;");
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
        sp.setVvalue(0);

        Scene scene = new Scene(sp, 1000, 1000);
        ferrariEngineStage.setScene(scene);
        ferrariEngineStage.setTitle("The Ferrari Engine");
        ferrariEngineStage.show();
        vBox.setPrefWidth(scene.getWidth());
        scrollPane.setFitToWidth(true);
        bp.setTop(toolBar);
        bp.setCenter(vBox);
        
        
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ferrariEngineStage.close();
                Ferrari ferrariStage = new Ferrari();
                try {
                    ferrariStage.start(ferrariEngineStage);
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
