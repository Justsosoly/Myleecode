package Mytest;

public class DirectorofPhotography {

  
	//https://www.metacareers.com/profile/coding_puzzles?puzzle=870874083549040
	//pass 14 failed 25 test
	public static void main(String args[])
	
	{
		 /*
		  int N=5;
          String C="APABA";
          int X=1;
          int Y=2;
          */
          //result=1
          
		
          int N=5;
          String C="APABA";
          int X=2;
          int Y=3;
          
          //result=0
          
          
          /*
           int N=8;
           String C=".PBAAP.B";
           int X=1;
           int Y=3;
            */
          //result=3
          
          
          int result=getArtisticPhotographCount(N,C,X,Y);
		
		System.out.println(result);
		
	}
	
	
	
	public static int getArtisticPhotographCount(int N, String C, int X, int Y) {
		 // Write your code here
		 
		 int result=0;
		 int length=C.length();
		 
		 for(int i=0;i<length;i++)
		 {
			 char cur=C.charAt(i);
			 if(cur=='A') //find actor position
			 {
			   	 int rightindex=i+X;
			   	 
			   	 if(rightindex>=length) break; //beyond the maxright,so no method
			   	 
			   	 int rightindexmax=i+Y;
			   	 
			   	 if( rightindexmax>=length ) 
			   		 rightindexmax=length-1;
			   	 
			   	 
			   	 
				 while(rightindex<=rightindexmax)
			   	 {
			   		 
					
					// System.out.println("rightindex="+rightindex);
			   		char right=C.charAt(rightindex);
			   		if(right=='P')//the left direction to find 'B'
			   		{
			   			int leftindex=i-X;
			   			
			   			if(leftindex<0) break;
			   			int leftindexmin=i-Y;
			   			if(leftindexmin<0 )
			   				leftindexmin=0;
			   			
			   			while(leftindex>leftindexmin)
			   			{
			   				char left=C.charAt(leftindex);
			   				if(left=='B')
			   				{
			   					result++;
			   				}
			   				
			   				leftindex--;
			   			}
			   			
			   			
			   		}//end P	
			   		if(right=='B')//the left direction to find 'P'
			   		{
                         int leftindex=i-X;
			   			
			   			if(leftindex<0) break;
			   			
			   			int leftindexmin=i-Y;
			   			
			   			if(leftindexmin<0 )
			   				leftindexmin=0;
			   			
			   			while(leftindex>=leftindexmin)
			   			{
			   				char left=C.charAt(leftindex);
			   				if(left=='P')
			   				{
			   					result++;
			   				}
			   				leftindex--;
			   			}
			   			
			   		}//end B	
			   		rightindex++;
			   		 
			   	 }//while
               				 
				 
				 
			 }
			 
		 }
		 
		
		 return result;
		}

}

