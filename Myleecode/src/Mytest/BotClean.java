package Mytest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotClean {
	
	
	
	
	
	

    static void next_move(int posr, int posc, String[] board){
        //add logic here
    	
    	
    	for(int i=0;i<5;i++)
    	{
    		String row=board[i];
    		//String rownext=board[i+1];
    		
    		
    		for(int j=0;j<5;j++)
    		{
    			
    			
    			if(row.charAt(j)=='d')
    			{
    				
    				int drow=i;
    				int dcol=j;
    				
    			
    				
    				if(posr>drow)// go up
    				{
    					
    					while(posr>drow)
    					{
    						
    						
    						System.out.println("UP");	
    						posr--;
    					}
    					
    					
    					
    				}	
    				
    				if(posr<drow)// go down
    				{
    					while(posr<drow)
    					{
    						System.out.println("DOWN");	
    						posr++;
    						
    					}
    					
    					
    				}
    			
    				
    				if(posc>dcol)
    				{
    					while(posc>dcol)
    					{
    						System.out.println("LEFT");	
    						posc--;
    					}
    					
    					
    				}
    				if(posc<dcol)
    				{
    					while(posc<dcol)
    					{
    						System.out.println("RIGHT");	
    						posc++;
    					}
    					
    					
    				}
    				if( (posc==dcol) &&  (posr==drow))
    				{
    					System.out.println("CLEAN");	
    				}
    				
    				
    				
    			
    			}
    			
    		}
    		
    	}
    	
    	
    	
    	
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
    
    
    
}
