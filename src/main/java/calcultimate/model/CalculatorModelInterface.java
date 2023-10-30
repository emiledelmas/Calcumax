package calcultimate.model;


import java.util.Stack;

public interface CalculatorModelInterface {

    void add();
    void subtract();
    void multiply();
    void divide();
    void opposite();
    void push(double number);
    double pop();
    void swap();
    void clear();

    int getMemorySize();

    Stack<Double> memoryGetter();
}