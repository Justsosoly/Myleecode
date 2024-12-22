package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class TripleSumResult {

    /*
     * Complete the 'triplets' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     *  3. INTEGER_ARRAY c
     */

    public static long triplets(List<Integer> a, List<Integer> b, List<Integer> c) {
      long result=0;
      Collections.sort(a);
      Collections.sort(b);
      Collections.sort(c);
      
      
      for(int j=0;j<b.size();j++)
      {
            Integer q=b.get(j);
          //这个判断就是去重复
         if( j<(b.size()-1) )//最后一个不管
         {
          Integer qnext=b.get(j+1);
       //   System.out.println("q="+q+" qnext="+qnext);
          if(q==qnext) continue; //和前一个元素相同则跳过下面，从下一个开始
         }
         
        long numa=0;
        long numc=0;
        int i=0;
        int k=0;
        
        //重第一个数组a开始找小于b数组里的q的数的个数
         while(i<a.size()&&a.get(i)<=q)
         {
           if( i< (a.size()-1) ) //去掉最后的那个
           {
        	   if(a.get(i)==a.get(i+1))//去重
        	   {        		   
        		   i++;   //跳过这个重复的元素，直接去下一个
        		   numa=i-1; //其实numa不变
        		   continue; 
        	   } 
           }
           i++;
           numa=i;//从1开始
         }
         
         while(k<c.size()&&c.get(k)<=q)
         {
           if(k< ( c.size()-1))
           {
        	   if(c.get(k)==c.get(k+1))
        	   {
        		   k++;
            	   numc=k-1;
            	   continue;
        	   }
           }
           k++;
           numc=k;
         }
        result+=(long)numc*(long)numa;
      }
      System.out.println(result);
      
      return result;
    }

}

public class TripleSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int lena = Integer.parseInt(firstMultipleInput[0]);

        int lenb = Integer.parseInt(firstMultipleInput[1]);

        int lenc = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> arra = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> arrb = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> arrc = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        long ans = TripleSumResult.triplets(arra, arrb, arrc);


        bufferedReader.close();
    }
}
