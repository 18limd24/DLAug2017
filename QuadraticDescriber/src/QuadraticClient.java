/*Darren Lim
 * 10/10/17
 * This is part 5 of our Calculate project.
 * QuadraticClient will contain a main method and handle interactions with the user
 */
import java.util.*;//for Scanner
public class QuadraticClient {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the Quadratic Describer");
		System.out.println("Provide values for coefficients a, b, and c");
		double a = console.nextDouble();
		double b = console.nextDouble();
		double c = console.nextDouble();
		String description = Quadratic.quadrDescriber(a,b,c);
		System.out.print(description);
		//ask if they want to go again
	}

}
