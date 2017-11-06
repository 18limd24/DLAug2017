import java.util.Arrays;

/*Darren Lim
 * 11/2/17
 * our array mini lab
 */
public class LotsOfCopies {
	public static void main(String[] args) {
		int num =7;
		String strMain = "APCS";
		int[] arrMain = {1,2,3,4,5};
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
	}
	public static void changMe(int x, String str, int[] arr) {
		x=8;
		str="10";
		for(int i= 0; i < arr.length; i++) {
			arr[i]++;
		}
	
	//a = startValue
	//b = a
	//a = newValue
	//x =8; x is our first a
	int b = x;
	x = 100;
	System.out.println("b: " + b);
	
	//str = "10";
	String bStr = str;
	str = "Hi There!";
	System.out.println("bStr: " + bStr);
	//str = "10";
	
	//I expect bArr will be 1,2,3,4,5 because arrays change
	int[] bArr = arr;
	for(int i = 0;i < arr.length; i++ ) {
		arr[i] = i;
	}
	System.out.println("bArr: " + Arrays.toString(bArr));
	}
}
