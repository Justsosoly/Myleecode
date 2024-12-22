package Mytest;



import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ProductionDistributionResult {

	/*
	 * Complete the 'maxScore' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY a 2. INTEGER m
	 */

	public static int maxScore(List<Integer> a, int m) {
		// Write your code here
		long result = 0;
		int n = a.size();
		int i = 0;
		Collections.sort(a);
		int count = 1;

		while (i < n) {

			long sum = 0;//run every m times

			if (i <= n - 2 * m) {

				for (int j = 0; j < m; j++) {
					sum += a.get(i);
					i++;
				}

			}

			else {
				
				while(i<n)
				{
					sum += a.get(i);
					i++;	
				}
				

			}

			result += count * sum;
			
			result=result%1000000007;

			count++;

		}

		return (int)result;
	}

}

public class ProductionDistribution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int ans = ProductionDistributionResult.maxScore(a, m);


        bufferedReader.close();
    }
}
