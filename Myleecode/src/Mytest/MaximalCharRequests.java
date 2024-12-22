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

class MaximalCharRequestsResult {

    /*
     * Complete the 'getMaxCharCount' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. 2D_INTEGER_ARRAY queries
     */

	
	//can't pass the time limits
    public static List<Integer> getMaxCharCount(String s, List<List<Integer>> queries) {
    // queries is a n x 2 array where queries[i][0] and queries[i][1] represents x[i] and y[i] for the ith query.
    List<Integer> result=new ArrayList<>();
        int n=queries.size();
       
        
        for(int i=0;i<n;i++)
        {
             int start= queries.get(i).get(0);
             int end= queries.get(i).get(1);
             int count=1;
             int max=Integer.MIN_VALUE;
            
            
           while(start<=end)
           {
                char cur= s.charAt(start);
                int current=0;
               
                if(cur>='a'&&cur<='z')
                   current=cur-'a';
                else
                    if(cur>='A'&&cur<='Z')
                  current=cur-'A';
               
               if(current<max)
               {
                   start++;
                   continue;
               }
               
              
              else if(current>max)
               {
                 max=current;
                 count=1;
                 start++;
               }  
              else if(current==max)
               {
                   count++;
                    start++;
               }
               
              // System.out.println("start="+start+" end="+end+" current="+current+" count="+count+" max="+max);
               
               
             
               
           }//end while
         
          
         result.add(count);
       //  System.out.println("i="+i);
         
         
        }//end for
           
        
        return result;
        
    }

}

public class MaximalCharRequests {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> query = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                query.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = MaximalCharRequestsResult.getMaxCharCount(s, query);


        bufferedReader.close();
    }
}
