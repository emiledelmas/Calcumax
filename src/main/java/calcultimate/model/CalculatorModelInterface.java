package calcultimate.model;

import java.util.Stack;

/**
 * This interface defines the methods that the calculator model should implement to perform operations.
 */
public interface CalculatorModelInterface {

    /**
     * Add the top two values on the stack and push the result onto the stack.
     */
    void add();

    /**
     * Subtract the top value on the stack from the second-top value and push the result onto the stack.
     */
    void subtract();

    /**
     * Multiply the top two values on the stack and push the result onto the stack.
     */
    void multiply();

    /**
     * Divide the second-top value on the stack by the top value and push the result onto the stack.
     */
    void divide();

    /**
     * Change the sign of the top value on the stack to its opposite.
     */
    void opposite();

    /**
     * Push a given number onto the stack.
     *
     * @param number The number to be pushed onto the stack.
     */
    void push(double number);

    /**
     * Pop and return the top value from the stack.
     *
     * @return The top value from the stack.
     */
    double pop();

    /**
     * Swap the positions of the top two values on the stack.
     */
    void swap();

    /**
     * Remove the top value from the stack (pop it).
     */
    void drop();

    /**
     * Clear the stack, removing all values from it.
     */
    void clear();

    /**
     * Get the memory stack, which holds previously stored values.
     *
     * @return A stack of double values representing the memory.
     */
    Stack<Double> memoryGetter();
}
