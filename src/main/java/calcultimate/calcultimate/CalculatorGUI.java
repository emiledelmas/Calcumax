package calcultimate.calcultimate;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.List;
import java.util.Stack;

public class CalculatorGUI extends Application implements CalculatorGuiInterface {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorGUI.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 630, 700);
        // width of Button fixed to 100 and height to 50
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Calcultimate");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private Label screenText;
    @FXML
    private Label screenText1;
    @FXML
    private Label screenText2;
    // Add a function named 'affiche' to show the GUI interface
    public void affiche() {
        launch();
    }

    // Add a function named 'change' to change the GUI interface
    public void change(String accu) {
        screenText.setText(accu);
    }

    @Override
    public void change(Stack<Double> StackData) {

    }


}