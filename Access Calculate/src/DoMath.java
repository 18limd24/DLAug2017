/* Darren Lim
 * September 5, 2017
 * This is the runner class for my Calculate Library methods
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(5, 7));
		System.out.println(Calculate.average(5,7,9));
		System.out.println(Calculate.toDegrees(2*3.14149));
		System.out.println(Calculate.toRadians(360));
		System.out.println(Calculate.discriminant(1,2,3));
		System.out.println(Calculate.toImproperFrac(3,1,2));
		System.out.println(Calculate.toMixedNumber(7,2));
		System.out.println(Calculate.foil(2,3,6, -7));
		System.out.println(Calculate.isDivisibileBy(4,2));

	}

}