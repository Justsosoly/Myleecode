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

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	   List<Integer> result=new ArrayList<>();
           long n=queries.size();
           HashMap<Long,Long> map=new LinkedHashMap<>();// use the LinkedHashMap could pass the test 11 time limits
           
           for(int i=0;i<n;i++)
           {
               long op=queries.get(i).get(0);
               long key=queries.get(i).get(1);
               
               if(op==1)
               {
                   if(map.get(key)==null)
                   {
                     map.put(key,1L);  
                   }
                   else
                   {
                      map.put(key, map.get(key)+1);    
                   }
               }
               if(op==2)
               {

                     if(map.get(key)!=null&&map.get(key)==1)
                   {
                     map.remove(key);  
                   }
                    else if(map.get(key)!=null&&map.get(key)>1)
                   {
                      long temp=map.get(key);
                      map.remove(key); 
                      map.put(key, temp-1);
                   }
                   
               }
               if(op==3)
               {

                 if( map.containsValue(key))
                  result.add(1);
                  else
                  result.add(0);
               }
           }
           
           return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedReader.close();
    }
}
