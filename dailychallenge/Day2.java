package dailychallenge;

public class Day2 {
	
	
	public static void main(String[] args) {
		int x=196;
		int value=0;
		
		for( int i=1; i*i<=x; i++) {
		    value = i; 
		}
		System.out.println(value);	
	}
}