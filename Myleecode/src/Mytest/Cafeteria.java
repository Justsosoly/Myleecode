package Mytest;

import java.util.Arrays;
import java.util.HashMap;

//Write any import statements here

public class Cafeteria {

	public static void main(String args[])
	
	
	{
		/*
		long []S= {2,6};
		
		getMaxAdditionalDinersCount(10,1,2,S);
		*/
		
		long []S= {11,6,14};
		getMaxAdditionalDinersCount(15,2,3,S);
		
		
	}
	
	
public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
 // Write your code here
 
 
 Arrays.sort(S);
 
 long result=0;
 
 HashMap<Long,Integer> sitmap=new HashMap<Long,Integer>();
 
 long flag[]=new long[(int)N];
 
 /*
 for(int j=0;j<N;j++)
 {
   
   flag[j]=0;
 }
 */
 
 for(int p=0;p<M;p++)
 {
	 
	 flag[(int) (S[p]-1)]=1;
	 
 }
 
 

   long start=S[0];
 
   for(int i=0;i<M;i++)
   {
     
     long diner=S[i];
     long nextdiner=0L;
     long prediner=0L;
     
     //calculator the next diner, if is the last one then go to the first 
     if(i==M-1)
    	 nextdiner=S[0];
    else
         nextdiner=S[i+1];
     
     //calculator the pre diner
     
     if(i-1<0)
    	 prediner=S[M-1];
     else
    	 prediner=S[i-1];
     
     
     //calculator the next right position if larger than N, go to the first  
     int right=(int)((diner+K)%N+1);
    
     int left=0; 
       
     // if the left small than 1th, then go to the last one
     if((diner-K-1)<=0)
        left=(int) ((diner-K)+N-1);
        else
        left=(int) (diner-K-1); 
     
     System.out.println("i="+i);
    
     //(nextdiner-K)<0 return the left one 
     if( flag[right-1]==0 && right< ( (nextdiner-K)<0 ? (nextdiner-K+N):(nextdiner-K) ))// can sitdown
     {
         
       
       result++;
       flag[right-1]=1;
        System.out.println("sit right="+right);
     
     }
     
     
     if(flag[left-1]==0 && left>(prediner+K)%N)
      {
          result++;
        flag[left-1]=1;
        System.out.println("sit left="+left);
      }   
     
     
       
     
     
   }//end for i
   
 
 return result;
}

}
