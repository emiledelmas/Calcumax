package calcultimate.calcultimate;

import java.util.List;
import java.util.Stack;

public interface CalculatorGuiInterface {
    void affiche();
    void change(String accu);
    void change(Stack<Double> StackData);
}
