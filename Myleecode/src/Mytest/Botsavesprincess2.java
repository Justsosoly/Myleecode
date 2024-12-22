package Mytest;


import java.util.*;

public class Botsavesprincess2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	 Scanner in = new Scanner(System.in);
         int n,r,c;
         n = in.nextInt();
         r = in.nextInt();
         c = in.nextInt();
         in.useDelimiter("\n");
         String grid[] = new String[n];
         in.nextLine();

         for(int i = 0; i < n; i++) {
             grid[i] = in.nextLine();
         }
       
         in.close();
       nextMove(n,r,c,grid);

        
    }
    
    public static void  nextMove(int n,int brow,int bcol,String grid[])
    {
    	
    	
    	int prow=0;
    	int pcol=0;
    	int pri=n-1;
    	
    	for( int i=0;i<n;i++)
    	{
    		String str=grid[i];
    		if(str.contains("p"))
    		{
    			pcol=str.indexOf("p");
    			prow=i;
    			break;
    		}
    	}
    	
  
    	
    	
    	if(brow>prow)// go up
    	{
    		while(brow>prow)
    	 {	
    		System.out.println("UP");
    		
    		if(bcol>pcol) 
    		{
    			
    			System.out.println("LEFT");
    			bcol--;
    		}
    		else  
    		{
    			System.out.println("RIGHT");
    			bcol++;
    			
    		}	
    		
    		brow--;
    	 }	
    	}
    	else if(brow<prow) // go down
    	{
    		while(brow<prow)	
    	 {	
    			System.out.println("DOWN");
    		if(bcol>pcol) //
    		{
    			System.out.println("LEFT");
    			bcol--;
    		}
    		else  //go 
    		{
    			System.out.println("RIGHT");
    			bcol++;
    			
    		}	
    		brow++;
    	}	
    	}
    	 if(brow==prow)
    	{
    		
    		if(bcol>pcol) //
    		{
    		   while(bcol>pcol)
    		   { 
    			System.out.println("LEFT");
    			bcol--;
    		   }
    		}
    		else if(bcol<pcol)  //go 
    		{
    			while(bcol<pcol)
     		   { 
    			System.out.println("RIGHT");
    			bcol++;
     		   }
    		}
    		
    	}
    	
    	
    }
    
  
  
    
    
}