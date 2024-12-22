package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class LargestRectangleResult {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */
/*
    public static long largestRectangle(List<Integer> h) {
    // Write your code here
    	long result=0;
    	
    	Integer area[]=new Integer[h.size()];
    	
    	for(int i=0;i<h.size();i++)
    	{
    		Integer max;
    		area[i]=0;
    		for(int j=0;j<h.size();j++)
    		{
    			int start=0;
    	    	int end=0;
    			if(i<=j)
    			{
    				start=i;
    				end=j;
    			}
    			else
    			{
    				start=j;
    			    end=i;
    			}   
    			
    			List<Integer> subh=h.subList(start, end+1);
    			int height=Collections.min(subh);
    			
    			max=Math.abs(j-i+1)*height;
    					
    			if(max>area[i])	
    				area[i]=max;
    			
    		}
    		
    	}
    	
    	result=(long)Collections.max(Arrays.asList(area));
    	

    	
    	return result;

    }
*/
	
	public static long largestRectangle(List<Integer> h) {
		long result=0;
		
		
		for(int i=0;i<h.size();i++)
		{
			int square=0;
			int width=0;
			for(int j=i;j<h.size();j++)
			{
				if(h.get(i)<=h.get(j))
					width++;
				else
					break;
			}
			
			for(int j=i-1;j>=0;j--)
			{
				if(h.get(i)<=h.get(j))
					width++;
				else
					 break;
			}
			
			square=width*h.get(i);
			if(square>result)
				result=square;
			
		}
		
		
		return result;
		
	}
	
	
}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long result = LargestRectangleResult.largestRectangle(h);


        bufferedReader.close();
    }
}
