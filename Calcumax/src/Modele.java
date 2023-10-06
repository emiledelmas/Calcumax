// Import Deque
import java.util.Deque;
// Import ArrayDeque
import java.util.ArrayDeque;


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
            System.out.println(deque);
    }

    //

    
}