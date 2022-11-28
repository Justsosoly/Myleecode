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

	public static List<Integer> solve2(List<Integer> arr, List<Integer> queries) {
		// Write your code here
		
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
	
	public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
		// Write your code here
	    List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            int max = Collections.max(arr.subList(0, q));
            int min = max;
            for (int i = q; i < arr.size(); i++) {
                if (arr.get(i) > max)//
                    max = arr.get(i);
                else if (arr.get(i - q) == max)
                	//从最大的那个数往后再找q个数，找出最大的替换掉
                    max = Collections.max(arr.subList(i - q + 1, i + 1));
                min = Math.min(min, max);
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
