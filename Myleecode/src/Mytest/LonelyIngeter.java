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






public class LonelyIngeter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = LonelyIngeter.lonelyinteger(a);

     //   bufferedWriter.write(String.valueOf(result));
     //   bufferedWriter.newLine();

        bufferedReader.close();
    //    bufferedWriter.close();
    }
    
    
    public static int lonelyinteger(List<Integer> a) {
    // Write your code here
    int n=a.size();
    int lonely=0;
    String [] flag=new String[n];//1 means the longly
    for(int i=0;i<n;i++)
    {
         lonely=a.get(i);
        for(int j=i+1;j<n;j++)
        {
            if(flag[j]!=null &&flag[j].equals("duplicate")) continue;
            
            else if(a.get(j).intValue()==lonely)//not the unique
            {
                flag[i]="duplicate";
                flag[j]="duplicate";
                continue;
            } 
  
        }
        
    }
    
    for(int m=0;m<n;m++)
    {
     if(flag[m]==null)
          lonely=a.get(m);
    }
    System.out.print(lonely);
    
    
    
     return lonely;
    }
}


