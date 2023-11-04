package calcultimate.model;

import java.util.Stack;

/**
 * The CalculatorModel class represents the core logic for a basic calculator. It provides
 * functionality for performing arithmetic operations and managing a memory stack.
 *
 * @author Emile Delmas and Guillaume Demoor
 * @version 1.0
 */
public class CalculatorModel implements CalculatorModelInterface {

    // Create a Stack of doubles
    private final Stack<Double> memory;

    /**
     * Constructor for creating a new CalculatorModel object. Initializes the memory stack.
     */
    public CalculatorModel() {
        memory = new Stack<>();
    }

    /**
     * Adds the top two values from the memory stack and pushes the result back onto the stack.
     * If there are fewer than two values on the stack, no action is taken.
     */
    public void add() {
        if (memory.size() > 1) {
            // pop the top two values from the stack
            double n1 = memory.pop();
            double n2 = memory.pop();
            // push the sum back onto the stack
            memory.add(n1 + n2);
        }
    }

    /**
     * Subtracts the top value from the second-top value on the memory stack and pushes the result
     * back onto the stack. If there are fewer than two values on the stack, no action is taken.
     */
    public void subtract() {
        if (memory.size() > 1) {
            // pop the top two values from the stack
            double n1 = memory.pop();
            double n2 = memory.pop();
            // push the difference back onto the stack
            memory.add(n2 - n1);
        }
    }

    /**
     * Multiplies the top two values from the memory stack and pushes the result back onto the stack.
     * If there are fewer than two values on the stack, no action is taken.
     */
    public void multiply() {
        if (memory.size() > 1) {
            // pop the top two values from the stack
            double n1 = memory.pop();
            double n2 = memory.pop();
            // push the product back onto the stack
            memory.add(n1 * n2);
        }
    }

    /**
     * Divides the second-top value on the memory stack by the top value and pushes the result
     * back onto the stack. If there are fewer than two values on the stack, no action is taken.
     *
     * @throws ArithmeticException if division by 0 is attempted.
     */
    public void divide() {
        if (memory.size() >= 2) {
            // pop the top two values from the stack
            double n1 = memory.pop();
            double n2 = memory.pop();
            // if the divisor is 0, throw an exception
            if (n1 == 0) {
                // throw an exception if division by 0 is attempted
                throw new ArithmeticException("Division by 0");
            } else {
                // push the quotient back onto the stack
                memory.add(n2 / n1);
            }
        }
    }

    /**
     * Changes the sign of the top value on the memory stack by multiplying it by -1.
     * If the stack is empty, no action is taken.
     */
    public void opposite() {
        if (!memory.isEmpty()) {
            // pop the top value from the stack and push its opposite back onto the stack
            double n1 = memory.pop();
            memory.add(-n1);
        }
    }

    /**
     * Pushes a given number onto the memory stack.
     *
     * @param number The number to be pushed onto the stack.
     */
    public void push(double number) {
        memory.push(number);
    }

    /**
     * Pops and returns the top value from the memory stack.
     *
     * @return The top value from the stack.
     */
    public double pop() {
        return memory.pop();
    }

    /**
     * Removes the top value from the memory stack. If the stack is empty, no action is taken.
     */
    public void drop() {
        if (!memory.isEmpty()) {
            memory.pop();
        }
    }

    /**
     * Swaps the positions of the top two values on the memory stack.
     * If there are fewer than two values on the stack, no action is taken.
     */
    public void swap() {
        if (memory.size() > 1) {
            // pop the top two values from the stack and push them back in the opposite order
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n1);
            memory.add(n2);
        }
    }

    /**
     * Clears all values from the memory stack.
     */
    public void clear() {
        memory.clear();
    }

    // Getter for the memory stack
    /**
     * Returns the memory stack.
     *
     * @return The value of the memory stack.
     */
    public Stack<Double> memoryGetter() {
        return memory;
    }
}
