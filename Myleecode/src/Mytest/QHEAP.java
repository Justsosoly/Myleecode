package Mytest;

import java.io.*;
import java.util.*;

public class QHEAP {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		//Scanner scanner=new Scanner(System.in);
		//int n=scanner.nextInt();
		//	List<List<Integer>> list=new ArrayList<List<Integer>>();
		BufferedReader buffread=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(buffread.readLine());
		
	
		List <Integer>input=new ArrayList<Integer>();
		int min=Integer.MAX_VALUE;
		while(n>0)
		{
			String str;
			int op;
			int value;
		
			
			str=buffread.readLine();
			
			if(!str.equals("3"))
			{
			op=Integer.parseInt(String.valueOf(str.charAt(0)));
		
			value=Integer.parseInt(str.substring(2,str.length()));
			
			 if(op==1)
			 {
				 input.add(value);
				 if(value<min||input.size()==1) 
					 min=value;
				 
			 }	 
			 if(op==2)
			 {
				 input.remove((Integer) value) ;
				 if(min==value&&!input.isEmpty()) 
					 min=Collections.min(input);
			 }
			}
			else if(str.equals("3"))
			
			{
				
		       System.out.println(min);
			}
			n--;
		}//end while
		
		buffread.close();
	}
	

	
	

}
