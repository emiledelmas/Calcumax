package calcultimate.controller;

import java.util.Stack;

public interface CalculatorControllerInterface {
    void change(String accu);

    void add();

    void minus();

    void multiply();

    void clear();

    void divide();

    void opposite();

    Stack<Double> getMemory();
}
