package Mytest;

import java.io.*;
import java.math.*;

import java.util.*;

import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class SortList {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here
    
        int length=unsorted.size();
        int low=0;
        int high=length-1;
       quickSorting(unsorted,low,high);
    
         for(int i=0;i<length;i++)
            System.out.println(unsorted.get(i));
    
    
     return unsorted;
    }
    
    public static void quickSorting(List<String> unsorted,int low,int high)
    {
    
        
       if(low>high) return ;
     
       int i=low;
       int j=high;
       BigInteger index=new BigInteger(unsorted.get(low));
    	
        while(i<j)
        {
         
         
         BigInteger lowbig=new BigInteger(unsorted.get(i));
         BigInteger highbig=new BigInteger(unsorted.get(j));
     
          //right
          while(i<j&& index.compareTo(highbig)<=0)
          {
        	  j--;
        	  highbig=new BigInteger(unsorted.get(j));
          }  
          //left
          while(i<j&&index.compareTo(lowbig)>=0 )
          {
        	  i++;
        	  lowbig=new BigInteger(unsorted.get(i));
          }
          if(i<j)	
          {
        	  String temp=unsorted.get(i);
        	  unsorted.set(i, unsorted.get(j));
        	  unsorted.set(j, temp);
          }
        }
          unsorted.set(low, unsorted.get(j));
          unsorted.set(i, index.toString());
          
          
          quickSorting(unsorted,low,j-1);
          quickSorting(unsorted,j+1,high);
         
       
        
       
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = SortList.bigSorting(unsorted);



        bufferedReader.close();

    }


}