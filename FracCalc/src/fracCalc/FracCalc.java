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
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input){ 
        // TODO: Implement this function to produce the solution to the input
        String[] threeStrings = input.split(" ");//stores the input into an array
        String operand1 = threeStrings[0];//easier to read
        String operator = threeStrings[1];
        String operand2 = threeStrings[2];
        
        Fraction frac1 = new Fraction(operand1);
        Fraction frac2 = new Fraction(operand2);
        frac1.toImproper();
        frac2.toImproper();
        
        Fraction answer = new Fraction();
        if(operator.equals("+")) {
        	answer = frac1.add(frac2);
        }else if(operator.equals("-")) {//subtraction is negative addition
        	frac2.setNumerator(frac2.getNumerator() * -1);
        	answer = frac1.add(frac2);
        }else if(operator.equals("*")) {
        	answer = frac1.multiply(frac2);
        }else if(operator.equals("/")) {//division is multiplying by reciprocal
        	int temp = frac2.getNumerator();
        	frac2.setNumerator(frac2.getDenominator());
        	frac2.setDenominator(temp);
        	answer = frac1.multiply(frac2);
        }
        answer.simplify();
        
        return "" + answer;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
