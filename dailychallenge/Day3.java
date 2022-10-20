package dailychallenge;

public class Day3 {

	public static void main(String[] args) {

		String s = "A man, a plan, a canal: Panama";
		String lowerCase = s.toLowerCase();
		String replaceAll = lowerCase.replaceAll("[^a-zA-Z0-9]", "");
		String reverse = "";

		for (int i = replaceAll.length() - 1; i >= 0; i--) {
			reverse += replaceAll.charAt(i);
		}
		boolean result = replaceAll.contains(reverse);

		if (result == true) {
			System.out.println(result);
		} else {
			System.out.println(false);
		}
	}
}