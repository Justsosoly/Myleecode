package Mytest;
import java.io.*;
import java.util.*;

public class SimpleTextEditor {
	
	/*
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		//Scanner scanner=new Scanner(System.in);
		//int n=scanner.nextInt();
		BufferedReader buffred=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt( buffred.readLine().trim());
		
		List<List<String>> list=new ArrayList<List <String>>();
		while (n>0)
		{
			String opertion;
			String value;
			List<String> input =new ArrayList<String>();
			opertion=buffred.readLine();
			if(!opertion.equals("4"))
			{
				input.add(String.valueOf(opertion.charAt(0)));
				value=opertion.substring(2,opertion.length());
				input.add(value);
			}
			else
			{
				input.add(opertion);
			}
			list.add(input);
			n--;
		}
	
		simpleText(list);
		buffred.close();
		
	}
	
	public static String simpleText(List<List<String>> list) throws IOException
	{
		String str="";
		Deque<String> deque=new LinkedList<String>();
	
		String delstr;
	
		
		for(int i=0;i<list.size();i++)
		{
		  
			 List<String> inputlist=list.get(i);
			 int op=Integer.parseInt(inputlist.get(0));
			 int index;
			 String value;
				
				switch (op)
				{
					case 1:
						value=inputlist.get(1);
						str+=value;
						deque.push(str);
						break;
					case 2:
						value=inputlist.get(1);
						index=Integer.parseInt(value);
						delstr=str.substring(str.length()-index,str.length());
						str=str.substring(0, str.length()-index);
						deque.push(str);
						break;
					case 3:
						 value=inputlist.get(1);
						 index=Integer.parseInt(value);
					     System.out.println(str.charAt(index-1));
						// bufferedWriter.write(str.charAt(index-1));
						 break;
					case 4:
						  deque.pop();
						  str=deque.peek();
						break;
				}
			
		}//end for i
	//	bufferedWriter.close();
		return str;
	}
	
*/
	
	 public static void main2(String[] args)throws NumberFormatException, IOException   {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scanner=new Scanner(System.in);
	        int q=Integer.parseInt(scanner.nextLine());
	        List<String> list=new ArrayList<String>();
	        String s="";
	        Deque<String> deque=new LinkedList<String>();
	       while(q>0)
	       {
	         String line=scanner.nextLine();
	         
	         String [] op=line.split(" ");
		      String option=op[0];
		      String value="";
		     
		      
		      if(!option.contentEquals("4"))
		         {
		           value=op[1];
		         }
		       //System.out.println("option "+option);
		     //  System.out.println("value "+value);
		      
		       switch (option)
		       
		       {
		         case"1":
		        	 
		        if(deque.peek()!=null)
		         s=deque.peek();
		        else
		         s="";
		         s=s+value;
		         deque.push(s);
		         break;
		         
		         case"2":
		        if(deque.peek()!=null)
		         s=deque.peek();
		        else
		              s="";
		         int k2=s.length()-Integer.parseInt(value);
		        //  System.out.println("s:"+s);
		     //    System.out.println("k2:"+k2);
		         s=s.substring(0,k2);
		        
		         deque.push(s);
		         break;
		         
		         case"3":
		        if(deque.peek()!=null)
		         s=deque.peek();
		        else
		              s="";
		         int k=Integer.parseInt(value)-1;
		       //  System.out.println("s:"+s);
		      //   System.out.println("k:"+k);
		        System.out.println(s.substring(k,k+1));
		         
		         break;
		         
		         case"4":
		         deque.pop();
		 
		         
		         break;
		         
		       }
		      
	         q--;
	       }
	        
	       scanner.close();
	  }//end main
	  
	
	 
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	          Scanner scanner=new Scanner(System.in);
	          int n=Integer.valueOf(scanner.nextLine());
	          String s="";
	          Deque<String> deque=new LinkedList<>();
	          deque.addLast(s);
	        for(int i=0;i<n;i++)
	        { 
	         String line= scanner.nextLine();
	         String operation=line.substring(0, 1);
	         String value="";
	         if(!operation.equals("4"))
	         {
	               value=line.substring(2);
	         }
	         
	         switch(operation)
	         {
	             
	           case"1":   
	              
	           s=s+value;
	          
	           deque.addFirst(s);
	           break;  
	           
	           case"2":
	        
	           int index=s.length()-Integer.valueOf(value);
	           s=s.substring(0,index);
	           deque.addFirst(s);
	           break;
	              
	           case"3":
	           int printindex=Integer.valueOf(value);
	           System.out.println(s.substring(printindex-1,    printindex));
	           break;  
	                
	           case"4":
	            if(!deque.isEmpty())
	            {
	            deque.pop();
	            if(!deque.isEmpty())
	            s=deque.peek();
	            else
	            s="";	
	            
	            }
	           break;  
	             
	         }
	        }
	          scanner.close(); 
	    }
	 
	 

	 
	
	
}
