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

class LegoBlocksResult {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n height
     *  2. INTEGER m weight
     */
	private static final int MOD = 1000000007;
    public static int legoBlocks(int n, int m) {
    // Write your code here
    	/*
    	int result=0;
    	int allblocks=allBlocks(n,m);
    	int method[]=new int[m+1] ;
    	
    	for(int i=0;i<m;i++)
    	{
    		
    		method[i]=allblocks-method[i];
    		
    	}
    	
    	return result;
    	*/
    
    	 long dpLowest[] = new long[m+1];
         long dpAll[] = new long[m+1];
         long dpGood[] = new long[m+1];
         
         for(int j=1; j<=m; j++) {
             if (j == 1) {
                 dpLowest[j] = 1;
             } else if (j == 2) {
                 dpLowest[j] = 2;
             } else if (j == 3) {
                 dpLowest[j] = 4;
             } else if (j == 4) {
                 dpLowest[j] = 8; // 1111 112 121 13 211 22 31 4
             } else {
                 dpLowest[j] = mod(dpLowest[j-1] + dpLowest[j-2] + dpLowest[j-3] + dpLowest[j-4], MOD);
             }
         }
         
         for(int i=1; i<=m; i++) {
//             dpAll[i] = 1;
//             for(int j=1; j<=n; j++)
//                 dpAll[i] = mod(dpLowest[i]*dpAll[i], MOD);
        	 dpAll[i]= mod((long) Math.pow(dpLowest[i],n), MOD);
             
         }
         
         for(int i=1; i<=m; i++) {
             if (i == 1) {
                 dpGood[i] = 1;
                 continue;
             }
             dpGood[i] = dpAll[i];
             for(int j=1; j<i; j++) {
                 dpGood[i] = mod(dpGood[i]- (dpGood[i-j]*dpAll[j]), MOD);
             }
         }
         
         System.out.println((int)mod(dpGood[m], MOD));
         return  (int)mod(dpGood[m], MOD);
    	
    
    }
    
    
    private static long mod(long l1, int modN) {
        long modded = l1%modN;
        if (modded < 0) {
            modded+= modN;
        }
        return modded;
    }
    
    public static int allBlocks(int n, int m)
    {
    	
    	int method=0;
    	int result=0;
    
    	
    	
        switch (m)
        {
           case 1:
        	   method=1;
        	   result=(int) Math.pow(method,n);
        	   return result;
           case 2:
        	   method=2;
        	   result=(int) Math.pow(method,n);
        	   return result;
           case 3:
        	   method=4;
        	   result=(int) Math.pow(method,n);
        	   return result;
           case 4:
        	   method=8;
        	   result=(int) Math.pow(method,n);
        	   return result;
           default:
            method+=legoBlocks(n,m-4)+legoBlocks(n,m-3)+legoBlocks(n,m-2)+legoBlocks(n,m-1);
            result=(int) Math.pow(method,n);
            return result;
        }//end switch
    	
    }

}

public class LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = LegoBlocksResult.legoBlocks(n, m);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
