//Darren Lim
//10/10/17
//Part 5 of calculate
//Quadratic will be responsible for all calculations and must contain quadrDescriber
public class Quadratic {
	public static double round2(double a) {
		double b = (a * 1000) % 10;
		if (b <= 4) {
			return (a * 1000 - b) / 1000;
		} else {
			return (a * 1000 - b + 10) / 1000;
		}

	}
	public static double sqrt(double n) {
		// how will I get the square root? loop?
		// square root of N is about= ½(N/A + A)
		// N is number to square root and then A is educated guess
		// repeatedly replace educated guess
		// return root
		// n >=0
		if(n<0) {
			throw new IllegalArgumentException();
		}else {
		double root = 0;
		double A = n / 2;// our educated guess
		while (root != (n / A + A) / 2) {// because we WANT the root to equal that
			root = (n / A + A) / 2;// calculates
			A = root;
		}
		double answer = round2(root);
		return answer;
	}
	}
	
	public static String quadForm(double a, double b, double c) {
		String answer = "";
		if(discriminant(a,b,c) < 0) {
			answer += "no real roots";
		}else if (discriminant(a,b,c) == 0) {
			answer += round2(-b/(2*a));
		}else {
			double answer1 = ((-b + sqrt(discriminant(a,b,c)))/(2*a));
			double answer2 = ((-b - sqrt(discriminant(a,b,c)))/(2*a));
			answer += round2(answer1) + " and " + round2(answer2);
		}
		return answer;
		}
	public static double discriminant(double a, double b, double c) {
		double discriminant = b * b - 4 * a * c;
		return discriminant;
	}
	public static String quadrDescriber(double a, double b, double c) {
		System.out.println(a + "x^2 + " + b + "x + " + c);
		if(a == 0) {
			return "Not a quadratic equation";
		}
		//Describe orientation
		String orientation = "";
		if(a > 0) {
			orientation = "Up";
		}else {
			orientation = "Down";
		}
		//Describe Axis of symmetry
		double aos;
		
		//Describe Vertex
		
		//Describe x-intercept
		String roots = quadForm(a,b,c);
		
		//Describe y-intercept
		/*System.out.print("Opens: ");
		if(a>0) {
			System.out.println("Up");
		}else {//if(a<0)
			System.out.println("Down");
		}*/
	}

}
