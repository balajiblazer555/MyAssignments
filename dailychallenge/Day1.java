package dailychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 {

	public static void main(String[] args) {
		String s = "Hello World";

		String[] split = s.split(" ");

		System.out.println(Arrays.toString(split));

		List<String> list = new ArrayList<String>(Arrays.asList(split));

		String word = list.get(list.size() - 1);

		System.out.println("The last word is " + word + " with length " + word.length() + ".");

	}
}