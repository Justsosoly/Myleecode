package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class NumberIntegersResult {

	/*
	 * Complete the 'getNumberOfIntegers' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. STRING L 2. STRING R 3. INTEGER K
	 */

	public static int getNumberOfIntegers(String L, String R, int K) {
		// Write your code here
		int result = 0;

		BigInteger l = new BigInteger(L);

		BigInteger r = new BigInteger(R);

		int l_length = L.length();
		int r_length = R.length();

		BigInteger one = new BigInteger("1");

		BigInteger start;
		BigInteger end=r;

		l = l.add(one);

		if (l_length < K)

			{
			String st ="";
			for(int p=0;p<K;p++)
			{
				st+="1";
			}	
			start=new BigInteger(st);
			System.out.println("start is changet to k="+st);
			}
	
		else
			start = l;

		
        //find all between start and end numbers
		while (start.compareTo(end) <= 0) {

			long count = 0;

			String str = start.toString();

			for (int i = 0; i < str.length(); i++)// calculator the number i has k number? if count=K,so yes
			{
				char cur = str.charAt(i);

				if (cur == '0') {
					continue;
				} else {

					count++;

				}

			}
			if (count == K) {
				System.out.println("str=" + str);
				result++;
			}
			start = start.add(one);

		}
		
		
		
      if (r_length > K)
			
      {
    	  
    	  ;
    	  
    	  
      }
		/*
		 * for(int q=1; q<mindigit; q++) {
		 * 
		 * for(int p=1;p<=9;p++) {
		 * 
		 * 
		 * cur=p*(int)Math.pow(10, q);
		 * 
		 * if(cur>l&&cur<=r) { System.out.println("make up:"+cur); result++; }
		 * 
		 * else break;
		 * 
		 * } }
		 */
		System.out.println(result);
		return result;

	}

}

public class NumberIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String L = bufferedReader.readLine();

        String R = bufferedReader.readLine();

        int K = Integer.parseInt(bufferedReader.readLine().trim());

        int ans = NumberIntegersResult.getNumberOfIntegers(L, R, K);


        bufferedReader.close();
    }
}
