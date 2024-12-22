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

class MaxMinResult {

    /*
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static int maxMin(int k, List<Integer> arr) {
    // Write your code here
    int result=0;
    Collections.sort(arr);
    int n=arr.size();
    int x=0; 
    Integer min=Integer.MAX_VALUE;
    
    while(x<n/k)
    {
      
      
      if((x*k)<n)
      {
    	  int p=arr.get((x+1)*k-1);
    	  int q=arr.get(x*k);
    	  
      Integer temp= p- q;
       
       if(  temp<min   )
        
        min=temp;
      }
      else
      {
         
          Integer temp= arr.get(n)- arr.get(x*k);
       
       if(  temp<min   )
    
          min=temp;
      }

        x++;
    }
    
    
    result=Integer.valueOf(min);
    
    System.out.println("result is :"+result);
    return result;
    }

}

public class MaxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = MaxMinResult.maxMin(k, arr);


        bufferedReader.close();
    }
}
