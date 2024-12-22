package Mytest;

public class JumpGame {
	
	
	public static void main(String args[])
	
	{
		
		int[] nums=new int[] { 7,0,9,6,9,6,1,7,9,0,1,2,9,0,3 };
 
		jump(nums);
		
		
	}
	


	    public static int jump(int[] nums) {
	         
	        int result=0; 
	        int n=nums.length;
	        int max_length=0;
	        int step_end=0;

	        if(n==1) return 0;
	        if(max_length>=n-1) return result;

	        int reachable=0;

	        for(int i=0;i<n;i++)
	        {
	          int cur=nums[i];
	          
	          
	          max_length--;
	          
	          max_length=Math.max(max_length,cur);
	          
	          System.out.println("i="+i+" max_length="+max_length);
	          
	          step_end=i+max_length;
	        
	          reachable=Math.max( (i+max_length) , reachable );

	          System.out.println("i="+i+" reachable="+reachable);

	         if ( reachable>0 )

	          {
	        	 step_end=reachable;
	              
	              if(i<=step_end)
	              {
	                
	              }
	          
	          } 
	 
	        
	           
	                 
	           if(reachable>=n-1)
	           {
	      
	            break;
	           }

	        }//end for

	        return result;
	        
	    }
	}
	


