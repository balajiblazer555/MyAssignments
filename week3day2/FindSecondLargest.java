package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {
	
	public static void main(String[] args) {
		

			int[] data = {3,2,11,4,6,7,2,3,3,6,7};	
			
			Set<Integer> empty=new TreeSet<Integer>();
			
		 for(int i=0;i<data.length;i++) {	
			 empty.add(data[i]);		 
		 }
		 
     	List<Integer> values=new ArrayList<Integer>(empty);
     	
     	System.out.println(values);
     	
     	int size = values.size();
     	
     	System.out.println("Second last element from List :"+values.get(size-2));
}
}      

