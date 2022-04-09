module javascryption {
	requires javafx.controls;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	requires junit;
	
	opens javascryption to javafx.graphics, javafx.fxml;
}
