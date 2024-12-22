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

class PickingNumbersResult {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

	
	//other method
    public static int pickingNumbers2(List<Integer> a) {
    // Write your code here
    	Collections.sort(a);
        int maxEls = 0;
        int curEls = 0;
        int start = a.get(0);
 
        
        for (Integer value : a) {
            if(Math.abs(start-value)<=1){
                curEls++;
                maxEls = Math.max(maxEls, curEls);
            }else{
                maxEls = Math.max(maxEls, curEls);
                start = value;
                curEls = 1;
            }
        }
        return maxEls;
    }
    
    
    //myself method pass all the test
    
    public static int pickingNumbers(List<Integer> a) 
    
    {
    	
    	int n=a.size();
        
        int max=0;

        Collections.sort(a);
         
        Map<Integer,Integer> map=new HashMap<>();
        
         for(int p=0;p<n;p++)
         {
          Integer temp=a.get(p);
           if(map.get(temp)==null)
            map.put(temp, 1);
           else
            map.put(temp, map.get(temp)+1);    
         }
         
         
      if(map.size()==1) return n;
      
         for(Integer key:map.keySet())
         {
          
          System.out.println("key is "+key);
           Integer value=map.get(key);
          System.out.println("value is "+value);
          
           int result =value;
         if(result>max) max=result;
         
           if(map.get(key+1)!=null||map.get(key-1)!=null)
           {
             int x=0;
             int y=0;
             if(map.get(key+1)!=null) 
             x=map.get(key+1);
             if(map.get(key-1)!=null) 
             y=map.get(key-1);
             
             int bigger=0;
             
             if( x>y )
             bigger=x;
             else
             bigger=y;
             
             result=result+bigger;
             

             if(result>max)
             max=result;
             System.out.println("max is "+max);
            
           }
           
           
         }
        

        return max;
    	
    }
    

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = PickingNumbersResult.pickingNumbers(a);


        bufferedReader.close();
    }
}
