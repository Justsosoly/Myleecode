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

class CoinChangeResult {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     *  n=3
     *  c=1,2,3,8
     */

    public static long getWays(int n, List<Long> c) {
    // Write your code here

    	long dp[]=new long [n+1];//n ways
    	dp[0]=1;
    	
       for(int i=0;i<c.size();i++)
    	   for(int j=0;j<dp.length;j++)
    	   {
    		   if(c.get(i)<=j)
    		   {
    			   dp[j]=dp[j]+dp[(int)(j- c.get(i))];
    		   }
    		   
    	   }
    		
    
    	
    	return dp[n];
    }

}

public class CoinChange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = CoinChangeResult.getWays(n, c);


        bufferedReader.close();
    }
}
