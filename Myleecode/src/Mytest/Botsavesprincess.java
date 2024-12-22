package Mytest;


import java.util.*;

public class Botsavesprincess {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         Scanner in=new Scanner(System.in);
          int n=  in.nextInt();
          List<String> list=new ArrayList<String>();
       for(int i=0;i<n;i++)
        {
        	String str=in.next();
        	list.add(str);
        }
        in.close();
        
        displayPathtoPrincess(n,list);
      
        
    }
    
    
    public static void displayPathtoPrincess(int n, List<String> list)
    
    {
    	
    	int prow=0;
    	int pcol=0;
    	int pri=n-1;
    	
    	for( int i=0;i<list.size();i++)
    	{
    		String str=list.get(i);
    		if(str.contains("p"))
    		{
    			pcol=str.indexOf("p");
    			prow=i;
    			break;
    		}
    	}
    	
    	//n=3 m=1,1  (n-1)/2
    	//n=5 m=2,2  (n-1)/2
    	int m=(n-1)/2;
    	int botx=m;
    	int boty=m;
    	
         if(prow==0&&pcol==0)
         {
        	 
        	 move(prow,pcol,botx,boty);
        	 
         }
         if(prow==pri&&pcol==0)
         {
        	 
        	 move(prow,pcol,botx,boty);
        	 
         }
         if(prow==0&&pcol==pri)
         {
        	 
        	 move(prow,pcol,botx,boty);
        	 
         }
         if(prow==pri&&pcol==pri)
         {
        	 
        	 move(prow,pcol,botx,boty);
        	 
         }
    	
    }
    public static void  move(int prow,int pcol,int brow,int bcol)
    {
    	
    	if(brow>prow)// go left
    	{
    		while(brow>prow)
    	 {	
    		System.out.println("UP");
    		
    		if(bcol>pcol) //go down
    		{
    			
    			System.out.println("LEFT");
    			bcol--;
    		}
    		else  //go up
    		{
    			System.out.println("RIGHT");
    			bcol++;
    			
    		}	
    		
    		brow--;
    	 }	
    	}
    	else// go right
    	{
    		while(brow<prow)	
    	 {	
    			System.out.println("DOWN");
    		if(bcol>pcol) //go down
    		{
    			System.out.println("LEFT");
    			bcol--;
    		}
    		else  //go up
    		{
    			System.out.println("RIGHT");
    			bcol++;
    			
    		}	
    		brow++;
    	}	
    	}
    	
    	
    }
    
    
}