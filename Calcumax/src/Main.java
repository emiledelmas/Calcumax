// Import scanner
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
        System.out.println("Hello and welcome to Calcumax!");

		// Create a new instance of the class Modele
		Modele modele = new Modele();
		
		while (true) {
	     System.out.println("give a number:");

		// Create an input for the user
		Scanner sc = new Scanner(System.in);
		//if it's a double
		if (sc.hasNextDouble()) {
			// Add the double to the deque
			modele.add_double_to_deque(sc.nextDouble());
		}
		//else if it's a string
		else {
			// if it's a +
			if (sc.hasNext("\\+")) {
				modele.operation(1);
			}
			// if it's a -
			else if (sc.hasNext("-")) {
				modele.operation(2);
			}
			// if it's a *
			else if (sc.hasNext("\\*")) {
				modele.operation(3);
			}
			// if it's a /
			else if (sc.hasNext("/")) {
				modele.operation(4);
			}
			else {
				System.out.println("Not a valid input");
			}
		}
		System.out.println(modele.get_res());

	}
	}
}
