package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class FullCountSortResult {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */
	
	
	public static void countSort(List<List<String>> arr) {
		
		
		
		List<List<String>> resultlist=new ArrayList<>();
	     int n=arr.size()/2;
	     for(int i=0;i<n;i++)
	     {
	       resultlist.add(i,new ArrayList<String>());
	     }
	     
	     
	     for(int p=0;p<n*2;p++)
	     {
	       List<String> element=arr.get(p);
	       
	       int x=Integer.valueOf(element.get(0));
	       String s=element.get(1);
	       
	       if(p<n)
	    	   resultlist.get(x).add("-");   
	       else
	       resultlist.get(x).add(s);
	       

	      
	     }
	     
	     for(List<String> list: resultlist)
	     {
	       
	    	 for(String str:list)
	    	 System.out.print(str+" ");
	    
	     }
	     
	     
		
		
		
		
	}
	
	

    public static void countSort2(List<List<String>> arr) {
    // Write your code here
    List<List<String>> result=new ArrayList<>();
    String fina="";
     int n=arr.size()/2;
     for(int i=0;i<n;i++)
     {
       result.add(new ArrayList<String>());
     }
     
     for(int p=0;p<n*2;p++)
     {
       List<String> element=arr.get(p);
       String num=element.get(0);
       String str=element.get(1);
       
       
       if(p<n)
       {
    	   result.get(Integer.valueOf(num)).add("-");
       }
       else
       {
    	   result.get(Integer.valueOf(num)).add(str);
       }
       
     }
     
     for(int x=0;x<result.size();x++)
    	 for(int y=0;y<result.get(x).size();y++)
    	// fina+=result.get(x).get(y)+" ";
    		 System.out.print(result.get(x).get(y)+" ");
     //System.out.println(fina);

    }

}

public class FullCountSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        FullCountSortResult.countSort(arr);

        bufferedReader.close();
    }
}
