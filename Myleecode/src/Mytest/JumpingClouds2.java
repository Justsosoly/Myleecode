package Mytest;




import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class JumpingClouds2Result {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
    // Write your code here
       int result=0;
       int n=c.size();
       
       int current=-1;
       int next=0;
       int i=0;
       
      while(i<n-1)
       {
         Integer index=c.get(i);
         if(index!=1)
         {
           current=i;
           
           if((i+2)<n)
           {
           
        	   
        	 if(c.get(i+2)!=1)
            {
              i=i+2;
              result++;
              continue;
            }
            else
            {
              if(c.get(i+1)!=1)
             {
               i++;
               result++;
              continue;
             }
              
            }
        	 
        	 
           }
           else if( (i+2)>=n )
           {
        	  
        	   return result+1;   
        	   
           }
            
         }
         else
         {
        	 i++;
         }
         
         

       }
       
      return  result;
     
    }

}

public class JumpingClouds2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = JumpingClouds2Result.jumpingOnClouds(c);


        bufferedReader.close();
    }
}
