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

class StrangeCounterResult {

    /*
     * Complete the 'strangeCounter' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER t as parameter.
     */

	
	//pass all the test
	  public static long strangeCounter(long t) {
		  
		  long value=3;
		  int count=0;
		  long startvalue=3;
		  long onecirlength=3;
		  
		  while(t>onecirlength)
		  {
			  t=t-onecirlength;
			  value=value+onecirlength;
			  startvalue=startvalue*2;
			  
			  onecirlength=startvalue;
		  }

		  
		  return value-t+1;
	  }
	
	
	
	
	//Time limit exceeded firstwrite
    public static long strangeCounter2(long t) {
    // Write your code here
    long result=-1;
  //  long []value= new long[]{t+1};
  
    long value=3;
    
    long start=3;
    int i=1;
    
    while(i<=t)
    {
        start=value;
        if(i==t) return value;
       for(long j=start;j>=1;j--)
        {
    	   i++;
    	   if(j==1)
           {
    		  value=2*start;
    		  if(i==t) return value;
    		  break;
           }
    	   else
    	   {
    		   value--;
    		   if(i==t) return value;
    		   continue;  
    	   }	
        }
    
    }
    
    result=value;
    
    return result;
    }

}

public class StrangeCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long t = Long.parseLong(bufferedReader.readLine().trim());

        long result = StrangeCounterResult.strangeCounter(t);

        bufferedReader.close();
    }
}
