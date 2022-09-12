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
import  java.math.BigInteger;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class FlippingBits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

               FlippingBits.flippingBits(n);
                //FlippingBits.toDecimal("21474836");

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    
    public static String toBinary(long n, int target)
    {
    	String s="";
    	while(n!=0)
    	{
    		s=n%target+s;
    		n=n/target;
    		//System.out.println("the n is:"+n);
    	}
    	
    	System.out.println("the binary is:"+s);
    	
    	return s;
    }
    
    public static long toDecimal(String str)
    {
    	
    	long dec=0;
    	int count=str.length();
    	System.out.println("the coverse code is "+str);
    	for(int i=0;i<str.length();i++)
    	{
    		long value=Integer.parseInt(String.valueOf(str.charAt(i)));
    		count--;	
    		if(value==1)
    		{
    	  dec=(long) (dec+Math.pow(2,count));
    		}
    	}
    	System.out.println("the decimal is "+dec);
    	return dec;
    }
    
    
    public static void flippingBits(long n) {
    // Write your code here
     
      String bits=FlippingBits.toBinary(n, 2);
      String flips="";
 
      int length=bits.length();
      char []flippings=new char[32];
      
     // String bits= Integer.toBinaryString((int)n);
    //  int a=0x10;
    //  System.out.println("the binary test:"+ a);
      //  String s=String.format( "%032d",“10000000000000000000000000000000”);
    	
    	//超过位数了报错
 //     String s=String.format( "%032d",Integer.parseInt(bits));

      while(length<32)
      {
    	  bits="0"+bits;
          length++;    	  
      }      
      
      String s=bits;
      System.out.println("the 32 bit is "+s);
      

      
    
     for(int i=0;i<length;i++)
      
     {
    	 if(s.charAt(i)=='1')
    		 flippings[i]='0'; 
    	
    	 if(s.charAt(i)=='0') 
    		 flippings[i]='1';
    	// System.out.print("i is "+i);
    		 
      }
     for(int j=0;j<length;j++)
     {
    	
    	 flips=flips+flippings[j];
    	 
     }
     FlippingBits.toDecimal(flips);
         
   
    }
}
