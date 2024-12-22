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

class BubbleSortResult {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
    // Write your code here
        int n=a.size();
        int swap=0;
       
       
        for(int i=0;i<n;i++)
      {
           for(int j=0;j<n-i-1;j++)//notice: j start at 0
            {
        	   Integer x=a.get(j); 
        	   Integer y=a.get(j+1);
               //  System.out.println("i="+i+"j="+j);
                if(x>y)
                {
                  swap++;
                 a.set(j, y);
                 a.set(j+1, x);
                } 
            }
      }//end for i
      
      System.out.println("Array is sorted in "+swap+" swaps.");
      System.out.println("First Element: "+a.get(0));
       System.out.println("Last Element: "+a.get(n-1));
    }

}

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        BubbleSortResult.countSwaps(a);

        bufferedReader.close();
    }
}
