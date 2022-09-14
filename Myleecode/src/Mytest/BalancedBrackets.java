package Mytest;


import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.*;

public class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
      

    	Deque<String> queue= new LinkedList<>();
    	
    	for(int i=0;i<s.length();i++)
    	{
    	
        char x= s.charAt(i);
    	switch (x)
    	{
    	case '{': 
    	{
    		queue.addFirst(String.valueOf(x));
    		continue;
    	}	
    	case '[':
    	{
    		queue.addFirst(String.valueOf(x));
    		continue;
    	}	
    	case '(':
    	{
    		queue.addFirst(String.valueOf(x));
    	    continue;
    	}	
    	case '}':
    	{   
    		if(queue.peekFirst()==null) return "NO";
    		
    	    if(queue.peekFirst().equals("{"))
    			
    		{
    			queue.pollFirst();
    			continue;
    		}	
    		else
    			return "NO";
    		
    	}	
    	case ']':
    	{
    		if(queue.peekFirst()==null) return "NO";
    		if(queue.peekFirst().equals("["))
    	      
    		{
    		queue.pollFirst();
    		continue;
    		}
    		else
    			return "NO";
    	}
    	case ')':
    	{ 
    		if(queue.peekFirst()==null) return "NO";
    		if(queue.peekFirst().equals("("))
    		{
    		queue.pollFirst();
    		continue;
    		}
    	else
			return "NO";
    	}
    		
    	}//end  switch
    	
    	}//end for 
    	
      if(queue.size()==0)	
       return "YES";
      else 
       return "NO";
    }

}

 class BalancedBracketsSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBrackets.isBalanced(s);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}