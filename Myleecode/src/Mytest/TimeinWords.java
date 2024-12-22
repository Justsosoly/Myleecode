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

class TimeinWordsResult {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
    // Write your code here
      String result="";
      
      //m=xy
      int x=0;
      int y=0;
      
      int z=0;
    
      if(m==0) 
      {
    	  result= transTime(h)+" o' clock";
    	  return result;
      }
      
      if(m==30)
      {
    	  result="half past "+transTime(h);
    	  return result;
      }
      
      if(m>0&&m<30)
      {
    	
    	  if(m==15) 
 		 {
 		 result="quarter past ";
 		 
 		 result=result+transTime(h);
 		 return result;
 		 }
    	 if(m>20)
    	 {
    	 x=m/10;
    	 y=m%10;
    	 
    	 x=x*10;
    	 result=  transTime(x);
    	 result=result+" "+transTime(y)+" minutes past "+ transTime(h);
    	 }
    	 else
    	 {
    		 result=  transTime(m);
    		 if(m==1)
    			 result=result+" minute past "+ transTime(h);
    		 else 
        	 result=result+" minutes past "+ transTime(h);
    	 }
    	  return result;
      }  
      
      if(m<60&&m>30)
      {
    	 z=60-m; 
       
    	 
    	 if(z==15) 
		 {
		 result="quarter to ";
		 
		 result=result+transTime(h+1);
		 return result;
		 }
    	 
    	 if(z>20)
    	 {
    	 x=z/10;
     	 y=m%10;
    	 x=x*10;
    	 result=transTime(x)+" "+transTime(y)+" minutes to "+transTime(h+1);
    	 }
    	 else
    		 result=transTime(z)+" minutes to "+transTime(h+1); 
    	 
    	 
    	 return result;
    	  
      }
      
      return result;
      }
    
    public static String transTime(int h)
    
    {
    	String result="error";
    	
    	switch (h)
    	{
    	case 1:  
    		result= "one"; break;
    	case 2:  
    		result= "two";break;
     	case 3: 
     		result= "three";break;
     	case 4: 
     		result= "four";break;
     	case 5: 
     		result= "five";break;
     	case 6:  
     		result= "six";break;
      	case 7: 
      		result= "seven";break;
     	case 8: 
     		result= "eight";break;
     	case 9:  
     		result= "nine";break;
     	case 10:  
     		result= "ten";break;
     	case 11: 
     		result= "eleven";break;
     	case 12: 
     		result= "twelve";break;
    	case 13: 
     		result= "thirteen";break;
    	case 14: 
     		result= "fourteen";break;
    	case 15: 
     		result= "fifteen";break;
    	case 16: 
     		result= "sixteen";break;
    	case 17: 
     		result= "seventeen";break;
       	case 18: 
     		result= "eighteen";break;
       	case 19: 
     		result= "nineteen";break;
       	case 20: 
     		result= "twenty";break;
     		
    	default:  break;
    	}
    	
    	return result;
    }
      
      
    	
    

}

public class TimeinWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = TimeinWordsResult.timeInWords(h, m);


        bufferedReader.close();
    }
}
