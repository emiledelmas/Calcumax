package calcultimate.model;

// Import memory

//import Stack
import java.util.Stack;

/**
 * The CalculatorModel class represents the core logic for a basic calculator. It provides
 * functionality for performing arithmetic operations and managing a memory stack.
 */
public class CalculatorModel implements CalculatorModelInterface {

    // Create a Stack of double
    private final Stack<Double> memory;
    private final double accu;

    /**
     * Constructor for creating a new CalculatorModel object. Initializes the memory stack
     * and sets the accumulator to 0.
     */
    public CalculatorModel() {
        memory = new Stack<Double>();
        accu = 0;
    }

    // operations methods

    /**
     * Adds the top two values from the memory stack and pushes the result back onto the stack.
     * If there are fewer than two values on the stack, no action is taken.
     */
    public void add() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n1 + n2);
        }
    }

    /**
     * Subtracts the top value from the second-top value on the memory stack and pushes the result
     * back onto the stack. If there are fewer than two values on the stack, no action is taken.
     */
    public void subtract() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n2 - n1);
        }
    }

    /**
     * Multiplies the top two values from the memory stack and pushes the result back onto the stack.
     * If there are fewer than two values on the stack, no action is taken.
     */
    public void multiply() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n1 * n2);
        }
    }

    /**
     * Divides the second-top value on the memory stack by the top value and pushes the result
     * back onto the stack. If there are fewer than two values on the stack or if the top value is 0,
     * no action is taken.
     */
    public void divide() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            if (n1 == 0) {
                throw new ArithmeticException("Division by 0");
            } else {
                memory.add(n2 / n1);
            }
        }
    }

    // method corresponding to sign changing button

    /**
     * Changes the sign of the top value on the memory stack by multiplying it by -1.
     * If the stack is empty, no action is taken.
     */
    public void opposite() {
        if (!memory.isEmpty()) {
            double n1 = memory.pop();
            memory.add(-n1);
        }
    }

    // Classical methods for stacks

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
        memory.pop();
    }

    /**
     * Swaps the positions of the top two values on the memory stack.
     * If there are fewer than two values on the stack, no action is taken.
     */
    public void swap() {
        if (memory.size() > 1) {
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

    // Getters

    /**
     * Retrieves a value from the memory stack at the specified index.
     * Negative index values count from the end of the stack.
     *
     * @param i The index of the value to retrieve.
     * @return The value at the specified index.
     */
    public Stack<Double> memoryGetter() {
        return memory;
    }

    /**
     * Gets the current size of the memory stack.
     *
     * @return The number of values in the memory stack.
     */
    public int getMemorySize() {
        return memory.size();
    }
}
