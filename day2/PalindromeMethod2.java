package week1.day2;

public class PalindromeMethod2 {


		public static void main(String[] args) {
			
			int num=34343;
			String s=Integer.toString(num);
			int temp=num;
			int reverse=0;
			
			for(int i=1;i<=s.length();i++) {
				
				reverse=reverse*10 + temp%10;
				temp = temp/10;
				
				}
			if(reverse==num) {
				System.out.println(num+" is a palindrome number");
			}
			else {
				System.out.println(num+" is not a palindrome number");
			}
			}	
			}