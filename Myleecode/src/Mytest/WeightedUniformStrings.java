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

class WeightedUniformStringsResult {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> weightedUniformStrings(String s, List<Integer> queries) {
    // Write your code here
    	//test2 fail
    	
    	List<Integer> weight=new ArrayList<Integer>();
    	List<String> result=new ArrayList<String>();
    	Map<String,Integer> charmap=new HashMap<String,Integer>();
    	
    	for(int j=0;j<s.length();j++)
    	{
    		String stemp=String.valueOf(s.charAt(j));
    		
    		if(charmap.get(stemp)==null)
    		{
    			charmap.put(stemp,1);
    			
    		}
    		else
    		{
    			charmap.put(stemp, charmap.get(stemp)+1);
    		}
    		
    	}
    	
    	for(String key:charmap.keySet())
    	{
    		int value=charmap.get(key);
    		
    		while(value>0)
    		{
    		 int weightvalue=(key.charAt(0)-'a'+1)*value;
    		 weight.add(weightvalue);
    		 value--;
    		}
    	}
    	
    	return weight;
    /*
    	for(int i=0;i<queries.size();i++)
    	{
    		if(weight.contains(queries.get(i)))
    		{
    			result.add("Yes");
    			//System.out.print("Yes");
    		}
    		else
    			{
    			result.add("No");
    			// System.out.print("No");
    			}
    		
    	}
    	
         return result;
       */
       
    }
    
    
    public static List<Integer> weightedUniformStringsother(String s, List<Integer> queries) {
    	
    	  List<Integer> allWeights = new ArrayList<Integer>();
          int current = 0;
          for(int i=0; i<s.length(); i++) {
              if (i == 0 || s.charAt(i) != s.charAt(i-1)) {
                  current = s.charAt(i)-'a'+1;
                  allWeights.add(current);
              } else if (s.charAt(i) == s.charAt(i-1)) {
                  current += s.charAt(i)-'a'+1;
                  allWeights.add(current);
              }
          }
          return allWeights;
          /*
          List<String> result = new ArrayList<>(queries.size());
          for(Integer query: queries) {
              if (allWeights.contains(query)) {
                  result.add("Yes");
              } else {
                  result.add("No");
              }
          }
          return result;
          */
    }

}

public class WeightedUniformStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = WeightedUniformStringsResult.weightedUniformStrings(s, queries);
        List<Integer> resultright = WeightedUniformStringsResult.weightedUniformStringsother(s, queries);
      //  Collections.sort(result);
     //   Collections.sort(resultright);
        
        for(int i=0;i<result.size();i++)
        {
        	if(!resultright.contains(result.get(i)))
        		System.out.println("没有这个数"+result.get(i));
        }
     

        bufferedReader.close();
    }
}
