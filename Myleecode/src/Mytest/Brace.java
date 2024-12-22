package Mytest;



import java.util.*;
import java.util.regex.*;


// Write your code here. DO NOT use an access modifier in your class declaration.

class BraceParser{
    static String isBalanced(String s) 
    {
    	   Deque<String> queue=new LinkedList<>();
    	      // System.out.println(s);
    	       for(int i=0;i<s.length();i++)
    	       {
    	         char elment=s.charAt(i);
    	         String e=String.valueOf(elment);
    	         switch (elment)
    	         {
    	           case '{':
    	            queue.push(e);
    	            break;
    	           case '}':
    	           if(!queue.isEmpty())
    	           {
    	            if(queue.peek().equals("{"))
    	             {
    	               queue.pop();
    	              break;
    	             }
    	             else 
    	             return "false";
    	            } 
    	             
    	             case '(':
    	            queue.push(e);
    	            break;
    	           case ')':
    	           if(!queue.isEmpty())
    	           {
    	             if(queue.peek().equals("("))
    	             {
    	               queue.pop();
    	              break;
    	             }
    	             else 
    	             return "false";
    	           }
    	           
    	           case '[':
    	            queue.push(e);
    	            break;
    	           case ']':
    	           if(!queue.isEmpty())
    	           {
    	             if(queue.peek().equals("["))
    	             {
    	               queue.pop();
    	              break;
    	             }
    	             else 
    	             return "false";
    	           }
    	         }
    	  
    	         
    	       }//end for
    	       
    	       if(queue.size()==0)
    	        return "true";
    	       
    	       return "false";
    }
    
}

class Brace {
	
	public static void main(String[] args) {
		BraceParser parser = new BraceParser();
        
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			System.out.println(parser.isBalanced(in.next()));
		}
        
		in.close();
	}
}
