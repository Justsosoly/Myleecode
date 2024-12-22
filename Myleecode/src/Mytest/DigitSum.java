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



class DigitSumResult {

    /*
     * Complete the 'waysToChooseSum' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. LONG_INTEGER lowLimit
     *  2. LONG_INTEGER highLimit
     */

    public static List<Long> waysToChooseSum(long lowLimit, long highLimit) {
    List<Long> result =new ArrayList<Long>();
    Map<Long,Long> map=new HashMap<Long,Long>();
    
    for(long i=lowLimit;i<=highLimit;i++)
    {
    	long templong=i;
    	String coupon=String.valueOf(i);
    	long couponid=0;
    	
    	while (coupon.length()>1)
    	{
    		couponid=0;
    	for(int j=0;j<coupon.length();j++)
    	  {
    		 
    		char temp=coupon.charAt(j);
    		String strtemp=String.valueOf(temp);
    		
    		couponid+=Long.parseLong(strtemp);
    	 	
    	  }
    	coupon=String.valueOf(couponid);
    	}
    	if(map.get(couponid)!=null)
    	map.put(couponid, map.get(couponid)+1);
    	else
    	map.put(couponid,1L);	//first in
    	
    }
    
    long max=Long.MIN_VALUE;
    for(Long key:map.keySet())
    {
    	if(map.get(key)>max)
    		max=map.get(key);
    }
    
    if(max>1)
    	
    	result.add(1L);
    else
    result.add((long)map.size());
    
    result.add(max);
    
    return result;
    }

}

public class DigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long lowLimit = Long.parseLong(bufferedReader.readLine().trim());

        long highLimit = Long.parseLong(bufferedReader.readLine().trim());

        List<Long> result = DigitSumResult.waysToChooseSum(lowLimit, highLimit);

       

        bufferedReader.close();
    }
}
