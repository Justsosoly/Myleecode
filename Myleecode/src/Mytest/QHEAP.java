package Mytest;

import java.io.*;
import java.util.*;

public class QHEAP {
	
	public static void main2(String args[]) throws NumberFormatException, IOException
	{

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
	
	
	
     //test 8-16 会time limits。
	//String str[]=new String[n];  str=  line.split(" ");这个方法会花费大量时间

      public static void main(String[] args) {
          /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
          Scanner scan=new Scanner(System.in);
          int n=Integer.valueOf( scan.nextLine() ) ;
          int min=Integer.MAX_VALUE;
          List<Integer> list =new ArrayList<>();
         
          for(int i=0;i<n;i++)
          {
             String line=scan.nextLine() ;
            
             int operation=0;
             Integer value=0;
            
             String str[]=new String[n];
             if(line.equals("3"))
             {
                  operation=3;
             }
             else
             {
                 str=  line.split(" ");
               operation=Integer.valueOf(str[0]);
               value=Integer.valueOf(str[1]);
             }
              switch (operation)
              {
                  case 1: 
                  list.add(value);
                  if(value<min)
                   min=value;
                  break;
                  
                  case 2:
                	  list.remove(value);
                  if(value==min)   
                  { 
                    if(!list.isEmpty())
                	  min=Collections.min(list);
                    else
                      min=Integer.MAX_VALUE;
                  } 
                
                   break;
                   
                  case 3:
                  System.out.println(min);
                  break;
              } 
             
             
          }
           scan.close();
      
          
          
      }
	
	

}
