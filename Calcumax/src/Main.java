// Import scanner
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
        System.out.printf("Hello and welcome to Calcumax!");

		// Create a new instance of the class Modele
		Modele modele = new Modele();
		// Create an input for the user
		Scanner sc = new Scanner(System.in);
		// Send it to the modele
		modele.add_double_to_deque(sc.nextDouble());
	}
}
