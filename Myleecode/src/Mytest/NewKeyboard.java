package Mytest;


import java.io.*;
import java.util.Deque;
import java.util.LinkedList;


class NewKeyboardResult {

    /*
     * Complete the 'receivedText' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING S as parameter.
     */
	
	//one deque fail the test time limits
	 public static String receivedText(String S) {
		    // WRITE DOWN YOUR CODE HERE
		 
		        StringBuilder result=new StringBuilder();
		        
		        int n=S.length();
		 
		        
		       
		        Deque<Character> deque=new LinkedList<Character>();
		        
		        String flag="tail"; //head tail  2 path
		        int onoff=0; // 1,3,odd number will off the number
		        
		       for(int i=0;i<n;i++)
		        {
		            
		        	char cur= S.charAt(i);
		        	 
		        	
		            switch(cur)
		            {
		              case '*': 
		            	  if(!deque.isEmpty())
		            		  deque.pop();
		                break;
		                    
		                   
		              case '<':
		            	  if( !deque.isEmpty()&&flag.equals("tail"))
		            	  {
		            		  StringBuilder temp=new StringBuilder();
		            		  
		            		  while( !deque.isEmpty())
		            	       {
		            			  temp.append(deque.pop());
		            	       }
		            		  result.append (temp.reverse()) ;//put to the tail
		            	  }
		            	  else
		            	  
		            		 if( !deque.isEmpty()&&flag.equals("head"))//continue < <
		            		  {
		            			  
		            			 StringBuilder temp=new StringBuilder();
			            		  
			            		  while( !deque.isEmpty())
			            	       {
			            			  temp.append(deque.pop());
			            	       }
			            		  result= temp.reverse().append(result);
		            		  }
		            	
		            	  
		            	  flag="head";
		                    
		                break;
		                    
		                    
		              case '>':
		            	  
		            	  
		            	  if( !deque.isEmpty()&&flag.equals("head"))
		            	  {
		            		  StringBuilder temp=new StringBuilder();
		            		  while( !deque.isEmpty())
		            		     {
		            			  temp.append(deque.pop());
		            			 
		            		     }
		            		  
		            		  result= temp.reverse().append(result);// put to the head
		            	  }
		            	  if( !deque.isEmpty()&&flag.equals("tail"))
		            	  {
		            		  
                             StringBuilder temp=new StringBuilder();
		            		  
		            		  while( !deque.isEmpty())
		            	       {
		            			  temp.append(deque.pop());
		            	       }
		            		  result.append (temp.reverse()) ;//put to the tail
		            		  
		            	  }
		            	  
		            	  
		            	  
		            	  
		            	  flag="tail";
		            	  
		                break;
		                    
		                    
		               case '#':
		            	   onoff++;
		                break;   
		                
		               default:
		            	   
		            	   
		            		   if(onoff%2==1)//close the number input
		            		   {
		            			   if(cur>='0'&&cur<='9')
		            			   break; 
		            		   }
		            		     
		            			   deque.addFirst(cur);
		            	
		            }//end switch
		            
		        }//end while
		       
		       
		       if( !deque.isEmpty()&&flag.equals("head"))
         	  {
         		  StringBuilder temp=new StringBuilder();
         		  while( !deque.isEmpty())
         		     {
         			  temp.append(deque.pop());
         			 
         		     }
         		  
         		  result= temp.reverse().append(result);
         	  }
		       
		       if( !deque.isEmpty()&&flag.equals("tail"))
         	  {
         		  StringBuilder temp=new StringBuilder();
         		  
         		  while( !deque.isEmpty())
         	       {
         			  temp.append(deque.pop());
         	       }
         		  result.append (temp.reverse()) ;
         	  }	  
		       
		    //    System.out.println(result);
		        return result.toString();
		    }
	
	
	
	
	
	
	
	
	
	//time limits failed the test  two deque
    public static String receivedText2(String S) {
    // WRITE DOWN YOUR CODE HERE
      //  StringBuffer result=new StringBuffer();
        StringBuilder result=new StringBuilder();
        int n=S.length();
       
        Deque<Character> deque_head=new LinkedList<Character>();
        Deque<Character> deque_tail=new LinkedList<Character>();
        
        
        String flag="tail"; //head tail  2 path
        int onoff=0; // 1,3,odd number will off the number
        
       for(int i=0;i<n;i++)
        {
            
        	char cur=S.charAt(i);
        	
        	//System.out.println("cur="+cur);
        	
        	
        	
            switch(cur)
            {
              case '*': 
            	  if(flag.equals("tail")&&!deque_tail.isEmpty())
            		  deque_tail.pop();
            	  
            	  else
            		  if(flag.equals("head")&&!deque_head.isEmpty())
            		 deque_head.pop();
            		  
                break;
                    
                   
              case '<':
            	  if( !deque_head.isEmpty())
            	  {
            		  StringBuilder temp=new StringBuilder();
            		  
            		  while( !deque_head.isEmpty())
            	       {
            	    	
            	    	   
            			  temp.append(deque_head.pop());
            	    	
            	       }
            		  result= temp.reverse().append(result);
            		  
            		
            	  }
            	  
            	  flag="head";
                    
                break;
                    
                    
              case '>':
            	  flag="tail";
            	  
            	  if( !deque_tail.isEmpty())
            	  {
            		  StringBuilder temp=new StringBuilder();
            		  while( !deque_tail.isEmpty())
            		     {
            		//  result=result+deque_tail.pollLast();
            			  temp.append(deque_tail.pop());
            			 
            		     }
            		  result.append (temp.reverse()) ;
            	  }
            	  
                break;
                    
                    
               case '#':
            	   onoff++;
                break;   
                
               default:
            	   
            	   if(cur>='0'&&cur<='9')
            	   {
            		   if(onoff%2==1)//close the number
            		   {
            			   break; 
            		   }
            	   }
            	   
            	   if(flag.equals("tail"))// flag=tail
            			   {
            				   
            		   deque_tail.addFirst(cur);
            		   
            			   }
            	   else
            		   if(flag.equals("head"))// flag=head
            	   {
            		   
            		   deque_head.addFirst(cur);
            	   }
            	
            }//end switch
            
            
        }//end while
        
       StringBuilder temp=new StringBuilder();
		  
		  while( !deque_head.isEmpty())
	       {
	    	 //  result=deque_head.pop()+result;
	    	   
			  temp.append(deque_head.pop());
	    	
	       }
		 
		  result= temp.reverse().append(result);
       

		   temp=new StringBuilder();
		   
		  while( !deque_tail.isEmpty())
		     {
		//  result=result+deque_tail.pollLast();
			  temp.append(deque_tail.pop());
			 
		     }
		  result.append (temp.reverse()) ;
		  
		  
       
        System.out.println(result);
        return result.toString();
    }

}

public class NewKeyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        String result = NewKeyboardResult.receivedText(S);

        bufferedReader.close();
    }
}
