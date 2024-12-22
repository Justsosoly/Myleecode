package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



class BetweenTwoSetsResult {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    int result=0;
    List <Integer> resultList=new ArrayList<Integer>();
    Collections.sort(a);
    Collections.sort(b);
    int n=a.size();
    int m=b.size();
    
    Integer amax=a.get(a.size()-1);
    Integer bmin=b.get(0);


    int modfirst=a.get(0);
    
    if(amax>bmin) return 0;
    
    else
    {
  
     
         for(int i=amax;i<=bmin;i++)//a的第一个数一直到b的第一个数
           {
            boolean flag=true;
        	for(int j=0;j<n;j++) 
        	{
        		System.out.println(i+"mod"+ a.get(j) +" : "+i%a.get(j));
        		if(i%a.get(j)!=0) //a数组不能整除则跳出循环
        			{
        			flag=false;
        			break;
        			}
        	}
        	
        	if(flag)
        	{
        		for(int p=0;p<m;p++)
        		{
        	    System.out.println(b.get(p) +"mod"+ i +" : "+ b.get(p)%i);
        		 if(b.get(p)%i!=0)
        		 {
        			 flag=false;
         			 break;
        		 }
        			 
        		}
        		if(flag)
        			result++;
        		
        	}
       
            }//end for
      
       }//end else
    
    
    
    return result;
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = BetweenTwoSetsResult.getTotalX(arr, brr);

        bufferedReader.close();
    }
}
