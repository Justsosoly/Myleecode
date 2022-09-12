package Mytest;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FindMedian {
	
	
	
	public static int findMedian(List<Integer> arr) {
		

	int median=0;
	int n=arr.size();
	for(int i=0;i<n;i++)
	for(int j=i+1;j<n;j++)
	{
	int x=arr.get(i);
	int y=arr.get(j);
	if(x>y)
	{
	int temp=y;
	y=x;
	x=temp;
	}
	}
	
	
	median=arr.get(n/2);
	
	System.out.println("the median is "+median);
	return median;

}
	
	   public static void main(String[] args) throws IOException {
	        
		   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		 
		        // String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		        // int n = Integer.parseInt(firstMultipleInput[0]);


		         List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
		             .map(Integer::parseInt)
		             .collect(toList());

		          FindMedian.findMedian(ar);

		   

		         bufferedReader.close();
		
	        
	        
	    }
	
}