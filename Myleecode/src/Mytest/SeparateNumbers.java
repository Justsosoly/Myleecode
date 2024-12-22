package Mytest;


import java.io.*;
import java.util.stream.*;

class SeparateNumbersResult {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
    // Write your code here
    	 int start=0;
    	 int n=s.length();
    	 
      for(int i=1;i<=n/2;i++)
      {
    	  int length=i;
    	  String first= s.substring(start, start+length);
    	  StringBuffer str=new StringBuffer(first);
    	  StringBuffer target=new StringBuffer(first);
    	  //则按beautiful规则得到后续的字符串为
    	 // int next=Integer.valueOf(str.toString());
    	  Long next= Long.parseLong(str.toString());//解决了runtime问题！！
    	
    	  while(target.length()<n)
    	  {
    		
    		//  String nextstr=String.valueOf();
    		  next++;
    		  target.append(next);
    		 
    		 if(!s.contains(target.toString()))
    			 break;
    		 
    	  }
 
    		  if(target.toString().equals(s)) 
    	  {
    	   System.out.println("YES "+first);
    	   return;
    	  }
    	 
      }//end for
    	  System.out.println("NO");
      
    }
    
    public static void separateNumbers2(String s) {
    if(s.length() > 1)
    {
        for(int i = 1; i <= s.length() / 2; i++)
        {
            String newSequence = "";
            String firstNum = s.substring(0,i);
            long wouldBeNext = Long.parseLong(firstNum);
        
            while(newSequence.length() < s.length())
            {
                newSequence += wouldBeNext;
                wouldBeNext ++;
            }
            if(newSequence.equals(s))
            {
                System.out.println("YES "+ firstNum);
                return;
            }
        }
    }
    
    System.out.println("NO");
    }
    
     
}

public class SeparateNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                SeparateNumbersResult.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
