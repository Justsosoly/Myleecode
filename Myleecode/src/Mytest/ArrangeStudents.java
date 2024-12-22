package Mytest;



import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class ArrangeStudentsResult {

    /*
     * Complete the 'arrangeStudents' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
    // Write your code here
        String result="NO";
        int n=a.size();
        Collections.sort(a);
        Collections.sort(b);
        int count=0;
        
        
        for(int i=0;i<n-1;i++)
        {
            int x=a.get(i);
            int y=b.get(i);    
            
            int next_x=a.get(i+1);
            int next_y=b.get(i+1);
          //  System.out.println("x="+x+" y="+y+" next_x="+next_x+" next_y="+next_y);
            
            //x=2 y=1 next_x=3 next_y=3
            
            if(x==y) 
            	{
            	
            	    count++;
            	    continue;
            	}
            
            if(x>y)
            {
                if( (next_x>=next_y)&&(next_y>=x))
                {
                    count++;
                 //   System.out.println(">count="+count);
                    continue;
                }
                else
                {
                	return "NO";
                }    
            }
            else
            if(x<y)
            {
                 if( (next_x<=next_y)&&(next_x>=y))
                 {
                     count++;
                 //   System.out.println("<count="+count);
                    continue; 
                 }
                  else
                {
                    return "NO";
                } 
  
            }  
            
            
        }
        
        if(count==n-1)
            return "YES";
        
        
        
        return result;

    }

}

public class ArrangeStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = ArrangeStudentsResult.arrangeStudents(a, b);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
