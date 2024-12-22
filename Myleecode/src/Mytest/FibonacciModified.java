package Mytest;


import java.io.*;
import java.math.BigInteger;




class FibonacciModifiedResult {

    /*
     * Complete the 'fibonacciModified' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t1
     *  2. INTEGER t2
     *  3. INTEGER n
     */

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
    // Write your code here
       BigInteger result;
       if(n==1) 
       {
    	   result=BigInteger.valueOf(t1);
    	   return result;
       }
    	   
       if(n==2)
    	   {
    	   result=BigInteger.valueOf(t2);
    	   return result;
    	   }
       
      else
      {
    	  BigInteger ti=fibonacciModified(t1,t2,n-2);
    	  BigInteger tj=fibonacciModified(t1,t2,n-1);
        result= ti.add(tj.multiply(tj));
        System.out.println(result);
        return result;
       
      } 
      

   
    }

}

public class FibonacciModified {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int t1 = Integer.parseInt(firstMultipleInput[0]);

        int t2 = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        BigInteger result = FibonacciModifiedResult.fibonacciModified(t1, t2, n);


        bufferedReader.close();
    }
}
