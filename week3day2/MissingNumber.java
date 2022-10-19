package week3.day2;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		int[] number = { 5, 2, 8, 4, 5, 1, 8, 7, 3, 6, 10, 5, 7, 12 };

		Set<Integer> a = new TreeSet<Integer>();
		for (int i = 0; i < number.length; i++) {
			a.add(number[i]);
		}
		System.out.println("The set is in the ascending order : " + a);

		for (int j = 1; j < Collections.max(a); j++) {

			if (!a.contains(j)) {
				System.out.println("The Missing number is : " + (j));
			}
		}
	}
}