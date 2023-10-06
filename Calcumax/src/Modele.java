// Import Deque
import java.util.Deque;
// Import ArrayDeque
import java.util.ArrayDeque;

/*TODO
- Change int i in operation to String "+"
- Backspace
- Clear
- Add a button to change the sign of the number
- push(), pop(), drop(), swap(), clear() and add()
- Divide by 0 rule
- enter number digit by digit in a string and concatenate (test every time if it's a number)
- ",5" = 0.5

*/
public class Modele {
    // Create a deque of float
    private Deque<Double> deque;
    private double res;
    
    // Constructor
    public Modele() {
            deque = new ArrayDeque<Double>();
            res = 0;
    }

    // Create a getter for the res
    public double get_res() {
    	return res;
    }

    // Fonction to add a number to the deque
    public void add_double_to_deque(double i) {
        	deque.add((double) i);
    }

    public void operation(int i){
            // if deque length is more than 2
            if (deque.size() > 1) {
                // if i is 1,2,3 or 4
                if (i > 0 && i < 5){
                    double n1 = deque.pop();
                    double n2 = deque.pop();

                    if (i == 1){
                        // Add the two last numbers of the deque
                        res = n1 + n2;
                    }
                    else if (i == 2) {
                        // Substract the two last numbers of the deque
                        res = n1 - n2;
                    }
                    else if (i == 3) {
                        // multiply the two last numbers of the deque
                        res = n1 * n2;
                    }
                    else if (i == 4) {
                        // Divide the two last numbers of the deque
                        res = n1 / n2;
                    }
                    deque.add(res);
                }
             
                // Add the two last numbers of the deque
            }
            else {
                System.out.println("Not enough numbers in the deque");
            }
    }
    
}