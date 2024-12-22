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

class SumvsXORResult {

    /*
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor(long n) {
    // Write your code here
    int count=0;
    if(n==0) return 1;
     String s=Long.toBinaryString(n);
      for(int i=0;i<s.length();i++)
      {
          char temp=s.charAt(i);
    	  if(temp=='0')
        {
          System.out.println("cha is"+s.charAt(i));
         count++;
        }
        
      }
     
    System.out.println("count is"+count);
      return (long)Math.pow(2,count); 
    }

}

public class SumvsXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = SumvsXORResult.sumXor(n);


        bufferedReader.close();
    }
}
