package week3.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String text1 = "stops";
		String text2 = "potss";
		int count = 0;
		if (text1.length() == text2.length()) {
			System.out.println("Length of the strings are same");
		}
		char[] a1 = text1.toCharArray();
		char[] a2 = text2.toCharArray();

		Arrays.sort(a1);
		Arrays.sort(a2);

		for (int i = 0; i < a1.length; i++) {
			if (a1[i] == a2[i]) {
				count++;
			}
		}
		if (count == a2.length) {
			System.out.println("Both the arrays has same value");

		} else {
			System.out.println("Both the arrays has not same value");
		}
	}
}
