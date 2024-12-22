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

class AppendDeleteResult {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here
    int m=s.length();
    int n=t.length();
    
    
    int max=0;
    int min=0;
     if(m>n)
       {
        max=m;
        min=n;
       }
     else  
     {
       max=n;
       min=m;
     }  
      int same=0;
  
      for(int i=0;i<min;i++)
      {
         
        if(s.charAt(i)!=t.charAt(i))
        {
           break;
        }    
         same=i+1;
      }
      System.out.println("same"+same);
      
     
     int operations=m-same+n-same;
      
    if( operations<=k&&(k-operations)%2==0)
    	
    	return "Yes";
     
     else
    	 
        return "No";
     
    }

}

public class AppendDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = AppendDeleteResult.appendAndDelete(s, t, k);


        bufferedReader.close();
    }
}
