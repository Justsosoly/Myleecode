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

class RotateLeftResult {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    // Write your code here
    List<Integer> result=new ArrayList<Integer>();
    int n=arr.size();
    for(int j=0;j<n;j++)
    {
    	result.add(0);
    }

    for(int i=0;i<n;i++)
    {
      
        if( (i+d)<=(n-1) )  //从d个数开始往后取
    	  result.set(i,arr.get(i+d));
        else
        	if( (i+d)>(n-1) )//超过了数组范围，从第一个开始取
        	{
        		
                  result.set(i,arr.get(i-(n-d))); 	
        		 
        		
        	}	   
    }//end for
    return result;
    }

}

public class RotateLeft {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = RotateLeftResult.rotateLeft(d, arr);
        
        bufferedReader.close();
    }
}
