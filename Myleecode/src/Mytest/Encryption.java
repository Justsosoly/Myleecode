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

class EncryptionResult {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
    	String result="";
        int n=s.length();
        int row=(int)Math.floor(Math.sqrt(n));
        int column=	(int)Math.ceil(Math.sqrt(n));
  
    	
    	
    	String onerow="";
    	
    	if(row*column<n)
    		row++;
      	char arr[][]=new char[row][column];
    	//form the fist matrix
    	for(int i=0;i<row;i++)
    	{	
    		
    		if((i+1)*column<n)
    {
    	 onerow=s.substring(i*column, (i+1)*column);
	}
    		else
    			onerow=	s.substring(i*column);	
    		
    		for(int j=0;j<column;j++)
    		{
    		 
    			if(j>(onerow.length()-1))
    			{
    				arr[i][j]='\0';
    			}
    			else
   
    			arr[i][j]=onerow.charAt(j);
    			
    		}
    	
    	}
    	//
    	for (int j=0;j<column;j++)
    	{
    		for(int i=0;i<row;i++)
    		{
    			if(arr[i][j]!='\0')
    			result+=arr[i][j];
    		}
    		if(j!=column-1)
    		result+=" ";
    	}
    	
       return result;
    }

}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        
        String result = EncryptionResult.encryption(s);

        bufferedReader.close();
    }
}
