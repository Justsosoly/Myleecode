package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialStringagain{

    // Complete the substrCount function below.
	
	//can't pass the time limits tests, beacause of the String 
    static long substrCount2(int n, String s) {
          int result=0;
          for(int i=0;i<n-1;i++)
          {
              char x=s.charAt(i);
             String str=String.valueOf(x);
              for(int j=i+1;j<n;j++)
              {
                 char y=s.charAt(j);
                
                 
                 
                 
                 str+=String.valueOf(y);
                 int strlen=str.length();
                 String prestr="";
                 String poststr="";
                
          if(x==y)
          { 
                		 
       System.out.println("str is="+str);
       
       if( strlen%2==0 ) //str size is even
       {
    	   prestr=str.substring(0, strlen/2) ;
    	   poststr=str.substring(strlen/2,strlen);
       }
       
       else //str size is odd
       {
    	   prestr=str.substring(0, (strlen)/2) ;
    	   poststr=str.substring((strlen)/2+1,strlen);
       }	   
       
         if(prestr.equals(poststr))
        	 result++;    
               
          }
              
          }
          }
          result=n+result;
          return result;
 
    }
    
    
    static long substrCount(int n, String s) {
    	

        int result=0;
    for(int i=0;i<n-1;i++)
    {
        char x=s.charAt(i);
     
        for(int j=i+1;j<n;j++)
        {
           char y=s.charAt(j);
           if(x==y)
           result++;
           else
           {
             int end=j*2-i;
              System.out.println("i="+i+"j="+j+"end="+end);  
              System.out.println("pre="+s.substring(i, j));
         //     System.out.println("post="+s.substring(j+1, end+1));
          if(end<n&&s.substring(i, j).equals(s.substring(j+1, end+1)))
               {
      System.out.println("pre="+s.substring(i, j)+" post="+s.substring(j+1, end+1));
                  result++; 
              
               }
          break;// if x!=y, and not the middle same, s can't be the meet the need
           }      
               
        }
        
    }
  
  return result;
    
    	 
    	
    }
    
    
    
    static boolean isSame(String str)
    {
        boolean flag=true;
        char x=str.charAt(0);
     
         
        for(int i=1;i<str.length();i++)
        {
            char y=str.charAt(i);
            if(x!=y)
            return false;
        }
        System.out.println("is Same");
        
        return flag;
        
    }
      static boolean isMiddlesame(String str)
      {
          boolean flag=true;
          int n=str.length();
          if(n%2==0) return false;
          else
          {
            char x=str.charAt(0);
            for(int i=1;i<n;i++)
            {
              char y=str.charAt(i);
              if(x!=y&&i!=n/2)
              {
                 System.out.println(i+"false,n/2="+n/2);
                return false;
              }  
                
            }
            
              
          }
          
            System.out.println("is Middle Same");
        
          return flag;
      }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);


        scanner.close();
    }
}
