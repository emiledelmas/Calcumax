package calcultimate.calcultimate;// Import memory

//import Stack
import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    // Create a memory of float
    private Stack<Double> memory;
    private double accu;
    // Constructor
    public CalculatorModel() {
        memory = new Stack<Double>();
        accu = 0;
    }

    // Fonction to add a number to the memory

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
            memory.add(n1 - n2);
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

    public void opposite() {
        if (!memory.isEmpty()) {
            double n1 = memory.pop();
            memory.add(-n1);
        }
    }

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

    public double result(){
        return memory.peek();
    }
}