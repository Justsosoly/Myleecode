package Mytest;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
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
public class BigSorting {
	

public static List<String> bigSorting(List<String> unsorted) {
    
    // Write your code here
     int num=unsorted.size();
      List<String> sortString=null;
     for(int i=0;i<num;i++)
       for(int j=0;j<num-i-1;j++)
       {
           BigInteger x=new BigInteger(unsorted.get(j)); 
           BigInteger y= new BigInteger(unsorted.get(j+1));
           
           if(x.compareTo(y)==1)
           {
             
             unsorted.set(j, String.valueOf(y));
          
             unsorted.set(j+1, String.valueOf(x));
           }
           
       }
     
     
     for(String date:unsorted)
     {
    	 
    	 System.out.println(""+date);
     }


      return unsorted;
    }


public void quickSort(List<String> unsorted,int low ,int high)

{
   int i=low;
   int j=high;
   if(low>=high) return ;
   BigInteger index= new BigInteger(unsorted.get(i));
   while(i<j)
   {
	  
	   
	  //deal with the right domain
	//   while(i<j&&)
	   
	   
   } 
   

}



public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
 //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
        try {
            return bufferedReader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    })
        .collect(toList());

    List<String> result = bigSorting(unsorted);

  //  bufferedWriter.write(
     //   result.stream().collect(joining("\n"))+ "\n");

    bufferedReader.close();
   // bufferedWriter.close();
}


}
