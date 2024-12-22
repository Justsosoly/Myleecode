package Mytest;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Pangrams {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams2(String s) {
        
    // Write your code here
   
    int count=0;
    int abc[]=new int[26];
    for(int j=0;j<26;j++)
     abc[j]=0;
    
    for(int i=0;i<s.length();i++)
    {
        char temp=s.charAt(i); 
        if(temp>='A'&&temp<='Z')
        {
         int index=temp-'A';
         abc[index]++;
        }
        if(temp>='a'&&temp<='z')
        {
        int index=temp-'a';
         abc[index]++;	
        }
        
    }
    for(int m=0;m<26;m++)
    {
       
        
        if(abc[m]>0)
        {
          count++;  
        }
               
    }
     
     
     if(count==26)
     {
    	 System.out.println("pangram");
     return "pangram";
     }
    else 
    {
    	 System.out.println("not pangram");
    return "not pangram";
    }
    
    }

    
    public static String pangrams(String s) {
 
    	
    	Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<s.length();i++)
        {
          char letter=s.charAt(i);
          String le="";
          
          if(letter>='A'&&letter<='Z'||letter>='a'&&letter<='z')
          {
          
          if(letter>='A'&&letter<='Z')
          le= String.valueOf(letter).toLowerCase() ;
        
          else
          if(letter>='a'&&letter<='z')
    	   le=String.valueOf(letter);
          
       
         if(map.get(le)==null)             // first put to the map
         {
              map.put(le,1);
         } 
         else //not the first put to map
        {
          map.put(le,map.get(le)+1);
        }
        
          }
         
        }//end for
        
        
        
        
        
        /*
        Iterator<Map.Entry<String,Integer>> it=map.entrySet().iterator();
        while(it.hasNext())
        {
            
        	Map.Entry<String, Integer> entry=it.next();
        	
        	System.out.println("key:"+entry.getKey());
            System.out.println("value:"+entry.getValue());
        }
        */
       
        int count=0;
        
        /*
        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
        	String key=entry.getKey();
        	int value=entry.getValue();
        	
        }
        */
        
        if(map.size()==26) 
		return "pangram";
        else
        return "no pangram";
	}
    



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Pangrams.pangrams(s);

    //    bufferedWriter.write(result);
    //    bufferedWriter.newLine();

        bufferedReader.close();
   //     bufferedWriter.close();
    }

}