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

class TwoCharacterResult {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
    // Write your code here
    	int length=0;
    	char c[]=new char[s.length()];
    	int index=0;
    	
    	if(s.length()==2) return 2;
    	
    	//找出所有的字母数组放入c[index]中
    	for(int i=0;i<s.length();i++)
    		for(int j=0;j<c.length;j++)
    		{
    			if(s.charAt(i)!=c[j]&&c[j]==0)
    			{
    				c[index]=s.charAt(i);
    				index++;
    				break;
    			}		
    			else 

    				if(s.charAt(i)==c[j])//相同则跳出本次循环
    				break;
    		}	 
    	
    	int flag=0;
    	
    		
    	for(int x=0;x<index;x++)
    		for(int y=x+1;y<index-1;y++)
    	
    	{  
    			char a=c[x];
    	        char b=c[y];
    	        String temp="";
    	        
    	        for(int p=0;p<s.length();p++)
    	        {
    	        	if(s.charAt(p)==a||s.charAt(p)==b)
    	        	{
    	        		temp=temp+s.charAt(p);
    	        	}
    	        }
    	        int z=0;
    	        z=TwoCharacterResult.judgeAlt(temp);
    	        System.out.print(temp);
    	        System.out.println(z);
    	        if(z>flag) flag=z;
    	        else
    	        	continue;
    			  
    				  
    			  
    	
    	}
    
    	
       length=flag;
    	
    	return length;

    }


   public static int judgeAlt(String str)
   {
	   int length=2;
	   
	   for(int i=0;i<str.length()-2;i++)
	   {
		   if(str.charAt(i)==str.charAt(i+2))
			   length++;
		   else
			   break;
		   
	   }
	   
	  if(length<str.length()) return 0;
	   
	  else return length;
   }



}



public class TwoCharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = TwoCharacterResult.alternate(s);


        bufferedReader.close();
    }
}
