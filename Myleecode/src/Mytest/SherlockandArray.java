package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class SherlockandArrayResult {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    // Write your code here
     int start=0;
     int end=arr.size()-1;
     int sum=arr.stream().mapToInt(Integer::intValue).sum();
     if(arr.size()==1) return "YES";
     int presum=0;
	 int postsum=sum-arr.get(0);
     for(int i=0;i<end;i++)
     {
    	 //caculator the pre field
    	 if(presum==postsum) return "YES";
    		 presum+=arr.get(i);
    	 
    	 postsum= sum-presum-arr.get(i+1);
 
    	 if(presum==postsum) return "YES";
    	 
     }
     
     return "NO";
    }

}

public class SherlockandArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
                String result = SherlockandArrayResult.balancedSums(arr);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }
}
