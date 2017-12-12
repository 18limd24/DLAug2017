/*Darren Lim
 * 12/11/17
 * Fraction class to make fracCalc w objects
 */
package fracCalc;

public class Fraction {
	private int whole;
	private int numerator;
	private int denominator;
	//private String wholeAsAString;
	//private String numAsAString;
	//private String denomAsAString;
	public Fraction(String operand) {
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
		this.whole = toInt(answer[0]);
		this.numerator = toInt(answer[1]);
		this.denominator = toInt(answer[2]);
	}
	public void toMixedNumber() {
		//updates whole and numerator
		this.whole = this.numerator / this.denominator;
		this.numerator = this.whole % this.denominator;
		
	}
	public void toImproper() {
		//update whole to 0
		//update numerator
		this.numerator = (this.whole * this.denominator) + this.numerator;
		
	}
	private int toInt(String str) {
		//convert string to int
		return Integer.parseInt(str);
	}
	public void simplify() {
		
	}
	public String toString() {
		//creates string to be printed out
	}

}
