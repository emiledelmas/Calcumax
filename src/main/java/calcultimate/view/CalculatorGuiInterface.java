package calcultimate.view;

import javafx.scene.Scene;
import java.util.Stack;

/**
 * This interface defines the methods that the GUI should implement to interact with the controller.
 */
public interface CalculatorGuiInterface {

    /**
     * Display the calculator GUI in a JavaFX Scene.
     *
     * @return A JavaFX Scene containing the calculator GUI components.
     */
    Scene affiche();

    /**
     * Update the calculator GUI with the provided memory stack, which may contain previously stored values.
     *
     * @param memory A stack of double values representing the memory to be displayed in the GUI.
     */
    void change(Stack<Double> memory);
}
