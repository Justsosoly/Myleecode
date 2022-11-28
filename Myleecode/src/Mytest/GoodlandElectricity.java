package Mytest;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class GoodlandElectricityResult {

	/*
	 * Complete the 'pylons' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER k 2. INTEGER_ARRAY arr
	 */

	public static int pylons(int k, List<Integer> arr) {
    // Write your code here
    
     	int plants=0;
    	
    	int diameter=0;//向右发电范围
    	int n=arr.size();
    	int i=diameter+k-1;//下一个发电站位置
    	
    	while(diameter<n)
    	{
    		if(arr.get(i)==1) 
    			{
    			
    			diameter=i+k;
    			i=diameter+k-1;
    			plants++;
    			
        		if(i>n-1)
        			i=Math.min(i, n-1);
    			}
    		
    		else 
    		{
    			i--;
    		  if(i<diameter-k+1||i<0)//上一个发电站位置
    			return -1;
    		} 
    	}
    
    	return plants;
    	
    	
    }

}

public class GoodlandElectricity {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt).collect(toList());

		int result = GoodlandElectricityResult.pylons(k, arr);

		bufferedReader.close();
	}
}
