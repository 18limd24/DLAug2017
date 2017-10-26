import java.util.Arrays;

/*Darren Lim
 * 10/24/17
 * Split project, will act on  a string, splits and returns an array
 */
public class Split {

	public static void main(String[] args) {
		// String.split();
		// It's a method that acts on a string, <StringName>.split(<String sp>);
		// Where sp is the string where the string splits
		// And it returns an array
		System.out.println(Arrays.toString("I like apples!".split(" ")));
		// it will split at spaces and return an array of ["I","like"," red apples!"]
		System.out.println(Arrays.toString("I really like really red apples".split("really")));
		// it will split at the word "really" and return an array of ["I "," like ","
		// apples!"]

		// play around with String.split! what happens if you "I reallyreally like
		// apples".split("really") ?
		System.out.println(Arrays.toString("I reallyreally like apples".split("really")));
		

		// Your task:
		/*
		 * Write a method that take in a string like
		 * "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a
		 * sandwich use String.split to split up the sandwich by the word "bread" and
		 * return what's in the middle of the sandwich and ignores what's on the outside
		 * What if it's a fancy sandwich with multiple pieces of bread?
		 */
		public static String[] sandwichSplit(String sandwich) {
			sandwich.split("bread");
		}
		System.out.println(Arrays.toString(sandwichSplit("applespineapplesbreadlettustomatobaconmayohambreadcheese")));

		// Your task pt 2:
		/*
		 * Write a method that take in a string like
		 * "apples pineapples bread lettus tomato bacon mayo ham bread cheese"
		 * describing a sandwich use String.split to split up the sandwich at the
		 * spaces, " ", and return what's in the middle of the sandwich and ignores
		 * what's on the outside Again, what if it's a fancy sandwich with multiple
		 * pieces of bread?
		 */

	}

}
