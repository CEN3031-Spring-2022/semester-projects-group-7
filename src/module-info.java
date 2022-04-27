module javascryption {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	
	opens javascryption to javafx.graphics, javafx.fxml;
}
