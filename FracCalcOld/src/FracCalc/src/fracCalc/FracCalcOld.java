/*Darren Lim
 * 11/7/17
 * FracCalc
 */
package FracCalc.src.fracCalc;
import java.util.*;
public class FracCalcOld {


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
        //split the operands into whole, numerator, and denominator and then parse to integers
        int[] mixedN1 = {Integer.parseInt(splitOperand(operand1)[0]),Integer.parseInt(splitOperand(operand1)[1]), Integer.parseInt(splitOperand(operand1)[2])};
        int[] mixedN2 = {Integer.parseInt(splitOperand(operand2)[0]),Integer.parseInt(splitOperand(operand2)[1]),Integer.parseInt(splitOperand(operand2)[2])};
        //store as improper fractions to do calculations
        int[] frac1 = toImproperFrac(mixedN1);
        int[] frac2 = toImproperFrac(mixedN2);
        //change fracs to common denominator for calculations
        commonDenom(frac1,frac2);
        //calculations: one to do addition/subtraction, one for multiplication/division
        int[] answer = new int[2];
        if(operator.equals("+")) {
        	answer = addition(frac1,frac2);
        }else if(operator.equals("-")) {//subtraction is negative addition
        	frac2[0] *= -1;
        	answer = addition(frac1, frac2);
        }else if(operator.equals("*")) {
        	answer = multiplication(frac1,frac2);
        }else if(operator.equals("/")) {//division is multiplying by reciprocal
        	int temp = frac2[0];
        	frac2[0] = frac2[1];
        	frac2[1] = temp;
        	answer = multiplication(frac1,frac2);
        }
        //reduce answer
       int[] reducedAnswer = reduceFrac(answer);
        
       if(reducedAnswer[0] == 0 && reducedAnswer[1] == 0) {//if equivalent to 0
    	   return "0";
       }else if(reducedAnswer[0] == 0 && reducedAnswer[1] != 0) {//if whole is 0 then only fraction
    	   if(reducedAnswer[2] < 0) {//if denominator is negative, return absValue and multiply numerator by -1
    		   return -reducedAnswer[1] + "/" + Math.abs(reducedAnswer[2]);
    	   }else {
    		   return reducedAnswer[1] + "/" + reducedAnswer[2];
    	   }
       }else if(reducedAnswer[0] != 0 && reducedAnswer[1] == 0) {//if only whole number
    	   return "" + reducedAnswer[0];
       }else {//if the whole thing
    	   return reducedAnswer[0] + "_" + Math.abs(reducedAnswer[1]) + "/" + Math.abs(reducedAnswer[2]);
       }
    }
	public static int[] reduceFrac(int[] unreducFrac) {
		//first gets gcf
		
		int[] mixedFrac = toMixedN(unreducFrac);
		int gcf = gcf(Math.abs(mixedFrac[1]), Math.abs(mixedFrac[2]));
		mixedFrac[1] /= gcf;
		mixedFrac[2] /= gcf;
		return mixedFrac;
		
		
    // TODO: Fill in the space below with any helper methods that you think you will need	
	}

	public static String[] splitOperand(String operand) {
		//splitOperand will take a string and use split to split into the whole, numerator, and denominator
		//using substrings
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
		//multiply whole by denominator and add to the numerator
		//2 index
		topN += mixedN[1];
		int[] improperFrac = {topN, mixedN[2]};
		return improperFrac;
	}
	public static void commonDenom(int[] frac1, int[] frac2) {
		//multiplies fraction by others denominator
		frac1[0] *= frac2[1];
		int temp = frac1[1];
		frac1[1] *= frac2[1];
		frac2[0] *= temp;
		frac2[1] *= temp;
	}
	//addition and multiplication methods
	public static int[] addition(int[] frac1,int[] frac2) {
		int[] answer = {frac1[0] + frac2[0], frac1[1]};
		return answer;
	}
	public static int[] multiplication(int[] frac1, int[] frac2) {
		int[] answer = {frac1[0] * frac2[0], frac1[1]*frac2[1]};
		return answer;
	}
	public static int gcf(int greaterN, int lesserN) {
		//from calculate library
		int a = greaterN;
		int b = lesserN;
		int result;
		while (b != 0) {
			result = a % b;
			a = b;
			b = result;
		}
		return a;//a will be the gcf
	}

	public static int[] toMixedN(int[] improperAnswer) {
		int[] mixedAnswer = new int[3];
		//whole, num, denom
		mixedAnswer[0] = improperAnswer[0]/improperAnswer[1];
		mixedAnswer[1] = improperAnswer[0]%improperAnswer[1];
		mixedAnswer[2] = improperAnswer[1];
		return mixedAnswer;
	}
}