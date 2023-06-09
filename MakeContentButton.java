package application;

import javafx.scene.control.Button;

public class MakeContentButton {
	public Button MakeContentButton(String nameOfButton) {

		Button button = new Button(nameOfButton);

		button.setStyle("-fx-background-color: \n"
				+ "        linear-gradient(#000000 0%, #000000 25%, #000000 75%, #000000 100%),\n"
				+ "        linear-gradient(#000000, #000000),\n"
				+ "        linear-gradient(#000000 0%, #000000 20%, #000000 80%, #000000 100%),\n"
				+ "        linear-gradient(#000000 0%, #000000 50%, #000000 51%, #000000 100%);\n"
				+ "    -fx-background-insets: 0,1,4,5;\n" + "    -fx-background-radius: 9,8,5,4;\n"
				+ "    -fx-padding: 140 110 140 110;\n" + "    -fx-font-family: \"Helvetica\";\n"
				+ "    -fx-font-size: 45px;\n" + "    -fx-font-weight: bold;\n" + "    -fx-text-fill: #d3d3d3;\n"
				+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

		button.setOnMouseEntered(e -> {
			button.setStyle("-fx-background-color: \n"
					+ "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n"
					+ "        linear-gradient(#000000, #000000),\n"
					+ "        linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%),\n"
					+ "        linear-gradient(#5A5A5A 0%, #000000 50%, #000000 51%, #5A5A5A 100%);\n"
					+ "    -fx-background-insets: 0,1,4,5;\n" + "    -fx-background-radius: 9,8,5,4;\n"
					+ "    -fx-padding: 140 110 140 110;\n" + "    -fx-font-family: \"Helvetica\";\n"
					+ "    -fx-font-size: 45px;\n" + "    -fx-font-weight: bold;\n" + "    -fx-text-fill: #FFFFFF;\n"
					+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
		});
		button.setOnMouseExited(e -> {
			button.setStyle("-fx-background-color: \n"
					+ "        linear-gradient(#000000 0%, #000000 25%, #000000 75%, #000000 100%),\n"
					+ "        linear-gradient(#000000, #000000),\n"
					+ "        linear-gradient(#000000 0%, #000000 20%, #000000 80%, #000000 100%),\n"
					+ "        linear-gradient(#000000 0%, #000000 50%, #000000 51%, #000000 100%);\n"
					+ "    -fx-background-insets: 0,1,4,5;\n" + "    -fx-background-radius: 9,8,5,4;\n"
					+ "    -fx-padding: 140 110 140 110;\n" + "    -fx-font-family: \"Helvetica\";\n"
					+ "    -fx-font-size: 45px;\n" + "    -fx-font-weight: bold;\n" + "    -fx-text-fill: #d3d3d3;\n"
					+ "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

		});
		return(button);

	}
}
