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
    	
    	while(!console.nextLine().equals("quit")) {

    		System.out.println(produceAnswer(input));
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
        String operand2 = threeStrings[2];
        //need operand 2
        
        String[] splitMixedN = operand2.split("_");//splits up the whole number and the fraction
        if(splitMixedN.length == 0) {
        	String[] splitFrac = splitMixedN[0].split("/");
        			if(splitFrac.length == 0) {
        				String whole = "whole:" + splitMixedN[0] + " ";
        			}else {
        				String whole = "whole:0 ";
        				String numerator = "numerator:" + splitFrac[0] + " ";
        				String denominator = "denominator " + splitFrac[2] + " ";
        			}
        }
        if(splitMixedN.length > 1) {
        	String frac = splitMixedN[1];
        	String[] splitFrac = frac.split("/");
        	String numerator = "numerator:" + splitFrac[0] + " ";
        	String denominator ="denominator:" + splitFrac[1] + "";	
        	return whole + numerator + denominator;
        }
        return whole + "numerator:0 " + "denominator:1";
        
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
