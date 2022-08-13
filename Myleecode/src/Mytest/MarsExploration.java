package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class MarsExploration {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
    // Write your code here
    int len=s.length();
    int change=0;
    int numsos=len/3;
    for(int i=0;i<numsos;i++)
    {
        if(s.charAt(i*3)!='S') change++;
        if(s.charAt(i*3+1)!='O') change++;
        if(s.charAt(i*3+2)!='S') change++;
    }
    
    
    System.out.println("change is "+change);
    return change;
    }




    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      
        String s = bufferedReader.readLine();

        int result = MarsExploration.marsExploration(s);

      
        bufferedReader.close();

    }
}
