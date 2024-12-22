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



class BitwiseANDResult {

    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countPairs(List<Integer> arr) {
    // Write your code here
     long result=0;
     int n=arr.size();
    // for(int i=0;i<n;i++)
     //System.out.print(arr.get(i)+" ");
     for(int i=0;i<n-1;i++)
     {
         Integer x=arr.get(i);
          for(int j=i+1;j<n;j++)
          {
              Integer y=arr.get(j);
            //  System.out.println("x&y="+(x&y));
             long temp=x&y;
              if(temp==0) continue;
              else if( (temp)%2==0||(temp)==1 )
              {
               result++;    
              }
              
              
          }
         
     }
    
     return result;
    }

}

public class BitwiseAND {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = BitwiseANDResult.countPairs(arr);


        bufferedReader.close();
    }
}
