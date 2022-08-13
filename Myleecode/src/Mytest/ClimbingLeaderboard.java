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

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
    List<Integer> playerflag=new ArrayList<Integer>();
    List<Integer> flag=new ArrayList<Integer>();
    int count=1;
    int rankednum=ranked.size();
    int playernum=player.size();
    int n=rankednum+playernum;
   
    //flag reflects the ranked list ranking.like 1,2,2,3
    flag.add(0, count);
 //   System.out.println("the fault leaderboard is"+flag.get(0));
    for(int m=1;m<rankednum;m++)
    {
      if(ranked.get(m)<ranked.get(m-1))
      {
          count++;    
      }  
      flag.add(m,count);
      
  //    System.out.println("the fault leaderboard is"+flag.get(m));
      
    }
    
    
    int left=0;
    int right=rankednum-1;
  
    for(int p=0;p<playernum;p++)
 
    {
    	int target=player.get(p);
    	int temp=searchBinary(ranked,target,left,right);
    	
    	if(temp!=-1) //find the target
    	{
    		playerflag.add(p,flag.get(temp));
    	}	
    	
    	else
    		if(temp==-1)//not find the target
    	{
    		int index=searchBinaryright(ranked,player.get(p),left,right);    
    		if(index==-1) playerflag.add(p,1);
    		
    		else 
    			playerflag.add(p,flag.get(index)+1);
    			
    	}
    	
    	
    	
    	
    }
   
    
    for(int temp:playerflag)
    	
    	System.out.println("the new ranking is "+temp);
    /*
    for(int j=0;j<playernum;j++)
    {
    	
    	for(int i=0;i<rankednum;i++)
    	
    	{
    		if(player.get(j)>=ranked.get(i))
    			
    		{
    			int temp= flag.get(i);
    			playerflag.add(j,temp);
    			break;
    			
    		}
    		else if(i==(rankednum-1))
    		{
    			int temp=flag.get(rankednum-1)+1;
    			playerflag.add(j,temp);
    		}
    		
    		
    	}
    	
    }	
    */
    
  
    
    
    
    
     return playerflag;
    }
    
	    static int searchBinary(List<Integer> ranked,int target,int left,int right)
	    {
	    	
	    	while(left<=right)
	    	{
	          int mid=(left+right)/2;
	    	  
	          if(target==ranked.get(mid))
	        	return mid;  
	          if(target <ranked.get(mid))//right area
	    		left=mid+1;
	    	  if(target >ranked.get(mid))//right area
	    		right=mid-1;
	    	  
	    		
	    	}
	    	
	    	return -1;
	    	
	    }
    
	    
	    static int searchBinaryright(List<Integer> ranked,int target,int left,int right)
	    {
	    	
	    	while(left<=right)
	    	{
	          int mid=(left+right)/2;
	    	  
	          if(target==ranked.get(mid))
	        	return mid;  
	          if(target <ranked.get(mid))//right area
	    		left=mid+1;
	    	  if(target >ranked.get(mid))//right area
	    		right=mid-1;
	    	  
	    		
	    	}
	    	
	    	return right;
	    	
	    }

}




 class ClimbingLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedReader.close();
    }
}
