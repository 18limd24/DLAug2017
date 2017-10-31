/*Darren Lim
 * 10/31/17
 * This is our arrays lab
 */
public class ArraysLab3 {
	public static void main(String[] args) {
		
	}
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] sum = new int [arr1.length];
		for(int i = 0; i < arr1.length; i++){
			sum[i] = arr1[i] + arr2[i];
		}
		return sum;
	}
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


}
