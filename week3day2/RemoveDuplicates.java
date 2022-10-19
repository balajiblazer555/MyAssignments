package week3.day2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String input = "PayPal India";
		String lowerCase = input.toLowerCase();

		char[] array = lowerCase.toCharArray();

		Set<Character> charSet = new LinkedHashSet<Character>();

		Set<Character> dupCharSet = new LinkedHashSet<Character>();

		for (int i = 0; i < input.length(); i++) {
			if (!charSet.add(array[i])) {
				dupCharSet.add(array[i]);
			}
		}

		charSet.removeAll(dupCharSet);
		
		System.out.println(charSet);
		System.out.println((dupCharSet));

		List<Character> list = new ArrayList<Character>(charSet);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)!= ' ') {
				System.out.print(list.get(i));
			}
		}
	}
}