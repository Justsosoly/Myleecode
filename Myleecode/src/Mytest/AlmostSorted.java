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



class AlmostSortedResult {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

	 public static void almostSorted(List<Integer> arr) {
	 
		 

	      List<Integer> list=new ArrayList<Integer>();
	     List<Integer> flag=new ArrayList<Integer>();
	      for(Integer x:arr)
	      {
	       list.add(x) ;
	      }
	      Collections.sort(list);
	      
	      for(int i=0;i<arr.size();i++)
	      {
	        if(list.get(i)!=arr.get(i))
	        {
	          flag.add(i+1);
	        }
	      }
	     
	     if(flag.size()==0) 
	     System.out.println("yes");
	     
	     else if(flag.size()==2)
	     {
	  System.out.println("yes");
	  System.out.println("swap "+flag.get(0)+" "+flag.get(1));
	     }
	    
	     else if(flag.size()>2)
	     {
	       
	       int size=flag.size();
	       int count=0;
	       
	       for(int j=0;j<size;j++)
	       {
	          int start=arr.get(flag.get(j)-1);
	          int end=list.get(flag.get(size-j-1)-1);
 	    	   
	    	   if(start==end)
	         {
	           count++;
	         }
	       }
	       if(count==size)
	       {
	     System.out.println("yes");
	    System.out.println("reverse "+flag.get(0)+" "+flag.get(size-1));
	       }
	       else 
		    	 System.out.println("no");
	     }
	     
		 
	 }
	
	
	
	
	
	
    public static void almostSorted2(List<Integer> arr) {
    // Write your code here
    	int n=arr.size();
    	List<Integer>flag= new ArrayList<Integer>();
    	List<Integer>startend= new ArrayList<Integer>();
    	int asc=0;
    	
    	if(arr.size()>2)
    	{
    	
    		
    	for(int i=0;i<n-1;i++)
    	{
    		int x=arr.get(i);
    		int y=arr.get(i+1);
    	//	System.out.print(x+" ");
    		if(y>=x)
    		{
    			asc++;
    		}
    		else
    		{
    			startend.add(i);
    			flag.add(x);
    		}
    		
    	}
    	
    	
    	if(asc==(n-1))
    		{
    		System.out.println("yes");
    		return;
    		}
    	
    	if(!startend.isEmpty()||!flag.isEmpty())
    	{
    	
    	
    	int startindex=startend.get(0);
    	int endindex=startend.get(startend.size()-1);
    	
    	flag.add(arr.get(endindex+1));
    	startend.add(endindex+1);
    	Collections.reverse(flag);
    	if(flag.size()==2)
    	{
    		
    	 if(flag.get(0)>arr.get(startindex-1)&&flag.get(flag.size()-1)<arr.get(endindex+2))
    	 {
    		 System.out.println("yes");
    		System.out.println("swap "+(startindex+1)+" "+(endindex+2));
    		return;
    	 }
    	 else {
    		 
    		 System.out.println("no");
     		return ;
    	 }
    	}
    	
    	if(flag.get(0)>arr.get(startindex-1)&&flag.get(flag.size()-1)<arr.get(endindex+2))
    		{
    		System.out.println("yes");
    		System.out.println("reverse "+(startindex+1)+" "+(endindex+2));
    		}
    	else
    	{
    		System.out.println("no");
    		return ;
    	}
    	
    	
    	}
    	}//end if size 2
    	else
    	{
    		System.out.println("yes");
    		if(arr.get(0)>arr.get(1))
    			System.out.println("swap 1 2");
    	}
    	

    }

}

public class AlmostSorted {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        AlmostSortedResult.almostSorted(arr);

        bufferedReader.close();
    }
}
