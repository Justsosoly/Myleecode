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

class DynamicArrayResult {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
    List<Integer> result=new  ArrayList<Integer>();

    List<String> r=new  ArrayList<String>();

    List<List<Integer>> arr=new ArrayList<>(n);
    for(int j=0;j<n;j++)
    arr.add(new ArrayList<Integer>());
    
     int lastAnswer=0;
     
     for(int i=0;i<queries.size();i++)
     {
     List<Integer> list=queries.get(i);
     int index=list.get(0);
     int x=list.get(1);
     int y=list.get(2);
     int idx=0;
         if(index==1)
         {
           idx=(x^lastAnswer)%n;
         //  if( !arr.isEmpty())
           arr.get(idx).add(y);
//           else
//           {
//        	   List<Integer> templist=new  ArrayList<Integer>();
//        	   templist.add(y);
//              arr.add(idx, templist);
//           }
         }
         if(index==2)
         {
           idx=(x^lastAnswer)%n;
           lastAnswer=arr.get(idx).get(y%arr.get(idx).size());
           result.add(lastAnswer);
         }
     
     
     }
     
    return result;
    }

}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

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

        List<Integer> result = DynamicArrayResult.dynamicArray(n, queries);


        bufferedReader.close();
    }
}
