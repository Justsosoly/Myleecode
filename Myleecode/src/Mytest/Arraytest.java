package Mytest;

public class Arraytest {

	public static void main(String args[])
	{
	  
		int input[]= {0,0};
		Arraytest arrt=new Arraytest() ;
		arrt.findMaxConsecutiveOnes(input);
		
	}
	 


//Given a binary array nums, return the maximum number of consecutive 1's in the array.
  
	public int findMaxConsecutiveOnes(int[] nums) {
        int x=0;
        int i=0;
        int count=0;
        int maxsame=0;
  
        if(nums.length==1) 
        	if(nums[0]==1) return 1;
        	else return 0;
        else
        {
  		for(i=0;i<nums.length;i++)
  		{    
  			 x=nums[i];
  			 if(x==1) 
  				{
  				count++;
  				if (maxsame<count)
  			  	maxsame=count; 
  				}
  			
  			
  			else if(x==0)
  			{	 
  			      count=0;
  			}
  		
  		}//end for i
        }//end for if 个数大于1
  		System.out.println("the same number is "+maxsame);
  	
  		
    	return maxsame;
                          }
    
    
}




