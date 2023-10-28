package calcultimate;

import calcultimate.controller.CalculatorController;
import calcultimate.controller.CalculatorControllerInterface;
import calcultimate.view.CalculatorGUI;
import calcultimate.view.CalculatorGuiInterface;
import calcultimate.model.CalculatorModel;
import calcultimate.model.CalculatorModelInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        CalculatorModelInterface model = new CalculatorModel();
        CalculatorControllerInterface controller = new CalculatorController(model);



        CalculatorGuiInterface gui = new CalculatorGUI(controller);
        Scene scene = gui.affiche();

        // Afficher la fenêtre
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}