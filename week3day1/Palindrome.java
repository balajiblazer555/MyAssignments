package week3.day1;

public class Palindrome {

	public static void main(String[] args) {

		String input = "madam";
		String rev = "";
		char[] array = input.toCharArray();

		for (int i = input.length() - 1; i >= 0; i--) {
			rev = rev + array[i];
		}
		System.out.println(rev);
		if (rev.equals(input)) {
			System.out.println("Given input is a palindrome");
		} else {
			System.out.println("Given input is not a palindrome");
		}
	}
}
