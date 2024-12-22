package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class JewelGameResult {

    /*
     * Complete the 'getMaxScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING jewels as parameter.
     */

    public static int getMaxScore(String jewels) {
    // Write your code here
         int result=0;
        
        StringBuilder str=new StringBuilder(jewels);
        
        int i=0;
        while( i<str.length()-1)
        {
            char cur=str.charAt(i);
            char next=str.charAt(i+1);
            
            System.out.println("cur="+cur+" next="+next);
            if(cur==next)
            {
               result++; 
               str.delete(i,i+2); 
                 System.out.println("str="+str);
                i=0;
                continue;
            }
            
            i++;
            
        }
        System.out.println(result);
        
         return result;

    }

}

public class JewelGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String jewels = bufferedReader.readLine();
            int ans = JewelGameResult.getMaxScore(jewels);
        }

        bufferedReader.close();
    }
}
