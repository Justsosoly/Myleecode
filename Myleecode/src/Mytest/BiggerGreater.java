package Mytest;


import java.io.*;
import java.util.Arrays;
import java.util.stream.*;


class BiggerGreaterResult {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */
	
	public static String biggerIsGreater(String w) {

	    char sourceArray[] = w.toCharArray();
        int n = sourceArray.length;
        int count=0;
        String result="";
        
        if(n==2)
    	{
    		if(w.charAt(0)<w.charAt(1))
    		{
    			result=String.valueOf(w.charAt(1))+String.valueOf(w.charAt(0));
    			return result;
    		}
    		else
    			return "no answer";
    			
    	}
        for(int i=n-1;i>0;i--)
        {
        	char x=w.charAt(i);
        	char y=w.charAt(i-1);
        	if(y<x)// dealing the string
        	{
        	
        	
        		result=w.substring(0,i-1);
        		char min=sourceArray[i-1];
        		int minindex=i-1;
        		int mincount=Integer.MAX_VALUE;
        		for(int j=i;j<n;j++)
        		{
        			if(sourceArray[j]>sourceArray[i-1])
        			{
        				if( (sourceArray[j]-min)<mincount);
        				{
        					mincount=sourceArray[j]-min;
        					min=sourceArray[j];
        				    minindex=j;
        					
        				}
        			}
        		}
        		sourceArray[minindex]=y;
        		sourceArray[i-1]=min;
        		Arrays.sort(sourceArray, i, n);
        		
        	
        	
        			result=String.valueOf(sourceArray);
        			return result;
        		
        	}
        	else
        	count++;	
        	
        }
        if (count==n-1)  return "no answer";
        
        
        
        
	
	     return result;
	} 
    static void swap(char charArray[], int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

	
	
	//myself 

    public static String biggerIsGreater2(String w) {
    // Write your code here
    	
    	 int n=w.length();
    	    int count=0;
    	    int flag=0;
    	    String result="no answer";
    	    char str[]=w.toCharArray();
    	    
    	    for(int i=n-1;i>0;i--)
    	    {
    	        if(w.charAt(i)<=w.charAt(i-1))   //dbca no answer
    	        {
    	            count++;
    	        }
    	        else
    	        {
    	          flag=i-1;
    	           break;
    	        }
    	        
    	    }
    	    
    	    if(count==(n-1)) return result;
    	    
    	    //dkhc  hcdk
    	   
    	    
    	    System.out.println("flag is "+flag);
    	    

    	    Arrays.sort(str,flag+1,n);
    	    
    	     System.out.println("after sort the str is "+String.valueOf(str));
    	     
    	     char min='\0';
    	     int minindex=0;
    	    for(int j=flag+1;j<n;j++)
    	    {
    	         if(str[j]>str[flag])
    	          {
    	            min=str[j];
    	            minindex=j;
    	            break;
    	          }
    	    }
    	    
    	   
    	     
    	     System.out.println("the min is "+min);
    	     
    	    char temp= str[flag];
    	    
    	    str[flag]=min;
    	    str[minindex]=temp;
    	    
    	   System.out.println("the exchange str is "+String.valueOf(str));
    	   
    	  Arrays.sort(str,flag+1,n);
    	  
    	        result=new String(str);
    	     System.out.println("the result is "+result);

    	    return result;
    
    }

}

public class BiggerGreater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = BiggerGreaterResult.biggerIsGreater(w);

       
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
