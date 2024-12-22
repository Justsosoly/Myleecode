package Mytest;

import java.io.*;
import java.util.*;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
	//time limit
    static int maxSubsetSum2(int[] arr) {
        int result=0;
        int max=0;

        for(int i=0;i<arr.length;i++)
        {
            int x=arr[i];
            int y=0;
            int j=i+2;
            
          while(j<arr.length)
           {
               y=arr[j];
               max=Math.max(x,x+y);
               
               if(max>result)
               result=max;
              
               if(max==x) //means y<0，move right by 1
               {
                  j++;
               }
               else
               {
                   if(max==x+y)
                   
                   if(j==arr.length-2)//  2 to end
                   {
                	   max=Math.max( x+y, x+arr[arr.length-1] );
                	   if(max>result)
                           result=max;
                   }   
                   j=j+2;
                }
               System.out.println("x="+x+" y="+y+" max="+max);
               x=max;
              
           }
            
            
        }

        System.out.println("result="+result);
        return result;
    }
    
    //pass the tests
    static int maxSubsetSum(int[] arr) {
    	int result=0;
    	int n=arr.length;
    	int dp[]=new int[n];
    	dp[0]=arr[0];
    	dp[1]=Math.max(arr[0], arr[1]);
    	int max=0;
    	for(int i=2;i<n;i++)// the current max sum value
    	{
    	    int x=dp[i-2];
    		int y=arr[i];
    		int crruent=x+y;
    	    max=Math.max(crruent, dp[i-1]);
    	    dp[i]=Math.max(max, y);
    		
    	System.out.println("x="+x+" y="+y+" i="+i+" dp[i]="+dp[i]);
    		
    	}
    	result=dp[n-1];
    	
    	return  result;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);



        scanner.close();
    }
}
