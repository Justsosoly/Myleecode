package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class MinandMax {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        MinandMax.miniMaxSum(arr);

        bufferedReader.close();
    }
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here

        long []sumarr=new long [arr.size()];
     
        for(int i=0;i<arr.size();i++)//得到N个除去第i个数的求和数，放到数组sumarr[]中
        {     
            long sum=0;
            for(int j=0;j<arr.size();j++)
            {
              if(j!=i)
              {
              sum=arr.get(j)+sum;
              }
            
            }
         //   System.out.println("the "+i+"sum is:"+ sum);
            sumarr[i]=sum;
            
        }
        if (arr.size()>=2)  //测试数大于2个以上
        {
       /*
        for(int m=0;m<sumarr.length-1;m++)
        	for(int n=m+1;n<sumarr.length;n++ )
        	
        {
                int temp;
        		if(sumarr[m]>sumarr[n])
        		{
        		temp=sumarr[m];
        		sumarr[m]=sumarr[n];
        		sumarr[n]=temp;
        		}
        }
        */

            for(int m=0;m<sumarr.length-1;m++)
            	for(int n=0;n<sumarr.length-m-1;n++ )
            	
            {
                    long temp;
            		if(sumarr[n]>sumarr[n+1])
            		{
            		temp=sumarr[n+1];
            		sumarr[n+1]=sumarr[n];
            		sumarr[n]=temp;
            		}
            }
        	//256741038 623958417 467905213 714532089 938071625
        	
        	
        
        }
        
        System.out.println(sumarr[0]+" "+sumarr[arr.size()-1]);
        
        }
    
}
