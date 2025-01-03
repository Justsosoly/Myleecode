package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



class PairsResult {

    /*
     * Complete the 'pairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */
	
	
	
	public static int pairs(int k, List<Integer> arr) {
		 int result=0;
         int n=arr.size();
         int left=0;
         int right=n-1;
         Collections.sort(arr);
         System.out.println(arr);
         //通过left，right 指针进行循环控制
       for(;right>0;right--)
         {
           Integer y=arr.get(right);
           left=0;
          
      
           while( left<right )
              {
        	   Integer x=arr.get(left);
        	     System.out.println("y="+y+" x="+x);
        	   if( (y-x)==k)   
               {
               	 result++;
                
                  break;
               }
        	   else
        	   {
        		   left++;
        	   }
              }
             
         }
         return result;
	}

    public static int pairs2(int k, List<Integer> arr) {
    // Write your code here 
    	//全部通过，两个for循环结束，加排序并得到结果后break跳出循环
    	
    	int n=arr.size();
    	int result=0;
    	
    	Collections.sort(arr);
    	
    	for(int i=0;i<arr.size();i++)
    	{
    		int x=arr.get(i);
    		
    		for(int j=i+1;j<arr.size();j++)
    		{
    			int y=arr.get(j);
    			if(Math.abs(x-y)==k)
    			{
    				result++;
    				break;
    			}
    			if(Math.abs(x-y)>k)// pass the exceed time limit
    				break;
    		}
    	}
        return result;
    }
}

public class Pairs {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = PairsResult.pairs(k, arr);

        bufferedReader.close();
    }
}
