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

class DrawingBookResult {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
    // Write your code here
    	int result=0;
    	
    	int k=n/2; //共几页
    	
    	if(p<=k)
    	{
    		result=p/2;
    		
    	}
    	else 
    		if(p>k)
    	{
    			if(n%2!=0)
    		 {
    			 if(p==(n-1)||p==n)
    			    return 0;
    		  
    		 }
    		 else
    			 if(n%2==0) 
    			 {	 
    			 if(p==n)
    			     return 0;
    			 }
    			 result=k-p/2;
    	}
    	
    	return result;

    }

}

public class DrawingBook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = DrawingBookResult.pageCount(n, p);

        bufferedReader.close();
    }
}
