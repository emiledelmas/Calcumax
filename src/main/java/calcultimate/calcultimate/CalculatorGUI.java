package calcultimate.calcultimate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorGUI.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 800);
        // width of Button fixed to 100 and height to 50
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Calcultimate");
        stage.setScene(scene);
        stage.show();
    }

    // Add a function named 'affiche' to show the GUI interface
    public void affiche() {
        launch();
    }

    // Add a function named 'change' to change the GUI interface
    public void change(String accu) {

    }

}