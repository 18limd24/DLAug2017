/*Darren Lim
 * 11/7/17
 * FracCalc
 */
package fracCalc;
import java.util.*;
public class FracCalc {


    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	System.out.println("Enter calculations");
    	Scanner console = new Scanner(System.in);
    	//String firstInput = console.nextLine();
    	//System.out.println(produceAnswer(firstInput));
		String input = console.nextLine();
    	
    	while(!input.equals("quit")) {

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
        String[] threeStrings = input.split(" ");
        String operand1 = threeStrings[0];
        String operand2 = threeStrings[2];
        splitOperand(operand1);
        return splitOperand(operand2);
    }

	public static String splitOperand(String operand) {
		String whole = "";
		String numerator = "";
		String denominator = "";
		if (operand.indexOf("_") >= 0) {// tests if it is a mixed number
			whole = "whole:" + operand.substring(0, operand.indexOf("_")) + " ";
		} else {
			whole = "whole:0 ";
		}
		
		if (operand.indexOf("/") >= 0) {// tests if there is a fraction
			if (operand.indexOf("_") >= 0) {
				numerator = "numerator:" + operand.substring(operand.indexOf("_") + 1, operand.indexOf("/")) + " ";

			} else {
				numerator = "numerator:" + operand.substring(0, operand.indexOf("/")) + " ";
			}
			denominator = "denominator:" + operand.substring(operand.indexOf("/") + 1, operand.length());
		} else {
			whole = "whole:" + operand;
			numerator = " numerator:0 ";
			denominator = "denominator:1";
		}
		String answer = whole + numerator + denominator;
		return answer;
    }
        

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
