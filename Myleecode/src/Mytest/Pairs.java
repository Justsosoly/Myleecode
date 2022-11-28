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



class PairsResult {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int pairs(int k, List<Integer> arr) {
    // Write your code here 
    	//第一次时间没通过，加排序并得到结果后跳出循环
    	
    	int n=arr.size();
    	int result=0;
    	
    	Collections.sort(arr);
    	
    	for(int i=0;i<arr.size();i++)
    	{
    		int x=arr.get(i);
    		
    		for(int j=i+1;j<arr.size();j++)
    		{
    			int y=arr.get(j);
    			if(Math.abs(x-y)==k)
    			{
    				result++;
    				break;
    			}
    				
    		}
    		
    	}
    	
    	
    	
        return result;
    }

}

public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = PairsResult.pairs(k, arr);

        bufferedReader.close();
    }
}
