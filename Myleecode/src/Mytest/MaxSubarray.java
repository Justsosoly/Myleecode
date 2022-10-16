package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class MaxSubarrayResult {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
    // Write your code here
    	List<Integer> sumlist=new ArrayList<Integer>();
    	
    	List<Integer> reslist=new ArrayList<Integer>();
    	int length=arr.size();
    	int subsequencesum=0;
    	int subarraysum=0;
    	int flag=0;
    	

    	
    	
    	
    	
    	for(int j:arr)
    	{
    		if(j<0)
    			flag++;
    	}
    	
    	if(flag==length)//all negative
    	{
    		subarraysum=returnMax(arr);
    		subsequencesum=returnMax(arr);
    		   sumlist.add(subarraysum);
    	        sumlist.add(subsequencesum);
    	        System.out.print(subarraysum);
    	        System.out.println(subsequencesum);
    	        return sumlist;
    	}
    	
    	else
    	{
    	
     
      
        for(int i:arr)
        {
        	if(i>0)
        		subsequencesum+=i;
        	
        }
        
        
  //This is because continuing with a negative sum is way worse than restarting with a new range
        int sum=0;
        for(int p:arr)
        {
        	
        	sum=sum+p;
        	if(sum<0)      //如果加上元素还小于0，则不要前面这些子序列，从新开始
        	{
        		sum=0;    
        	}
        	else
        	if(sum>=0)	 //新则的元素可以使得子序列值更大
        	reslist.add(sum);
        }
        
        	
        subarraysum=returnMax(reslist);
        sumlist.add(subarraysum);
        sumlist.add(subsequencesum);
        System.out.print(subarraysum);
        System.out.println(subsequencesum);
        int intarr[]=arr.stream().mapToInt(Integer::intValue).toArray();
        maxSubArraySum(intarr,arr.size());
        
        
    	return sumlist;
    	}

    }
    
    
  public  static void maxSubArraySum(int a[], int size)
    {
        int max_so_far = Integer.MIN_VALUE,
            max_ending_here = 0, start = 0, end = 0, s = 0;
 
        for (int i = 0; i < size; i++) {
            max_ending_here += a[i];
 
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
 
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                           + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
 

    
    public static int returnMax( List<Integer> arr)
    
    {
      int max=Integer.MIN_VALUE;
      
  
      
      for(int i=0;i<arr.size();i++)
      {
    	  if(arr.get(i)>max) 
    		  max=arr.get(i);
      }
      
      return max;	
    }
    

}

public class MaxSubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = MaxSubarrayResult.maxSubarray(arr);

           
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}