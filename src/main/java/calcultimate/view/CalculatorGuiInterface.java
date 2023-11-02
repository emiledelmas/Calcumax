package calcultimate.view;

import javafx.scene.Scene;
import java.util.Stack;

public interface CalculatorGuiInterface {
    Scene affiche();

    void change(Stack<Double> memory);

}
