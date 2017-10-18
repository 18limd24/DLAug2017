/*Darren Lim
 * 10/10/17
 * This is part 5 of our Calculate project.
 * QuadraticClient will contain a main method and handle interactions with the user
 */
import java.util.*;//for Scanner
public class QuadraticClient {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		do {
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and c");
		System.out.print("a: ");
		double a = console.nextDouble();
		System.out.print("b: ");
		double b = console.nextDouble();
		System.out.print("c: ");
		double c = console.nextDouble();
		System.out.println();
		String description = Quadratic.quadrDescriber(a,b,c);
		System.out.println(description);
		System.out.println("Do you want to keep going? (Type \"quit\" to end)");
		//String quit = console.next();
		}while(!(console.next().equals("quit"))); 
		
		
	}
	

}
