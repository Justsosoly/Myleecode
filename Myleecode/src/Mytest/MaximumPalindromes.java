package Mytest;



import java.io.*;


class MaximumPalindromesResult {

    /*
     * Complete the 'initialize' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void initialize(String s) {
    // This function is called once before all queries.
       System.out.println("s is :"+s);
       StringBuilder str=new StringBuilder(s);
     
       
    }

    /*
     * Complete the 'answerQuery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int answerQuery(int l, int r) {
    // Return the answer for this query modulo 1000000007.
         int result=0;
  
       
         
         return result;
    }

}

public class MaximumPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        MaximumPalindromesResult.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int l = Integer.parseInt(firstMultipleInput[0]);

            int r = Integer.parseInt(firstMultipleInput[1]);

            int result = MaximumPalindromesResult.answerQuery(l, r);

        }

        bufferedReader.close();
    }
}
