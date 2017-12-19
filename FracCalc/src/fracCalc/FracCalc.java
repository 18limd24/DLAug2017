/*Darren Lim
 * 11/7/17
 * FracCalc
 */
package fracCalc;
import java.util.*;
public class FracCalc {


    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	System.out.println("Enter calculations"); //Asks user for calculations
    	@SuppressWarnings("resource")
		Scanner console = new Scanner(System.in);
    	//String firstInput = console.nextLine();
    	//System.out.println(produceAnswer(firstInput));
		String input = console.nextLine();
    	
    	while(!input.equals("quit")) {//continues to run until user enters quit

    		System.out.println(produceAnswer(input));
    		System.out.println("Type 'quit' to exit, otherwise, enter new calculations");
    		input = console.nextLine();
    		
    	}

    }

    public static String produceAnswer(String input){ 
        String[] inputStrings = input.split(" ");//stores the input into an array
        String operand1 = inputStrings[0];//easier to read
        
        Fraction frac1 = new Fraction(operand1);//Because I will use "frac1" as first operand but will also use
        //to store answer for multiple operands
        Fraction frac2;
        Fraction answer = new Fraction();

		for (int i = 2; i < inputStrings.length; i += 2) {
			frac2 = new Fraction(inputStrings[i]);//Because this way the frac2 starts at second operand
												//but when updates will store next operand
			frac1.toImproper();
			frac2.toImproper();

			if (inputStrings[i -1].equals("+")) {
				answer = frac1.add(frac2);
			} else if (inputStrings[i -1].equals("-")) {// subtraction is negative addition
				frac2.setNumerator(frac2.getNumerator() * -1);
				answer = frac1.add(frac2);
			} else if (inputStrings[i -1].equals("*")) {
				answer = frac1.multiply(frac2);
			} else if (inputStrings[i -1].equals("/")) {// division is multiplying by reciprocal
				int temp = frac2.getNumerator();
				frac2.setNumerator(frac2.getDenominator());
				frac2.setDenominator(temp);
				answer = frac1.multiply(frac2);
			}
			answer.simplify();
			frac1 = new Fraction(answer);
		}
		return "" + answer;
    }

    
}
