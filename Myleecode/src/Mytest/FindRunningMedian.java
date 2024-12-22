package Mytest;


import java.io.*;
import java.util.*;


class FindRunningMedianResult {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
  //can't pass all the test,time limits
    public static List<Double> runningMedian2(List<Integer> a) {
    // Write your code here
    int n=a.size();
    List<Double> result=new ArrayList<Double>();
    List<Integer> sortlist=new ArrayList<Integer>();
    
    sortlist.add(a.get(0));
    result.add((double)a.get(0));
     for(int i=1;i<n;i++)
     {
    	 sortlist.add(a.get(i));
    	 
    	 Collections.sort(sortlist); //每次插入一个元素并排序
    	 
    	 if((i+1)%2==0)
       {
        
        Integer x=sortlist.get(((i+1)/2)-1);
         Integer y=sortlist.get(((i+1)/2)); 
        
         
         double d=(double)(x+y)/2;
        //  System.out.println("x:"+x);
         //  System.out.println("y:"+y);
           System.out.println(d);
          result.add(d);
       }
       else
       {
    	   
    	 double c=(double)sortlist.get(i/2);
         System.out.println(c);
         result.add(c);
       }
       
       
     }
     return result;
    }
    
    
    //pass all the test
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        int n=a.size();
        List<Double> result=new ArrayList<Double>();
        List<Integer> sortlist=new ArrayList<Integer>();
        
        sortlist.add(a.get(0));
        result.add((double)a.get(0));
         for(int i=1;i<n;i++)
         {
        	int index=Collections.binarySearch(sortlist, a.get(i));
        	if(index<0)//all the element's index <0,beacause has't insert into the sortlist
        	{
        		index=Math.abs(index)-1;
        		
        	}

        	
        	sortlist.add(index, a.get(i));
        	 
        	 
        	 if((i+1)%2==0)
           {
            
            Integer x=sortlist.get(((i+1)/2)-1);
             Integer y=sortlist.get(((i+1)/2)); 
            
             
             double d=(double)(x+y)/2;
            //  System.out.println("x:"+x);
             //  System.out.println("y:"+y);
               System.out.println(d);
              result.add(d);
           }
           else
           {
        	   
        	 double c=(double)sortlist.get(i/2);
             System.out.println(c);
             result.add(c);
           }
           
           
         }
         return result;
        }

}

public class FindRunningMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = FindRunningMedianResult.runningMedian(a);

       


        bufferedReader.close();
     
    }
}
