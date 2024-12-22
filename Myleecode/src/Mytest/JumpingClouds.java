package Mytest;



import java.io.*;
import java.util.*;


public class JumpingClouds {

    // Complete the jumpingOnClouds function below.
	
	
    static int jumpingOnClouds(int[] c, int k) {
       int energy=100;
       int index=0;
       int n=c.length;
       while(true)
        {
          if(c[index]==0)
          {
            energy--;
          }
          if(c[index]==1)
          {
            energy=energy-2-1;
          }
          index=index+k;
          
          if(index>=n)
           index=index-n;
          
          
          if(index==0)
          return energy;
        }
   
    }
    
  
    
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);



        scanner.close();
    }
}
