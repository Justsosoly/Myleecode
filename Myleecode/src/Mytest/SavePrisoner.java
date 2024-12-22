package Mytest;

import java.io.*;
import java.util.stream.*;


class SavePrisonerResult {

    /*
     * Complete the 'saveThePrisoner' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER s
     */
 
    public static int saveThePrisoner(int n, int m, int s) {
    	 
    	int result=0;
    	     
          if(m>n)
          {
            m=m%n;
          }
          System.out.println("m is "+m);
          if( (s+m)>n ) 
          {
            result=(s+m-1)%n;
           
            if(result==0)
            result=n;
            
          }
        
           else//s+m<=n
          {
            result=s+m-1;
            
            if(result==0)
            {
              result= n;
            }  
         
          } 
           
          return result;
    }

}

public class SavePrisoner {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int s = Integer.parseInt(firstMultipleInput[2]);
                
                int result = SavePrisonerResult.saveThePrisoner(n, m, s);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
