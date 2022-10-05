package week1.day2;

import java.util.Arrays;

public class SmallestNumber {

	public static void main(String[] args) {
		//Find the Second smallest number in the array {23,45,67,32,89,22 }
		
		int[] arr={23,45,67,32,89,22 };
		Arrays.sort(arr);
		System.out.println(arr[1]);
	}

}
