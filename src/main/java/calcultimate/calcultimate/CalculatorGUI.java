package calcultimate.calcultimate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CalculatorGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorGUI.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 630, 800);


        URL cssFile = getClass().getResource("style.css");
        if (cssFile != null) {
            scene.getStylesheets().add(cssFile.toExternalForm());
        } else {
            // Handle error if css file is not found
            System.err.println("CSS file not found, check the folder 'ressources'");
        }

        KeyboardEventHandler keyboardEventHandler = new KeyboardEventHandler(root);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler::handleKeyEvent);

        stage.setTitle("Calcultimate");
        stage.setScene(scene);
        stage.show();
    }

    // Add a function named 'affiche' to show the GUI interface
    public void affiche() {
        launch();
    }
}