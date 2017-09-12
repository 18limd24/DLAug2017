//Darren Lim
//September 5, 2017
//This is our library that will contain various
//mathematical methods to be called upon.

public class Calculate {

	/*
	 * This method takes an integer and returns its square.
	 * 
	 */
	public static int square(int operand) {
		int squared = operand * operand;
		return squared;
	}

	/*
	 * This method takes and integer and returns its cube
	 * 
	 */
	public static int cube(int operand) {
		int cubed= operand * operand * operand;
		return cubed;
	}

	/*
	 * This method accepts two doubles and returns the average as a double
	 * 
	 */
	public static double average(double operand1, double operand2) {
		double mean= (operand1 + operand2)/2;
		return mean;
	}
	/*This method does the same as average but with three doubles
	 * 
	 */
	public static double average(double operand1, double operand2, double operand3) {
		double mean= (operand1 + operand2 + operand3)/3;
		return mean;
	}
	/*This method accepts a double and returns a double
	 * Converts an angle in radians into a measure in degrees.
	 */
	public static double toDegrees(double radians) {
		double degrees= radians*180/3.14159;
		return degrees;
	}
	/*This method converts an angle measure from degrees
	 * to radians.
	 * Accepts a double and returns a double
	 */
	public static double toRadians(double degrees) {
		double radians= degrees * 3.14159/180;
		return radians;
	}
	
	/*This method will provide coefficients of a quadratic equation
	 *  in standard form (a,b,c)
	 *  and returns the value of the discriminant
	 */
	public static double discriminant(double a, double b, double c) {
		double discriminant= b * b - 4 * a * c;
		return discriminant;
	}
	/*This method will convert mixed numbers into an improper fraction
	 * from three integers to a string
	 */
	public static String toImproperFrac(int a, int b, int c) {
		return a*c+b + "/" + c;
	}
	/*Converts improper fraction into a mixed number
	 * two integers to a string
	 */
	public static String toMixedNumber(int a, int b) {
		return a/b +" " + a%b + "/" + b;
		
	}
	/*Converts (ax + b)(cx + d) into a quadratic equation of ax^2 + bx +c
	 * The method accepts four integers and returns a string
	 */
	public static String foil(int a, int b, int c, int d) {
		return a*c + "x^2" + "+" + (a*d + b*c) +"x" + b*d;
	}
	/*determines whether or not one integer is evenly divisible by another
	 * accepts two integers and returns a boolean
	 */
	public static boolean isDivisibileBy(int a, int b) {
		if(a%b==0) {
			return true;
		}else {
			return false;
		}
	}
	/*This method will return the absolute value of the number passed.
	 * accepts a double and returns a double
	 */
	public static double absValue(double a) {
		if(a>0) {
			return a;
		}else if(a==0) {
			return 0.;
		}else {//why can't I use else if
			return -a;
		}
	}
	
	/*This method returns the larger of the values passed
	 * accepts 2 double and returns a double
	 */
	public static double max(double a, double b) {
		if(a>b) {
			return a;
		}else {//why can't i use else if
			return b;
		}//what if a==b
	}
	/*Overload max
	 * accepts three doubles and returns a double
	 */
	public static double max(double a, double b, double c) {
		if(a>b && a>c) {
				return a;
		}else if(b>a && b >c) {
				return b;
			}
		}else if(c>a && c>b) {
				return c;
		}
	}
	/*This method will round a double to two decimal places
	 * returns a double
	 */
	public static double round2(double a) {
		double b = (a*1000)%10;
		return (a*1000 - b)/1000;
	}
}
