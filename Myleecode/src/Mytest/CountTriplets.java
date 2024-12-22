package Mytest;


import java.io.*;
import java.util.*;


public class CountTriplets {

    // Complete the countTriplets function below.
	
	//others code pass all the test
	  static long countTriplets3(List<Long> arr, long r) {
	
	  HashMap<Long, Long> right = new HashMap<>();
      HashMap<Long, Long> left = new HashMap<>();
      
      for (Long num : arr) {
          right.put(num, right.getOrDefault(num, 0L) + 1);
      }
      
      long tripletsCounter = 0;
      
      for (Long num : arr) {
          if (right.getOrDefault(num, 0L) > 0) {
              right.put(num, right.get(num) - 1);
          }
          if (num % r == 0) {
              tripletsCounter += right.getOrDefault(num * r, 0L) * left.getOrDefault(num / r, 0L);
          }
          left.put(num, left.getOrDefault(num, 0L) + 1);
      }
      
      return tripletsCounter;
}
	  
	  
	  static long countTriplets(List<Long> arr, long r) {
		  HashMap<Long, Long> rightmap = new HashMap<>();
          HashMap<Long, Long> leftmap = new HashMap<>();
           long result=0;
          int n=arr.size();
          for(int i=1;i<n;i++)
          {    
            long key=arr.get(i);
                if(rightmap.get(key)==null)
                {
                    rightmap.put(key, 1L);
                }
                else
                {
                    rightmap.put(key, rightmap.get(key)+1);
                }
          }
          for(int j=1;j<n;j++)
          {
              long element=arr.get(j);
              long last_element=arr.get(j-1);
               long pre_element=0;// 
              long post_element=0;
              if(element%r==0)
              {
               pre_element=element/r;// 
               post_element=element*r;
              }
              long left=0;
              long right=0;
              
              //delete rightmap
              if(rightmap.get(element)!=null)
                   {
                   if(rightmap.get(element)>1)
                    rightmap.put(element, rightmap.get(element)-1);
                   else if(rightmap.get(element)==1)
                   rightmap.remove(element);
                   }
               //add leftmap    
               if(leftmap.get(last_element)==null)
                   {
                       leftmap.put(last_element, 1L); 
                   }
                   else
                   {
                       leftmap.put(last_element, leftmap.get(last_element)+1);
                   }
          if(leftmap.get(pre_element)!=null)//have the left 
              {
                  left=leftmap.get(pre_element);
              }
              
              if(rightmap.get(post_element)!=null&&rightmap.get(post_element)>=1)//have the right
              {
                right=rightmap.get(post_element);
              }
              result+=left*right;
          }//end for
         return result;
		  
	  }
	
    static long countTriplets2(List<Long> arr, long r) {
      
       long  result=0;
       int size=arr.size();
       int n=(int)Math.ceil(Math.pow(arr.get(size-1),1.0/r));
     //  System.out.println("size="+size);
       HashMap<Long,Long> map=new HashMap<>();
       
       for(int i=0;i<size;i++)
       {
         long key=arr.get(i);
         if(map.get(key)==null)
         {
             map.put(key, 1L);
         }
         else
         {
             map.put(key, map.get(key)+1);
         }
           
       }
       if(size>3)
       {       
           if(r==1)
         {
        	   long nsize=map.get(r);
               result=combination(3,nsize);
         //  result=combination(3,size);
          // result=combination(2,6);
           System.out.println("r=1 result="+result);
        	   
        	   
         }
       
       else
       {
       
         for(int j=0;j<=n-2;j++)
         {
             long x=(long)Math.pow(r, j);
             long y=(long)Math.pow(r,j+1);
             long z=(long)Math.pow(r,j+2);
             System.out.println("x="+x+"y="+y+"z="+z);
             
         if(map.get(x)!=null&&map.get(y)!=null&&map.get(z)!=null)
             {
                result+=  map.get(x)*map.get(y)*map.get(z);
             }
             System.out.println("result="+result);
         }
       
        }
        
      }
       return result;
    }
  //  n!/(n-m)!=n*(n-1)*(n-2)……(n-m+1)
  static long arrangement(long m,long n)
  {
      long re=1;
      
      for(long i=m;i>0;i--)
      {
         re=n*re;
         n--;
      }
      
      return re;
  }
  
  //A(n,m)/A(m,m)
  static long combination(long m,long n)
   {
	 long re=1;
	 long numerator=arrangement(m,n);
	 long denominator=arrangement(m,m);
	 
	 
     return numerator/denominator;
   }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);


        bufferedReader.close();
    }
}
