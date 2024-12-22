package Mytest;


import java.io.*;
import java.util.*;

public class MinMaxRiddle {

	// Complete the riddle function below.

	static long[] riddle(long[] arr) {
		// complete this function

		
		
		

		int n = arr.length;

		long[] result = new long[n];

		for (int winsize = 1; winsize <= n; winsize++)// loop every window size ,total n size
		{

		//	System.out.println("the window size=" + winsize);

			int i = 0;

			long max = Long.MIN_VALUE;

			while (i <= (n-winsize) ) // loop window times

			{

				   long min = arr[i];


					for (int j = 1; j < winsize; j++) {

						if (arr[i + j] < min)

						{
							min = arr[i + j];
						//	System.out.println("int the window times=" + i + " the min=" + min);
						}

					}// end for j

			

				if (min > max) {
					max = min;
					
				}

				i++;

			} // end while

		//	System.out.print(max+" ");
			result[winsize - 1] = max;// get the max

		}//end  for winsize

	//	System.out.println(result);
		
		return result;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);



        scanner.close();
    }
}
