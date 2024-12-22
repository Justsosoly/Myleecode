package Mytest;


import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ShapeSolution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

       // int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Rectangle rc=new Rectangle();
        rc.area(arr.get(0),arr.get(1));

        bufferedReader.close();
        
    }//end main
    
   
    
}

abstract class Shape{
    int length;
    int breadth;
     void area()
    {
      System.out.println(length+" "+breadth);
    }  
}
    class Rectangle extends Shape
  {
      int length;
      int breadth;
      void area(int length,int breadth )
    {
      System.out.println(length+" "+breadth);
      System.out.println(length*breadth);
    } 
  }
    
