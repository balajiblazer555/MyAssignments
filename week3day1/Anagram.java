package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// Declare a String text1 = "stops";
		String text1 = "stops";

		// Declare another String text2 ="potss";
		String text2 = "potss";

		// a) Check length of the strings are same then (Use A Condition)
		int a = text1.length();
		int b = text2.length();
		if (a == b) {
			System.out.println("Length of both strings are same");
		} else {
			System.out.println("Length of both strings are not same");
		}

		// b) Convert both Strings in to characters
		char[] char1 = text1.toCharArray();
		char[] char2 = text2.toCharArray();

		// c) Sort Both the arrays
		Arrays.sort(char1);// [s,t,o,p,s]
		Arrays.sort(char2);// [s,t,o,p,s]
		int count = 0;

		// d) Check both the arrays has same value

		for (int i = 0; i < char1.length; i++) {

			if (char1[i] != char2[i]) {
				count++;
				break;
			}

		}
		if (count > 0) {
			System.out.println("both are not same");

		} else {
			System.out.println("both arrays are same");
		}
	}
}
