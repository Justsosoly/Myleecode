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

class MinimumLossResult {

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */
// limit time exceed O（n2）
    public static int minimumLoss3(List<Long> price) {
    // Write your code here
    int result=0;
    long min=Integer.MAX_VALUE;
    for(int i=0;i<price.size()-1;i++)
       {
         long x=price.get(i);
         
         for(int j=i+1;j<price.size();j++)
         {
           long y=price.get(j);
           long  z=x-y;
           
           if(z>0)
           {
              if(z<min)
              {
            	  min=z;
              }
             
           }
         }
         
       }
    
    result=(int)min;
    System.out.println("the result:"+result);
    return result;
    }
    
    // limit time exceed O（n）
    public static int minimumLoss2(List<Long> price) {
   	 int result=0;
	 List<Long> sortlist=new ArrayList<>();
	 long min=Integer.MAX_VALUE;
	 sortlist.addAll(price);
	 Collections.sort(sortlist);
	 
	 for(int i=0;i<price.size()-1;i++)
	 {
    	//y-x>0
    	int j=i+1; 
    	long x=sortlist.get(i);//y is larger than x,and the y's index is lesser than x
    	long y=sortlist.get(j);
    	int preindex=price.indexOf(y);
    	int postindex=price.indexOf(x);
    	
    	if( preindex < postindex  )
    	{
    		if((y-x)<min)
    		{
    			min=(y-x);
    		}
    		
    	}
    	        	
	 }
 
	 result =(int)min;
	 return result;
    }
    
    
    public static int minimumLoss(List<Long> price) {
    	int result=0;
    	 long min=Integer.MAX_VALUE;
    	PriorityQueue<Long> que=new PriorityQueue<Long>();
    	que.addAll(price);
    	int n=price.size();
    	for(int i=0;i<n-1;i++)
    	{
    		if(que.size()>=2)
    		{
    		long x=que.poll();//y is larger than x,and the y's index is lesser than x
        	long y=que.peek();
        	
        	int preindex=price.indexOf(y);
        	int postindex=price.indexOf(x);
        	
        	if( preindex < postindex  )
        	{
        		if((y-x)<min)
        		{
        			min=(y-x);
        		}
        		
        	}
    		}
    	}
    	
   	  result =(int)min;
    	
    	
    	
    	return result;
    }
    
    

}

public class MinimumLoss {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> price = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        int result = MinimumLossResult.minimumLoss(price);

        bufferedReader.close();
    }
}
