package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class SansaXORResult {

    /*
     * Complete the 'sansaXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int sansaXor(List<Integer> arr) {
    // Write your code here time limits fail
      int result=arr.get(0);
      
      List<Integer> resultlist=new ArrayList<>();
      for(int i=1;i<arr.size();i++) //所有元素单个异或
      {
        int a=arr.get(i);
        result^=a;
      }
      resultlist.add(result);
     
      /*
       resultlist里的内容：
       
       1^2       x=0,y=1
       1^2^3     x=0,y=2  
       1^2^3^4   x=0,y=3
       
       2^3       x=1,y=2 
       2^3^4     x=1,y=3
       
       3^4       x=2,y=3
       
       跳出循环   x=3,y=4 
       
       */
      
      for(int x=0;x<arr.size();x++) //所有子数组异或结果放入resultlist中
        {
          int a=arr.get(x);
         for(int y=x+1;y<arr.size();y++)
          {
           int b=arr.get(y);
            a^=b;
            resultlist.add(a); 
          }
        
        }
      int re=resultlist.get(0);
      for(int p=1;p< resultlist.size();p++)
      {
    	  re^=resultlist.get(p);	  
      }
      
      return re;
    }

}

public class SansaXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            int result = SansaXORResult.sansaXor(arr);

        }

        bufferedReader.close();
    }
}
