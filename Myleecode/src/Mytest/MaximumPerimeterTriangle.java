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

class MaximumPerimeterTriangleResult {

    /*
     * Complete the 'maximumPerimeterTriangle' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY sticks as parameter.
     */

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
    // Write your code here
    List<Integer> result=new ArrayList<Integer>();
    List<Integer> triangle=new ArrayList<Integer>();
    Collections.sort(sticks);
    
    for(int i=sticks.size()-1;i>=0;i--)
      {
      
        triangle.add(sticks.get(i));
        System.out.print(sticks.get(i));
        for(int j=i-1;j>=0;j--)
        {
          triangle.add(sticks.get(j));
           System.out.print(sticks.get(j));
           for(int k=j-1;k>=0;k--)
            {
              triangle.add(sticks.get(k));
              System.out.println(sticks.get(k));
              if(triangle.size()>2)
              {
              int a=triangle.get(0);
              int b=triangle.get(1);
              int c=triangle.get(2);
    
              if(  ((a+b)>c)&&((a+c)>b)&&((b+c)>a) )
              {
                result=triangle;
                Collections.sort(result);
                return result;
              }
              }
              triangle.remove(2);
            } 
        triangle.remove(1);
        }

          triangle.remove(0);
      }
      
      
    result.add(-1);
     return result;
    }

}

public class MaximumPerimeterTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sticks = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = MaximumPerimeterTriangleResult.maximumPerimeterTriangle(sticks);


        bufferedReader.close();
    }
}
