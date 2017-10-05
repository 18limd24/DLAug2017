
/*Darren Lim
 * 10/3/17
 * Collaborative Programming Exercise
 */
import java.util.*;

public class ProcessingNumbers {
	public static void main(String[] args) {
	// accepts as user input a string of numbers
	// this code assumes they are ints
	// prints the smallest and largest of all the numbers supplied by user
	// Print the sum of all the even numbers the user typed,
	// along with the largest even number typed
	
		System.out.print("How many numbers?");
		Scanner console = new Scanner(System.in);
		int totalN = console.nextInt();
		System.out.print("Enter the string of numbers");

		// String numbers = console.nextLine().toString();
		
		int largestN = -999999;
		int sum = 0;
		int smallestN = console.nextInt();
		/*if(smallestN %2 == 0) {
		*	sum += smallestN;
		*/}
		int greatestEvenNumber = -999999;
		int next = smallestN;
		for (int i = 1; i < totalN; i++) {
			
			if(next %2 == 0) {
				sum += next;
				if(next > greatestEvenNumber) {
					greatestEvenNumber = next;
				}
			}
			if (next > largestN) {
				largestN = next;
			} else if (next < smallestN) {
				smallestN = next;
			}
			next = console.nextInt(); 
		}
		System.out.println("The smallest number supplied is: " + smallestN);
		System.out.println("The largest number supplied is: " + largestN);
		
		System.out.println("The sum of all the even numbers is: " + sum);
		//doesn't consider the first number inputted, how to fix?
		System.out.println("The greatest even number is: " + greatestEvenNumber);
		
		
	}

}


