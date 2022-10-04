package week1.day2;

public class FibonacciSeries {


	 

	public static void main(String[] args) {

		int range = 10;
		int firstNum = 0;
		int secNum=1;
		int sum=0;
		
		System.out.println("the fibonacci series for the input range: "+range);
		System.out.print(firstNum+","+secNum+",");
		
		for(int i=1; i<=range-2; i++) {
			sum = firstNum+secNum;
			firstNum=secNum;
			secNum= sum;
			System.out.print(sum+",");	
		}

	}
	
}
