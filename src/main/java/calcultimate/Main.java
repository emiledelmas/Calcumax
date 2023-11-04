package calcultimate;

import calcultimate.controller.CalculatorController;
import calcultimate.controller.CalculatorControllerInterface;
import calcultimate.view.CalculatorGUI;
import calcultimate.view.CalculatorGuiInterface;
import calcultimate.model.CalculatorModel;
import calcultimate.model.CalculatorModelInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Main class is the entry point for the Calcultimate calculator application.
 * It initializes the calculator model, controller, and graphical user interface (GUI),
 * and sets up the JavaFX application for the calculator.
 */
public class Main extends Application {

    /**
     * The default constructor for the Main class.
     */
    public Main() {
    }

    /**
     * The main entry point for the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the JavaFX application and sets up the calculator model, controller, and GUI.
     *
     * @param primaryStage The primary stage for the JavaFX application.
     * @throws IOException If an input or output exception occurs.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        // Create the calculator model, controller, and GUI objects
        CalculatorModelInterface model = new CalculatorModel();
        CalculatorControllerInterface controller = new CalculatorController(model);
        CalculatorGuiInterface gui = new CalculatorGUI(controller);

        // Create the scene and set it on the stage
        Scene scene = gui.affiche();

        // Set the stage title
        primaryStage.setTitle("Calculator");
        // Set the scene on the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();
    }
}
