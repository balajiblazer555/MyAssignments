package week3.day1;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String text="We learn java basics as part of java sessions in java week1 java";
		
		// b) Initialize an integer variable as count	
		int count=0;
		String replace = null;
		String a = "";
		
		//c) Split the String into array and 
		String[] split = text.split(" ");
		System.out.println(Arrays.toString(split));
		
		//iterate over it 
		for(int i=0; i<=split.length-1; i++) {
			
			// d) Initialize another loop to check whether the word is there in the array
			for(int j=i+1; j<=split.length-1; j++) {
				
			// e) if it is available then increase and count by 1. 
			if(split[i].equals(split[j])){
				
				//System.out.println(split[i]);
				count++;
				 a=split[i];
	    }	
		}
		}
		
		//if the count > 1 then replace the word as "" 
		if(count>1) {
		replace = text.replace(a, "");
	}
		System.out.println(replace);
	}
	
}