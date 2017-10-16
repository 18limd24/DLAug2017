//Darren Lim
//10/10/17
//Part 5 of calculate
//Quadratic will be responsible for all calculations and must contain quadrDescriber
public class Quadratic {
	public static String quadrDescriber(double a, double b, double c) {
		System.out.println(a + "x^2 + " + b + "x + " + c);
		
		//Describe orientation
		System.out.print("Opens: ");
		if(a>0) {
			System.out.println("Up");
		}else {//if(a<0)
			System.out.print("Down");
		}
	}

}
