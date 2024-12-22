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



class AnagramResult {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
    // Write your code here
      int result=0;
      int n=0;
      int max=0;
      Map<String,Integer> premap=new HashMap<String,Integer>();
      Map<String,Integer> lastmap=new HashMap<String,Integer>();
    
      
      if(s.length()%2!=0) return -1;//奇数的字符串就不用考虑了
      else
      {
        n=s.length()/2;
          for(int i=0;i<n;i++)
          {
            String pre=String.valueOf(s.charAt(i));
            String last=String.valueOf(s.charAt(i+n));
          
            if(premap.get(pre)==null)
            {
              premap.put(pre, 1);
            }
            else
            premap.put(pre, premap.get(pre)+1);
            
            
            if(lastmap.get(last)==null)
            {
              lastmap.put(last, 1);
            }
            else
            lastmap.put(last, lastmap.get(last)+1);
          }
          
    
        
  
         for(String key:premap.keySet())// premap里没有的则不会进行计数
         {
        	if( lastmap.get(key)!=null)//lastmap里没有的则也进行计数
        	 
        	 result+= Math.min(premap.get(key),lastmap.get(key));
        	
         }
      }
      return n-result;

    }

}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = AnagramResult.anagram(s);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
