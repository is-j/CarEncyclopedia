package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class FerrariModel extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ferrariModelsStage) throws Exception {
        // Create a toolbar with a back button
        ToolBar toolbar = new ToolBar();
        toolbar.setStyle("-fx-background-color: #000000;");
        ToolBarButtonStyle toolbarButton = new ToolBarButtonStyle();
        javafx.scene.control.Button backButton = toolbarButton.MakeToolBarButton("Back");
        BorderPane bp = new BorderPane();
        bp.setStyle("-fx-background-color: black;");

        // Create a VBox to hold the model overview text
        VBox modelOverview = new VBox();
        modelOverview.setPadding(new Insets(50));
        modelOverview.setStyle("-fx-background-color: #000000; -fx-opacity: 0.85;");

        // Create a heading and add it to the VBox
        Text heading = new Text("\n\t      FERRARI MODELS");
        heading.setFill(Color.WHITE);
        heading.setFont(Font.font("Helvetica", FontWeight.BOLD, 48));
        modelOverview.getChildren().add(heading);

        // Create a label to hold the text area and set its properties
        Label label = new Label("Ferrari Models Overview");
        label.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        label.setTextFill(Color.WHITE);
        modelOverview.getChildren().add(label);

        // Create an HBox to hold the model information
        HBox modelBox = new HBox();
        modelBox.setPadding(new Insets(20));
        modelBox.setAlignment(Pos.CENTER);
        modelBox.setStyle("-fx-background-color: #212121; -fx-border-color: #000000; -fx-border-width: 2px;");
        modelBox.setSpacing(20);

        // Create labels to hold the model names and descriptions
        ImageView model1Image = new ImageView(new Image("ferrariBerlinetta.png"));
        model1Image.setFitWidth(200);
        model1Image.setFitHeight(150);
        VBox model1VBox = new VBox(model1Image);
        model1VBox.setAlignment(Pos.CENTER);

        Text model1Title = new Text("Ferrari Berlinetta");
        model1Title.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 20));
        model1Title.setFill(Color.WHITE);
        model1Title.setTextAlignment(TextAlignment.CENTER);

        Label model1Desc = new Label("The Ferrari Berlinetta is a front mid-engine, rear-wheel-drive grand tourer produced by Italian sports car manufacturer Ferrari. The F12 Berlinetta debuted at the 2012 Geneva Motor Show, and replaces the 599 grand tourer. It was named \"The Supercar of the Year 2012\" by car magazine Top Gear.");
        model1Desc.setFont(Font.font("Ferrari SF", 16));
        model1Desc.setTextFill(Color.WHITE);
        model1Desc.setWrapText(true);
        model1Desc.setPrefWidth(400);

        HBox model1HBox = new HBox(model1VBox, model1Desc);
        model1HBox.setAlignment(Pos.CENTER);
        model1HBox.setSpacing(20);

     // Set up model 2
        ImageView model2Image = new ImageView(new Image("FerrariF8.png"));
        model2Image.setFitWidth(200);
        model2Image.setFitHeight(150);
        VBox model2VBox = new VBox(model2Image);
        model2VBox.setAlignment(Pos.CENTER);

        Text model2Title = new Text("Ferrari F8");
        model2Title.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 20));
        model2Title.setFill(Color.WHITE);
        model2Title.setTextAlignment(TextAlignment.CENTER);

        Label model2Desc = new Label("The Ferrari F8 is a mid-engine sports car that was introduced in 2019 as a replacement for the 488 GTB. \nIt features a 3.9-liter V8 engine that produces 710 horsepower and 568 lb-ft of torque. \nThe F8 has a top speed of 211 mph and can accelerate from 0-60 mph in just 2.9 seconds.");
        model2Desc.setFont(Font.font("Ferrari SF", 16));
        model2Desc.setTextFill(Color.WHITE);
        model2Desc.setWrapText(true);
        model2Desc.setPrefWidth(400);

        HBox model2HBox = new HBox(model2VBox, model2Desc);
        model2HBox.setAlignment(Pos.CENTER);
        model2HBox.setSpacing(20);

        // Set up model 3
        ImageView model3Image = new ImageView(new Image("ferrariImageI.png"));
        model3Image.setFitWidth(200);
        model3Image.setFitHeight(150);

        VBox model3VBox = new VBox(model3Image);
        model3VBox.setAlignment(Pos.CENTER);

        Text model3Title = new Text("Ferrari 458");
        model3Title.setFont(Font.font("Ferrari SF", FontWeight.BOLD, 20));
        model3Title.setFill(Color.WHITE);
        model3Title.setTextAlignment(TextAlignment.CENTER);

        Label model3Desc = new Label("The Ferrari 458 Italia is a mid-engine sports car produced by the Italian sports car manufacturer Ferrari. The 458 replaced the F430, and was first officially unveiled at the 2009 Frankfurt Motor Show. It was succeeded by the 488 GTB, which was unveiled at the 2015 Geneva Motor Show.");
        model3Desc.setFont(Font.font("Ferrari SF", 16));
        model3Desc.setTextFill(Color.WHITE);
        model3Desc.setWrapText(true);
        model3Desc.setPrefWidth(400);

        HBox model3HBox = new HBox(model3VBox, model3Desc);
        model3HBox.setAlignment(Pos.CENTER);
        model3HBox.setSpacing(20);
        

        // Set up the back button
        ToolBarButtonStyle toolbarButton1 = new ToolBarButtonStyle();
        Button backButton1 = toolbarButton1.MakeToolBarButton("Back");

        
		// Set up the VBox to hold the models
        VBox modelsVBox = new VBox(model1HBox, model2HBox, model3HBox);
        modelsVBox.setSpacing(20);
        modelsVBox.setAlignment(Pos.CENTER);
        modelsVBox.setStyle("-fx-background-color: #212121; -fx-border-color: #000000; -fx-border-width: 2px; -fx-padding: 20px;");
        modelsVBox.setMaxWidth(800);

        // Set up the tool bar with the back button
        ToolBar toolBar = new ToolBar(backButton1, heading);
        toolBar.setStyle("-fx-background-color: #212121; -fx-border-color: #000000; -fx-border-width: 2px;");


        // Set up the BorderPane and add the VBox and tool bar
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #000000; -fx-border-color: #000000;");
        root.setTop(toolBar);
        root.setCenter(modelsVBox);
     // Create the scene and set it on the stage
        Scene scene = new Scene(root, 1000, 1000);
        ferrariModelsStage.setScene(scene);
        ferrariModelsStage.setTitle("Ferrari Models");
        ferrariModelsStage.show();

        // Set the VBox width to the scene width
        modelsVBox.setPrefWidth(scene.getWidth());

        // Handle back button click to go back to Ferrari stage
        backButton1.setOnAction(e -> {
            ferrariModelsStage.close();
            Ferrari ferrariStage = new Ferrari();
            try {
                ferrariStage.start(ferrariModelsStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}



