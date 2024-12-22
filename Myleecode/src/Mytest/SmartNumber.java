package Mytest;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SmartNumber {
	
	//success part java 7 change 1 line

    public static boolean isSmartNumber(int num) {
        int val = (int) Math.sqrt(num);    
      
        if(num==val*val)
            return true;
        return false;
    }
    
    
    
    
    public static void main(String[] args) {
        int test_cases;
        Scanner in = new Scanner(System.in);
        test_cases = in.nextInt();
        int num;
        for(int i = 0; i < test_cases; i++){
            num = in.nextInt();
            boolean ans = isSmartNumber(num);
            if(ans){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }

	/*
	 public static void main(String[] args) {
	        Scanner scan=new Scanner(System.in);
	        int n=scan.nextInt();
	         for(int i=0;i<n;i++)
	         {
	        	 int number=scan.nextInt();
	           
	          isSmartNum(number);
	             
	         }
	    
	    }
	    public static void  isSmartNum(int num)
	    {
	        boolean isSmart=false;
	        
	        double  temp=Math.sqrt(num);
	        
	          if((int)temp*temp==num)
	              isSmart=true;
	         else
	              isSmart=false;
	        
	        if(isSmart)
	           System.out.println("YES");
	        else
	           System.out.println("NO");
	    }
	    */
	
}



