// Import accu

//import Stack
import java.util.Stack;

/*TODO
✓ Change int i in operation to String "+"
- Backspace
- Clear
- Add a button to change the sign of the number
- push(), pop(), drop(), swap(), clear() and add()
- Divide by 0 rule
- enter number digit by digit in a string and concatenate (test every time if it's a number)
- ",5" = 0.5

*/
public class Modele implements CalculatorModelInterface {
    // Create a accu of float
    private Stack<Double> accu;

    // Constructor
    public Modele() {
        accu = new Stack<Double>();
    }

    // Fonction to add a number to the accu

    public void add() {
        if (accu.size() > 1) {
            double n1 = accu.pop();
            double n2 = accu.pop();
            accu.add(n1 + n2);
        }
    }

    public void substract() {
        if (accu.size() > 1) {
            double n1 = accu.pop();
            double n2 = accu.pop();
            accu.add(n1 - n2);
        }
    }

    public void multiply() {
        if (accu.size() > 1) {
            double n1 = accu.pop();
            double n2 = accu.pop();
            accu.add(n1 * n2);
        }
    }

    public void divide() {
        if (accu.size() > 1) {
            double n1 = accu.pop();
            double n2 = accu.pop();
            if (n2 == 0) {
                System.out.println("You can't divide by 0");
            }
            else {
            accu.add(n1 / n2);
            }
        }
    }

    public void opposite() {
        if (!accu.isEmpty()) {
            double n1 = accu.pop();
            accu.add(-n1);
        }
    }

    public void push(double number) {
        accu.push(number);
    }

    public double pop() {
            return accu.pop();
    }

    public void drop() {
        accu.pop();
    }

    public void swap() {
        if (accu.size() > 1) {
            double n1 = accu.pop();
            double n2 = accu.pop();
            accu.add(n1);
            accu.add(n2);
        }
    }

    public void clear() {
        accu.clear();
    }

    public double result(){
        return accu.peek();
    }
}