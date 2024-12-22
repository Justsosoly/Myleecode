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

class FraudulentActivityResult {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */
	//pass all the test 
	public static int activityNotifications3(List<Integer> expenditure, int d) {
		int result=0;
        int n=expenditure.size();
        List<Integer> sublist=new ArrayList<>();
        Collections.sort(sublist);
        for(int i=0;i<n;i++)
        {
            if(i<d)
            {
               sublist.add(expenditure.get(i));// 通过add，重新构建一个list，而不能直接用sublist方法
               continue; 
            }
            else
            if(i==d)
            Collections.sort(sublist);
            int cur=expenditure.get(i);
            double mean=0;                    
            
            if(d%2!=0)//odd
            {
                mean= 2*sublist.get(d/2);
            }
            else //even
            {
                mean=((sublist.get(d/2-1)+sublist.get(d/2))/2.0)*2;
            }
           if(cur>=mean)
            result++;
        //    System.out.println("current"+cur+"mean="+mean);
           sublist.remove(expenditure.get(i-d));
           int index=Collections.binarySearch(sublist, cur);
           if(index<0)      
           sublist.add(-index-1, cur);
           else
           sublist.add(index+1, cur);
        }
          System.out.println("result="+result);
        return result;
	}
	
	
	//fail 2 tests
	public static int activityNotifications(List<Integer> expenditure, int d) {
		
		 int result=0;
         int n=expenditure.size();
         
         List<Integer> sublist=expenditure.subList(0, d);
         Collections.sort(sublist);//sort will change the List expenditure,so will wrong
        
         for(int i=d;i<n;i++)
         {
             
             int cur=expenditure.get(i);
             double mean=0; 
             int m=d/2;
             
             if(d%2!=0)//odd
             {
            	 mean= 2*sublist.get(m);
             }
             else //even
             {
            	
            	 mean=sublist.get(m-1)+sublist.get(m);
            
             }
             
            if(cur>=mean)
             result++;
             
         //    System.out.println("current"+cur+"mean="+mean);
            
            sublist.remove(expenditure.get(i-d));
            
            int index=Collections.binarySearch(sublist, cur);
            
            if(index<0)  	
            sublist.add(-index-1, cur);
            else
            sublist.add(index, cur);
            
         }
           System.out.println("result="+result);
         
         return result;
		
	}
	
	
	
	
	
// fail to the time limits test
    public static int activityNotifications2(List<Integer> expenditure, int d) {
    // Write your code here
    	 int result=0;
         int n=expenditure.size();
        
         for(int i=d;i<n;i++)
         {
             
             int cur=expenditure.get(i);
             double mean=0;
             List<Integer> sublist=expenditure.subList(i-d, i);
             Collections.sort(sublist);
             
             if(d%2!=0)//odd
             {
            	 mean= sublist.get(d/2);
             }
             else //even
             {
            	
            	double sum=sublist.get(d/2-1)+sublist.get(d/2);
            	 mean=sum/2;
             }
             
            if(cur>=mean*2)
             result++;
             
         //    System.out.println("current"+cur+"mean="+mean);
            
         }
           System.out.println("result="+result);
         
         return result;
    }

}




public class FraudulentActivity {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = FraudulentActivityResult.activityNotifications(expenditure, d);


        bufferedReader.close();
    }
}
