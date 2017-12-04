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
        String operator = threeStrings[1];
        String operand2 = threeStrings[2];
        //String[] mixedN1 = splitOperand(operand1);//can just simplify
        //String[] mixedN2 = splitOperand(operand2);
        int[] mixedN1 = {Integer.parseInt(splitOperand(operand1)[0]),Integer.parseInt(splitOperand(operand1)[1]), Integer.parseInt(splitOperand(operand1)[2])};
        int[] mixedN2 = {Integer.parseInt(splitOperand(operand2)[0]),Integer.parseInt(splitOperand(operand2)[1]),Integer.parseInt(splitOperand(operand2)[2])};
        int[] frac1 = toImproperFrac(mixedN1);
        int[] frac2 = toImproperFrac(mixedN2);
        //if(frac1[1] != frac2[1]) {
        commonDenom(frac1,frac2);
        
        //}
        int[] answer = new int[2];
        if(operator.equals("+")) {
        	answer = addition(frac1,frac2);
        }else if(operator.equals("-")) {
        	frac2[0] *= -1;
        	answer = addition(frac1, frac2);
        }else if(operator.equals("*")) {
        	answer = multiplication(frac1,frac2);
        }else if(operator.equals("/")) {
        	int temp = frac2[0];
        	frac2[0] = frac2[1];
        	frac2[1] = temp;
        	answer = multiplication(frac1,frac2);
        }
        //reduceFrac(answer);
        return answer[0] + "/" + answer[1];
    }

	public static String[] splitOperand(String operand) {
		String whole = "";
		String numerator = "";
		String denominator = "";
		if (operand.indexOf("_") >= 0) {// tests if it is a mixed number
			whole = operand.substring(0, operand.indexOf("_"));
		} else {
			whole = "0";
		}
		
		if (operand.indexOf("/") >= 0) {// tests if there is a fraction
			if (operand.indexOf("_") >= 0) {
				numerator = operand.substring(operand.indexOf("_") + 1, operand.indexOf("/"));

			} else {
				numerator = operand.substring(0, operand.indexOf("/"));
			}
			denominator = operand.substring(operand.indexOf("/") + 1, operand.length());
		} else {
			whole = operand;
			numerator = "0";
			denominator = "1";
		}
		String[] answer = {whole, numerator, denominator};
		return answer;
    }
	public static int[] toImproperFrac(int[] mixedN) {
		//whole: mixedN[0] numerator: mixedN[1] denominator: mixedN[2]
		int topN = mixedN[0]*mixedN[2];
		if(mixedN[0] < 0) {
			mixedN[1] *= -1;
		}
		topN += mixedN[1];
		int[] improperFrac = {topN, mixedN[2]};
		return improperFrac;
	}
	public static void commonDenom(int[] frac1, int[] frac2) {
		frac1[0] *= frac2[1];
		int temp = frac1[1];
		frac1[1] *= frac2[1];
		frac2[0] *= temp;
		frac2[1] *= temp;
	}
	
	public static int[] addition(int[] frac1,int[] frac2) {
		int[] answer = {frac1[0] + frac2[0], frac1[1]};
		return answer;
	}
	public static int[] multiplication(int[] frac1, int[] frac2) {
		int[] answer = {frac1[0] * frac2[0], frac1[1]*frac2[1]};
		return answer;
	}
	public static void reduceFrac(int[] unreducFrac) {
		//first gets gcf
		int greaterN = 0;
		int lesserN = 0;
		if(unreducFrac[0] < unreducFrac[1]) {
			greaterN = unreducFrac[0];
			lesserN = unreducFrac[1];
		}else if(unreducFrac[0] > unreducFrac[1]) {
			greaterN = unreducFrac[1];
			lesserN = unreducFrac[0];
		}
		int gcf = 1;
		while (lesserN != 0) {
			gcf = greaterN % lesserN;
			greaterN = lesserN;
			greaterN = gcf;
		}
		unreducFrac[0] /= gcf;
		unreducFrac[1] /= gcf;
	
	}
        

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
