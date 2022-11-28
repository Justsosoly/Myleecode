package Mytest;



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class CommonChildResult {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
    // Write your code here
    	int result=0;
    	int m=s1.length();
    	int n=s2.length();
    	
    	int dp[][]=new int[m+1][n+1];
    	for(int x=0;x<=m;x++)
    		dp[m][0]=0;
    	for(int y=0;y<=n;y++)
    		dp[0][n]=0;
    	
    	
    	for(int i=1;i<=m;i++)
    		for(int j=1;j<=n;j++)
    		{
    			char p=s1.charAt(i-1);
    			char q=s2.charAt(j-1);
    			
    			if(p==q) dp[i][j]=dp[i-1][j-1]+1;
    			
    			else
    				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
    			
    		}
    	
    	
    	result=dp[m][n];
    	
    	
        return result;
    }

}

public class CommonChild {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = CommonChildResult.commonChild(s1, s2);



        bufferedReader.close();
    }
}
