package Mytest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class NewYearChaosResult {

	/*
	 * Complete the 'minimumBribes' function below.
	 *
	 * The function accepts INTEGER_ARRAY q as parameter.
	 */

	public static void minimumBribes(List<Integer> q) {
		// Write your code here bribes=3
	   //0 1 2 3 4  i
       //2 1 5 3 4  input
	   //1 2 3 4 5  q.get(i)	
	
		int swapcount = 0;
		for (int i = 0; i < q.size(); i++) {
			
			int cur=q.get(i);
			
			
			if((cur-i-1)>2)
		    {
			System.out.println("Too chaotic");
			return;
		    }	
			
			
			int j=(cur-2>0?cur-2:0);//不用全部从开始遍历
			
			for(;j<i;j++)
			{	
			    int i_val=q.get(i);
			    int j_val=q.get(j);
				
				if(j_val>i_val) 
					swapcount++;
			}
		}

		System.out.println(swapcount);

	}

}

public class NewYearChaos {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList());

				NewYearChaosResult.minimumBribes(q);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
