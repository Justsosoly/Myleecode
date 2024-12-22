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

class NonDivisibleSubsetResult {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

	
	
	
    public static int nonDivisibleSubset(int k, List<Integer> s) {
	
	// Write your code here
    int[] count=new int[k];
    for(Integer e:s){
    	System.out.println("e is "+e+" e%k "+e%k);
        count[e%k]++;
    }
    int resp=Math.min(count[0],1);
    System.out.println("count[k/2] is "+count[k/2]);
    if(k%2==0) resp+=Math.min(count[k/2],1);
    for (int i=1;i<k/2+1;i++){
        if(i==k-i)continue;
        System.out.println("count[i] "+count[i]+"count[k-1]"+count[k-i]);
        resp+=Math.max(count[i],count[k-i]);
    }
    return resp;
	
    }
	
    public static int nonDivisibleSubset2(int k, List<Integer> s) {
    // Write your code here
     int result=0;
     int n=s.size();
     List<Integer> list=new ArrayList<>();
     
     Collections.sort(s);
     for(int i=0;i<n;i++)
     {
       Integer x=s.get(i);
        for(int j=i+1;j<n;j++)
         {
           Integer y=s.get(j);
           Integer sum=x+y;
           if(sum%k!=0)
           {
        	  
        	  System.out.println("x="+x+"y="+y+", sum="+sum+"不能整除"+k); 
        	   
        	   if(!list.contains(x))
               {
        		   if(isAdd(list,x,k))
              	 {
            	 list.add(x);
                 }
        	   }
        		 
        	   if(!list.contains(y))
               {
        		   if(isAdd(list,y,k))
              	 {
        		   list.add(y);
              	 } 
               }
        	 
           }
         }
     }
     result=list.size();
     
      return result;
    }
    
    public static boolean  isAdd(List<Integer> list, Integer x,int k)
    {
    	boolean isadd=true; //could add to the list
    	
    	for(int i=0;i<list.size();i++)
    	{
    		int sum=list.get(i)+x;
    		if( sum%k==0)
    		{
    			System.out.println("flag is flase,x is "+x+" y is"+list.get(i)+" sum is "+sum);
    			isadd=false;
    			return isadd;
    		}
    		
    		
    	}
    	
    	return isadd;
    }
    

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = NonDivisibleSubsetResult.nonDivisibleSubset(k, s);


        bufferedReader.close();
    }
}
