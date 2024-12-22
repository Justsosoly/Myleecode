package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class ContactsResult {

    /*
     * Complete the 'contacts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_STRING_ARRAY queries as parameter.
     */

	
	//time limists exceeds ，the first version
    public static List<Integer> contacts2(List<List<String>> queries) {
    // Write your code here
    List<Integer> result=new ArrayList<Integer>();
    List<String> contact=new ArrayList<String>();
    for(int i=0;i<queries.size();i++)
    {
      List<String> list=queries.get(i);
      String op=list.get(0);
      String name=list.get(1);
      int count=0;
      System.out.println("operator "+op);

      if(op.equals("add"))
      {
        contact.add(name);
            System.out.println("name "+name);
      }
      if(op.equals("find"))
      {
       
    	  if(contact.size()>0)
    	  {
            for(int j=0;j<contact.size();j++)
            {
             String tempname=contact.get(j);
             if(tempname.startsWith(name))
             count++;
             }
         result.add(count);
    	  }
    	  else
    		  result.add(0);
        
      }
      
    }
     return result;
    }
    
    // the all test pass version
    public static List<Integer> contacts3(List<List<String>> queries) {
    
    List<Integer> res = new ArrayList<>();
    StringBuilder word = new StringBuilder();
    Map<String, Integer> dict = new HashMap<>();
    queries.forEach(q-> {
    	
        if (q.get(0).equals("add")) {
            String name = q.get(1);
            System.out.println("name is :"+name);
            
            for (int i = 0; i < name.length(); i++) {
                word.append(name.charAt(i));
                dict.merge(word.toString(), 1, Integer::sum);
            }
            word.setLength(0);
        } else {
            res.add(dict.getOrDefault(q.get(1), 0));
        }
        
    });
    
    return res;
    }
    
    
    //add the map by myself pass all the test
    public static List<Integer> contacts(List<List<String>> queries) {
    	 List<Integer> result=new ArrayList<Integer>();
    	 Map<String,Integer> map=new HashMap<String,Integer>();
    	  for(int i=0;i<queries.size();i++)
    	    {
    	      List<String> list=queries.get(i);
    	      String op=list.get(0);
    	      String name=list.get(1);
    	      StringBuffer tempstr=new StringBuffer();
    	      if(op.equals("add"))
    	      {
    	    	  for(int j=0;j<name.length();j++)
    	    	  {
    	    		  tempstr.append(name.charAt(j));
    	    		 if(map.get(tempstr.toString())==null)
    	    		 {
    	    			 map.put(tempstr.toString(), 1);
    	    		 }
    	    		 else
    	    		 {
    	    			 map.put(tempstr.toString(), map.get(tempstr.toString())+1);
    	    		 }	 
    	    		 
    	    		
    	    	  }
    	      }
    	      if(op.equals("find"))
    	      {
    	    	  result.add(map.getOrDefault(name,0));
    	      }
    	    } 
    	 return result;
    }

}

public class Contacts {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        for (int i = 0; i < queriesRows; i++) {
            queries.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        List<Integer> result = ContactsResult.contacts(queries);

     


        bufferedReader.close();
    }
}
