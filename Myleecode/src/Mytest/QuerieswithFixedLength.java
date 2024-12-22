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

class QuerieswithFixedLengthResult {

	/*
	 * Complete the 'solve' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY arr 2. INTEGER_ARRAY queries
	 */

	//fail the test 2-9 time limit exceeded
	public static List<Integer> solve3(List<Integer> arr, List<Integer> queries) {
		    List<Integer> result=new ArrayList<>();	     
	        int n=arr.size();
	        int m=queries.size();
	        	    
	        for(int k=0;k<m;k++)
	        {
	            int q=queries.get(k);
	            List< List<Integer>> subarray_list=new ArrayList<>();
	            List<Integer> temp=new ArrayList<>();
	           //make the subarray   
	            for(int i=0;i<=n-q;i++)
	            {
	               
	               List<Integer> subarray_q=new ArrayList<>();
	               int j=i;
	                while(j<i+q)
	                {
	                  
	                  subarray_q.add(arr.get(j));  
	                //  System.out.print(arr.get(j)+" "); 
	                  j++;
	                } 
	               //  System.out.println(" "); 
	                Collections.sort(subarray_q);
	                subarray_list.add(subarray_q);
	            }

	          //get the max 
	          for(List<Integer> list: subarray_list)
	         {  
	            temp.add(list.get(q-1));
	            continue;
	         }

	          Collections.sort(temp);
	          
	         for(Integer e: temp)
	          {
	         result.add(e);
	         break;       
	          }
	        }
	        
	       return result;
	}
	
	
	
	
	public static List<Integer> solve2(List<Integer> arr, List<Integer> queries) {
		// Write your code here
		float f1=new Float("3.0");
		List<Integer>  queryresult = new ArrayList<Integer> ();
		
		int n=arr.size();

		for (int x = 0; x < queries.size(); x++) 
		{
			int q = queries.get(x);
			//List<List> subarr = new ArrayList<List>();
			List<Integer>  result = new ArrayList<Integer> ();
			
			for(int i=0;i<=n-q;i++)
			{
				int j=i;
				List<Integer> temp = new ArrayList<Integer>();
				
				
				 while(j-i<q)
			     {
					 temp.add(arr.get(j));
			    	 j++;
			     }//end while
				 
				 Collections.sort(temp);
				 result.add(temp.get(q-1));
				// subarr.add(temp);
				 
			}//end for i
			
			Collections.sort(result);
		
			queryresult.add(result.get(0));

		}// end for x

		return queryresult;
	}
	//pass all the test
	public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
		// Write your code here
	    List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int max = Collections.max(arr.subList(0, q));//第一个q子序列里最大的数
            int min = max;//在最大的数里，找出一个最小的
            for (int i = q; i < arr.size(); i++) {
            	Integer  temp =arr.get(i);
                if (arr.get(i) > max)//从第q+1个数开始往右找出更大的数
                    max = arr.get(i);
                else if (arr.get(i - q) == max)
                	//从最大的那个数往后再找q个数，找出最大的替换掉
                {
                	 List<Integer> templist=arr.subList(i - q + 1, i + 1);//在右边离之前max最近的一个q段[]里找出最大的	
                	max = Collections.max(templist);
                }
                min = Math.min(min, max);
            }
            result.add(min);
        }
        return result;
			
	}
	
	
	
	
	public static List<Integer> solve4(List<Integer> arr, List<Integer> queries) {
		List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int max = Collections.max( arr.subList(0,q));

            int min = max;
            int i=q;
            int index=arr.indexOf(max);
          while(i<arr.size())
            {
              int element=arr.get(i);
             
              if(element>max) //如果往右走的数比当前的max大，则更新max
              {
            	  max=arr.get(i);
            	  index=i;
            	  i++;
              }
                
              else if(element<=max)
                {
                   
            	  if( i==(index+q) )
                   {
                	   List<Integer> tempList=arr.subList ( index+1, index+q+1 );
                	   
                       max=Collections.max(tempList);
                       index= tempList.indexOf(max)+index+1;
                   }
     
                  i++;
                }
               min=Math.min(max, min);
               
            }
            result.add(min);
        }
        return result;
		
		
	}

}

public class QuerieswithFixedLength {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int q = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = QuerieswithFixedLengthResult.solve(arr, queries);

		bufferedReader.close();
	}
}
