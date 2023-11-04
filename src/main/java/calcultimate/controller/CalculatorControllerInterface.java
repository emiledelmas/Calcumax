package calcultimate.controller;

import java.util.Stack;

/**
 * This interface defines the methods that calculator controller should implement to perform arithmetic operations.
 */
public interface CalculatorControllerInterface {

    /**
     * Send the given String to the model to be converted to a double and pushed onto the memory stack.
     *
     * @param accu The String to be converted to a double
     */
    void change(String accu);

    /**
     * Call the model to make an addition.
     */
    void add();

    /**
     * Call the model to make a subtraction.
     */
    void minus();

    /**
     * Call the model to make a multiplication.
     */
    void multiply();

    /**
     * Call the model to clear the memory stack.
     */
    void clear();

    /**
     * Call the model to make a division.
     */
    void divide();

    /**
     * Call the model to change the sign of the top value.
     */
    void opposite();

    /**
     * Get the memory stack, which holds previously stored values.
     *
     * @return A stack of double values representing the memory.
     */
    Stack<Double> getMemory();
}
