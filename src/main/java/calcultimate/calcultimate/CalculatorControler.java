package calcultimate.calcultimate;

import java.util.Stack;


public class CalculatorControler implements CalculatorControlerInterface{


    public double change(String accu) {
        // convert string to double or int if its a int
        return Double.parseDouble(accu);
    }


    public String change(Stack<Double> StackData) {
//        Convert the last one to double
        double d = StackData.pop();
        // Convert to string
        String s = Double.toString(d);
        return s;
    }



}