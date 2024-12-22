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
		
		unsorted.sort(
				new Comparator<String>()
				
				{

					@Override
					public int compare(String o1, String o2) {
						// TODO Auto-generated method stub
						
						if(o1.length()>o2.length()) return 1;
						if(o1.length()<o2.length()) return -1;
						if(o1.length()==o2.length())//the same size number
						{
							for(int i=0;i<o1.length();i++)
							{
							  if(o1.charAt(i)>o2.charAt(i)) 
								  return 1;
							  if(o1.charAt(i)<o2.charAt(i))
								  return -1;
							  if(o1.charAt(i)==o2.charAt(i))	
								  continue;
							}
							return 0;
						}
						return 0;
					}
			
				}
				
				);
		
		
		
		return unsorted;
	}
	
//bubble sort fail the time limit exceeded
public static List<String> bigSorting3(List<String> unsorted) {
    
    // Write your code here
     int num=unsorted.size();
     
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



//choose sort fail the time limit exceeded
public static List<String> bigSorting2(List<String> unsorted) {
// Write your code here

  int n=unsorted.size();

 
  for(int i=0;i<n-1;i++)
  {
    int min=i;
     
    for(int j=i+1;j<n;j++)
    {
        BigInteger x=new BigInteger(unsorted.get(min));
        BigInteger y=new BigInteger(unsorted.get(j));
      //  System.out.println("x= "+ sorted.get(min)+" y= "+y+ " min="+min);
       if( x.compareTo(y)==1)  //x>y
          {
             min=j;
             
          }    
    }//end for j
        
        String temp=unsorted.get(i);
        unsorted.set(i, unsorted.get(min)); 
        unsorted.set(min, temp); 

  }//end for i   
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
