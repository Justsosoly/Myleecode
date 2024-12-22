package Mytest;

public class ReversetoMakeEqual {

	  // Add any helper functions you may need here
	  

	  boolean areTheyEqual(int[] array_a, int[] array_b) {
	    // Write your code here
	    
		  boolean flag=true;
		  
	    int n=array_a.length;
	    
	    int start=0;//开始不相同就标记+1
	    int end=n-1;
	    
	    for(int i=0;i<n;i++)
	    {
	     
	    	Integer x=array_a[i];
	    	Integer y=array_b[i];
	    	
	    	System.out.println("x="+x+" y="+y);
	    	
	    	if(x!=y)
	    	{
	    	  start=i;
	    	  break;
	    	}
	    }
	    
	    
	    for(int j=n-1;j>=0;j--)
	    {
	     
	    	Integer x=array_a[j];
	    	Integer y=array_b[j];
	    	
	    	System.out.println("x="+x+" y="+y);
	    	
	    	if(x!=y)
	    	{
	    	  end=j;
	    	  break;
	    	}
	    }
	    

	    
	 /*
	     {1, 2, 3, 4, 4, 5, 6, 7};
	     {1, 6, 5, 4, 4, 3, 2, 7};
	     n=8,
	     start=1,
	     end=6	  
	  */
	    		
	    int k=start;

	    for(k=0;k<=end-start;k++)
	    {
	    	Integer p=array_a[start+k];
	    	Integer q=array_b[end-k];
	    	
	    	if(p==q)
	    	{
	    		continue;
	    	}
	    	else//reverse is't work
	    	{
	    		flag=false;
	    		break;
	    	}
	    }
	    
	    return flag;
	  }








	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom.
	  int test_case_number = 1;
	  void check(boolean expected, boolean output) {
	    boolean result = (expected == output);
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      System.out.print(expected); 
	      System.out.print(" Your output: ");
	      System.out.print(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  
	  public void run() {
	    int[] array_a_1 = {1, 2, 3, 4};
	    int[] array_b_1 = {1, 4, 3, 2};
	    boolean expected_1 = true;
	    boolean output_1 = areTheyEqual(array_a_1, array_b_1); 
	    check(expected_1, output_1); 

	    int[] array_a_2 = {1, 2, 3, 4, 4, 5, 6, 7};
	    int[] array_b_2 = {1, 6, 5, 4, 4, 3, 2, 7};
	    boolean expected_2 = true;
	    boolean output_2 = areTheyEqual(array_a_2, array_b_2); 
	    check(expected_2, output_2); 
	    // Add your own test cases here
	    
	  }
	  
	  public static void main(String[] args) {
	    new ReversetoMakeEqual().run();
	  }
	}