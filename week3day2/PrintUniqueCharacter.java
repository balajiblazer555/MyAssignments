package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		String name = "babua";

		System.out.println("Original String : " + name);

		char[] arr = name.toCharArray();

		Set<Character> newset = new HashSet<Character>();
		char dup = 0;
		for (int i = 0; i < arr.length; i++) {

			if (!newset.add(arr[i])) {
				dup = arr[i];
				System.out.println("Duplicate character is :" + arr[i]);
				newset.remove(dup);
			}
		}
		System.out.println("Unique Characters are : " + newset);
	}
}