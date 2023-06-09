package application;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimationOfContent {
	
	public boolean animationPlayed = false;
	
	

	public void animationContent(ImageView photo, ImageView photo2, Button button, Button button2,
			ScrollPane scrollPane) {

		TranslateTransition tt = new TranslateTransition(Duration.seconds(1), photo);
		tt.setFromX(-400);
		tt.setToX(0);

		// Create a translate transition for the button
		TranslateTransition tt2 = new TranslateTransition(Duration.seconds(1), button);
		tt2.setFromX(400);
		tt2.setToX(0);

		TranslateTransition tt3 = new TranslateTransition(Duration.seconds(1), photo2);
		tt3.setFromX(-400);
		tt3.setToX(0);

		TranslateTransition tt4 = new TranslateTransition(Duration.seconds(1), button2);
		tt4.setFromX(400);
		tt4.setToX(0);

		// Add a listener to the scroll pane to trigger the animations
		scrollPane.vvalueProperty().addListener((obs, oldVal, newVal) -> {
			double scrollPos = newVal.doubleValue();
			double height = scrollPane.getContent().getBoundsInLocal().getHeight();
			double containerHeight = scrollPane.getHeight();

			double midpoint = (height - containerHeight) / 20;

			// If we've scrolled past the midpoint, start the animations
			if (scrollPos * (height - containerHeight) > midpoint && !animationPlayed) {
				tt.play();
				tt2.play();
				tt3.play();
				tt4.play();
				animationPlayed = true;
			}

		});

	}
}
