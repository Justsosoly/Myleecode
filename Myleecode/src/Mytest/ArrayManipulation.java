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

class ArrayManipulationResult {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
//有的测试用例没有通过，并且时间限制也没通过
    public static long arrayManipulation3(int n, List<List<Integer>> queries) {
    // Write your code here
   List<BigInteger> list=new ArrayList<BigInteger>();
//   PriorityQueue<BigInteger> que=new PriorityQueue();
   
   for(int j=0;j<n;j++)
   {
     list.add(j, BigInteger.valueOf(0));
    // que.add(BigInteger.valueOf(0));
   }
   
   
   BigInteger max;
    for(int i=0;i<queries.size();i++)
    {
      int start=queries.get(i).get(0)-1;
      int end=queries.get(i).get(1)-1;
      BigInteger temp=new BigInteger(queries.get(i).get(2).toString());
       for(int p=start;p<=end;p++)
         {
           if(list.get(p)!=null)
           {
        	   
        	   BigInteger value ;
        	   value=  list.get(p).add(temp);
        	//   if(value.intValue()<0)
        	//	   System.out.println("value is "+value+"temp is: "+temp+"list.get(p)is"+list.get(p));
             list.set(p, value);
           }
         }
         
    }
    max=Collections.max(list);
 //  System.out.println(list.indexOf(max)+" : "+max);
    
   return max.longValue();
    }
    
    
    
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    	 Long value[]=new Long [n];
         for(int k=0;k<n;k++)
            value[k]=(long)0;
        long max=0;  
         
         
         long result=0;
         for(int i=0;i<queries.size();i++)
         {
             List<Integer> list=queries.get(i);
             int start=list.get(0)-1;
             int end=list.get(1);
             int val=list.get(2);
                  value[start]+=val;  
                  if(end<n)
                   value[end]-=val;  
               
         }
        
         
          
               for (int i = 0; i < n; i++) 
               {
                   result += value[i];
                  System.out.println("value[i]"+value[i]);
                   max = Math.max(max, result);
               }
           
         
         return max; 
    }
    
    
    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
    
    long[] tmp = new long[n];        
    long max=0,tmpSum=0;
    int a, b, k;
    for (List<Integer> query : queries) {
        a = query.get(0);
        b = query.get(1);
        k = query.get(2);

        tmp[a-1] += k;//increment
         if (b < n) {
            tmp[b] -= k;//decrement
        }
    }
    
    for (int i = 0; i < n; i++) {
        tmpSum += tmp[i];
        max = Math.max(max, tmpSum);
    }
    return max;
    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = ArrayManipulationResult.arrayManipulation(n, queries);


        bufferedReader.close();
    }
}
