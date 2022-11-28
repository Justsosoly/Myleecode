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

class JesseandCookiesResult {

	/*
	 * Complete the 'cookies' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. INTEGER_ARRAY A
	 */
//time limits,function is right
	public static int cookies2(int k, List<Integer> A) {
    // Write your code here
       int result=0;
       int flag=0;//all the 
       while(flag<A.size()) //sweetness>=k
       {
    	   for(int i=0;i<A.size();i++)
    	   {
    		   if(A.size()>1)
    	     {   
    		   
               int current=A.get(i);
    		   if(current>=k) 
    		   {
    			   flag++;
    			   continue;
    		   }   
    		   else
    		   {   
    		   int x=findMin(A);
    		   int y=findMin(delList(x,A));
    		   delList(y,A);
    		   int newcookie=x+2*y;
    		   A.add(newcookie);
    		   result++;
    		   i--;
    		   }
    	     }
    		   else
    		   {
    			   if(A.get(0)<k)
        			   return -1;
    			   else
    				   return result;
    		   }
    	   }//end for i
    	 //end if
       }//end while
       return result;
    }
	
	
	public static int cookies(int k, List<Integer> A) {
	    // Write your code here
	       int result=0;
	       int flag=0;//all the 
	   PriorityQueue<Integer> pque=new PriorityQueue<Integer>();
	   pque.addAll(A);
	   
	   int sweet=pque.peek();
	   int min=sweet,min2=0;
	   
	    while(min<k)
	    {
	    	
	    	if(pque.size()>=2)
	    	{
	    	min=pque.poll();
	    	min2=pque.poll();
	    	sweet=1*min+2*min2;
	    	pque.add(sweet);
	    	result++;
	    	min=pque.peek();
	    	}
	    	else
	    		return -1;
	    
	    }
	       return result;
	    }

	public static int findMin(List<Integer> list)

	{
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int temp = list.get(i);
			if (min > temp)
				min = temp;
		}
		return min;
	}

	public static List<Integer> delList(int min, List<Integer> list)

	{
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == min) {
				list.remove(i);
				break;
			}

		}

		return list;
	}

}

public class JesseandCookies {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
				.collect(toList());

		int result = JesseandCookiesResult.cookies(k, A);

		bufferedReader.close();
	}
}
