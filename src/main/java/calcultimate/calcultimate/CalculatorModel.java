package calcultimate.calcultimate;// Import memory

//import Stack
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    // Create a memory of double
    private final Stack<Double> memory;
    private final double accu;

    // Constructor
    public CalculatorModel() {
        memory = new Stack<Double>();
        accu = 0;
    }

    // operations methods
    public void add() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n1 + n2);
        }
    }

    public void substract() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n2 - n1);
        }
    }

    public void multiply() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n1 * n2);
        }
    }

    public void divide() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            if (n2 == 0) {
                System.out.println("You can't divide by 0");
            }
            else {
                memory.add(n1 / n2);
            }
        }
    }

    // method corresponding to sign changing button
    public void opposite() {
        if (!memory.isEmpty()) {
            double n1 = memory.pop();
            memory.add(-n1);
        }
    }

    // Classical methods for stacks
    public void push(double number) {
        memory.push(number);
    }

    public double pop() {
            return memory.pop();
    }

    public void drop() {
        memory.pop();
    }

    public void swap() {
        if (memory.size() > 1) {
            double n1 = memory.pop();
            double n2 = memory.pop();
            memory.add(n1);
            memory.add(n2);
        }
    }

    public void clear() {
        memory.clear();
    }

    //Getters
    public double memoryGetter(int i) {
        if (i < 0) {
            return memory.get(memory.size() + i);
        }
        else {
            return memory.get(i);
        }
    }
    public int getMemorySize() {
        return memory.size();
    }

}