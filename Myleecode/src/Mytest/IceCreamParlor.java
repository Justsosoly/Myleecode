package Mytest;

import java.io.*;
import java.util.*;


class IceCreamParlorResult {

    /*
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    // Write your code here 
    	/*
    	List<Integer> result=new ArrayList<Integer>();
    	int n=arr.size();
    	
    	for(int i=0;i<n;i++)
    	{
    		for(int j=i+1;j<n;j++)
    		{
    			if(arr.get(i)+arr.get(j)==m)
    			{
    				result.add(i+1);
    				result.add(j+1);
    			}
    		}
    	}
    	return result;
      }
      */
    	//improve
    	List<Integer> result=new ArrayList<Integer>();
    
    	int n=arr.size();
    	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
    
    	int index=0;
    	for(Integer price:arr)
    	{
    		map.put(price,index);
    		index++;
    	}
    	
    	
    	for(int i=0;i<n;i++)
    	{
    		int neednum=m-arr.get(i);
    		if(map.get(neednum)!=null&&map.get(neednum)!=i)
    		{
    			result.add(i+1);
    			result.add(map.get(neednum)+1);
    			break;
    		}
    			
    	
    	}
    	 return result;
    	}
    	
   
}

public class IceCreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int m = Integer.parseInt(bufferedReader.readLine().trim());

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            List<Integer> result = IceCreamParlorResult.icecreamParlor(m, arr);

      

        }

        bufferedReader.close();
    }
}
