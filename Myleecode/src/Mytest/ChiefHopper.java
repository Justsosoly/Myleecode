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

class ChiefHopperResult {

    /*
     * Complete the 'chiefHopper' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int chiefHopper(List<Integer> arr) {
    // Write your code here
    	int energy[]=new int[arr.size()+1];
    	
    
    	for(int i=arr.size()-1;i>=0;i--)
    	{
    		energy[i]=(int )Math.ceil((double)(energy[i+1]+arr.get(i))/2);//add (double) to get the bigger integer
    	}
    	
    	return energy[0];
    }

}

public class ChiefHopper {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ChiefHopperResult.chiefHopper(arr);


        bufferedReader.close();
    }
}
