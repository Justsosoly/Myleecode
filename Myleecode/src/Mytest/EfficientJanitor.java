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


class EfficientJanitorResult {

    /*
     * Complete the 'efficientJanitor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts FLOAT_ARRAY weight as parameter.
     */
	//可以自己组合顺序
	 public static int efficientJanitor(List<Float> weight) {
		   int result=0;
	       int n=weight.size();
	       Collections.sort(weight);
	       int left=0;
	       int right=n-1;
	       while(left<right)
	       {
	    	   Float y=weight.get(right);
	    	   if(y>=1.99)
	    	   {
	    		   result++;
	    		   right--;
	    		   continue;
	    	   } 
	    	   else
	    	   {
	    		   Float x=weight.get(left);
	    		   if( (x+y)<=3 )
	    		   {
	    			   left++;
	    			   right--;
	    			   result++;
	    		   }
	    		   else
	    		   {
	    			   right--;
	    			   result++;
	    		   }	   
	    	   } 
	    	   
	       }
	       
	       return result;
		 
	 }
	
	
	
   //这个方法是看门人按既定顺序拿垃圾袋，不能挑选顺序
    public static int efficientJanitor2(List<Float> weight) {
    // Write your code here
       int result=0;
       int n=weight.size();
       Collections.sort(weight);
       
      for(int i=0;i<n;i++)
      {
       
        Float x=weight.get(i);
        Float y=0f;
        if(i==(n-1))
         y=0f;
        else
         y=weight.get(i+1);
   
      //  System.out.println("i:"+i+ " current x: "+x);
      
        if( (x+y)>3 )
        {
        	System.out.println("i:"+i+" current x: "+x+" 单独拿"); 
           	result++;
        }
        else
        {
            System.out.println("x: "+x+" next y: "+y);
            i++;
            result++;
            System.out.println("i:"+i+" 两个一起"); 
        }	
    
         System.out.println("result:"+result);
      }
      
      
       return result;
    }

}
public class EfficientJanitor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> weight = IntStream.range(0, weightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Float::parseFloat)
            .collect(toList());

        int result = EfficientJanitorResult.efficientJanitor(weight);


        bufferedReader.close();
    }
}
