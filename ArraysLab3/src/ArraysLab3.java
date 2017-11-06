import java.util.Arrays;

/*Darren Lim
 * 10/31/17
 * This is our arrays lab
 */
public class ArraysLab3 {
	//1
	public static int[] sum(int[] arr1, int[] arr2) {
		
		int[] sum = new int [arr1.length];
		for(int i = 0; i < arr1.length; i++){
			sum[i] = arr1[i] + arr2[i];
		}
		return sum;
	}
	//2
	public static int[] append(int[] arr, int num) {
		
		/*Plan: 	initialize an int array append and set length equal to length of arr plus 1
		fill append with elements from arr using a for loop
		fill the last element with num
		return append
		*/
		int[] append = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			append[i] = arr[i];
		}
		append[append.length - 1] = num;
		return append;
	}
	//3
	public static int[] remove(int[] arr, int idx) {
		
		int[] remove = new int[arr.length -1];
		for(int i = 0; i< idx; i++) {
			remove[i] = arr[i];
		}
		for(int i= idx; i < remove.length; i++) {
			remove[i] = arr[i+1];
		}
		return remove;
	}
	

		/*Plan:	initialize an array called remove with length of arr.length - 1
		use a for loop to fill remove with elements from arr from 0 to idx - 1 (assuming idx is not 0)
		then use another for loop
		for(int i = idk; i < remove.length; i++)
		fill with the elements from arr of index + 1
		return remove
		*/
	//4
	public static int sumEven(int[] arr) {
		/*Plan:	initialize sum
		use a for loop to traverse every two elements (int i = 0; i < arr.length; i +=2)
		add to sum (sum += arr[i];
		return sum
		*/
		int sum = 0;
		for(int i = 0; i < arr.length; i += 2) {
			sum += arr[i];
		}
		return sum;
		
	}
	//5
	public static void rotateRight(int[] arr) {
		/*Plan:	store the int length - 1 in a temp variable
			use a for loop 
				for(i starts at the length - 2 and decrements all the way to filling index 1)
			then put temp variable back into element 0
			*/
		int temp = arr[arr.length - 1];
		for(int i = arr.length - 2; i > 0; i--) {
			arr[i] = arr[i -1];
		}
		arr[0] = temp;
		}
	/*6) Write a method main that will 
			Contain
				integer arrays a1, a2, sumArr, appendArr, removeArr
				int variables appendNum, removeIdx, sumOfEvens
			Carry out the following actions
				Declare array a1 containing the values (5, 10, 15, 20, 25, 30, 35, 40) and array a2 containing the values (7, 14, 21, 28, 35, 42, 49, 56)
				Form sumArr by calling the sum method with a1 and a2 as inputs
				Declare int appendNum and set it to 200.
				Form appendArr by calling the append method with a1 and appendNum as inputs
				Declare int removeIdx and set it to 5.
				Form removeArr by calling remove with a2 and removeIdx
				Form sumOfEvens by calling sumEven with appendArr as the input
				Call rotateRight with a1 as the input
			On their own lines print out (use Arrays.toString to transform arrays into a printable strings) :
				sumArr
				appendArr
				removeArr
				sumOfEvens (an int you don’t need Arrays.toString)
				a1
	 */
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1,a2);
		int appendNum = 200;
		int[] appendArr = append(a1,appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2,removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		
		System.out.println("sumArr: " + Arrays.toString(sumArr));
		System.out.println("appendArr: " + Arrays.toString(appendArr));
		System.out.println("removeArr: " + Arrays.toString(removeArr));
		System.out.println("sumOfEvens: " + sumOfEvens);
		System.out.println("a1: " + Arrays.toString(a1));
	}


}
