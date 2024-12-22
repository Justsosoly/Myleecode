package Mytest;



import java.io.*;
import java.util.*;


class SherlockValidStringResult {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
    HashMap<String,Integer> map=new HashMap<String,Integer>();
   
    HashMap<Integer,Integer> nummap=new HashMap<Integer,Integer>();
    List<Integer> listkey=new ArrayList<Integer>();
    List<Integer> listvalue=new ArrayList<Integer>();
      for(int i=0;i<s.length();i++)
      {
          String temp=String.valueOf(s.charAt(i));
          if(map.get(temp)==null)
           {
               map.put(temp, 1);
           }
           else
           {
               map.put(temp, map.get(temp)+1);
           }
          
      }
      int num[][];
   
      
       for(String key:map.keySet())
       {
    	  int value= map.get(key);
    	   
    	   if(nummap.get(value)==null)
    		   nummap.put(value,1);
    	   else
    		   nummap.put(value, nummap.get(value)+1);
    	   
       }
      
       switch (nummap.size())
       {
         case 1: return "YES";
         case 2://if delete one letter,could be the YES
         {
        	 int [][]frequency=new int[2][2];
             int i=0;
             
      	for(Integer key:nummap.keySet())
      	{
      		frequency[i][0]=key;
      		frequency[i][1]=nummap.get(key);
      		i++;
      		if(key==1&&nummap.get(key)==1)
      		{
      			return "YES";
      		}
      	}
      	
      	
  
      	if( Math.abs( frequency[0][0]-frequency[1][0] )==1   )
      	{
      		if(frequency[0][1]==1||frequency[1][1]==1)
      		return "YES";
      	}
      	else
      		return "NO";
        	 
        	 
        	 
        	 
         }  
         
        default:  return "NO";
       
       }
    }

}

public class SherlockValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = SherlockValidStringResult.isValid(s);

  

        bufferedReader.close();
    }
}
