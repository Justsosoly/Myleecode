package Mytest;



import java.io.*;
import java.util.stream.*;

class CounterGameResult {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

	
	
	// the wrong answer
    public static String counterGame(long n) {
    // Write your code here
    	int count=0;
        while(n!=1)
        {
       if( (n&(n-1))==0 )
         {
           n=n/2;
           count++;
         }
         else
         {
         String temp=Long.toBinaryString(n);
      
         
         
         //  n=Long.valueOf(temp.length())-1;
         n=(long)Math.pow(2,Long.valueOf(temp.length())-1);
           count++;
         }
        }
      
        
        
        
       if(count%2==0)
       {
    	  System.out.println("Richard");
    	   return "Richard";
       }
  
       else
       {
    	   System.out.println("Louise");
    	   return "Louise";
       }
       
    }
    
    
    
    
    
    public static String counterGame2(long n) {
        int turn = 0;
        while(n != 1){
            int power = (int)(Math.log(n)/Math.log(2));
            double newNum = Math.pow(2,power);
            if( newNum == n){
                n = n/2;
            }else{
                n = n - (long)newNum;
            }
            turn++;
        }   
        if(turn%2 == 0){
            return "Richard";
            
        }else{
            return "Louise";
        }

    }

}



public class CounterGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = CounterGameResult.counterGame(n);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
