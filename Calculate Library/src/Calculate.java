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
	public static String toImproperFrac(int operand1, int operand2, int operand3) {
		
	}
}
