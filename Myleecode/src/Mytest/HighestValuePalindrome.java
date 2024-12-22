package Mytest;


import java.io.*;
import java.util.*;


class HighestValuePalindromeResult {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */
	
	

	

	  public static boolean IsPalindrome(String s,int left,int right){
          
          while(left<=right){
          	char leftchar2=s.charAt(left);
          	char rightchar2=s.charAt(right);
              if(leftchar2!=rightchar2)//跳过右边的一个字母后依然有不同的话，则不是回文
              return false;
              right--;
              left++;
          }
          
          return true;
          
      }
	
	  public static void isSame(String s1,String s2)
	  {
		  for(int i=0;i<s1.length();i++)
		  {
			  if(s1.charAt(i)!=s2.charAt(i))
				  System.out.println(s1.charAt(i)+" different "+s2.charAt(i));
		  }
		  
		  
	  }
	  
	 
		
	
	  
	  
	
    public static String highestValuePalindrome(String s, int n, int k) {
    // Write your code here
    	int left=0;
    	int right=s.length()-1;
    	int count=0;
    	StringBuilder strb=new StringBuilder(s);
    	int flag[]=new int[n];
    	
    	for(int x=0;x<n;x++)
    		flag[x]=0;
    	
    	
    	// to be a Palindrome
    	while(left<=right)
    	{
    		char sl=s.charAt(left);
    		char sr=s.charAt(right);
    		
    		String strleft=String.valueOf(sl);
    		String strright=String.valueOf(sr);
    		
    		if(!strleft.equals(strright))//modify the bigger one to be a Palindrome
    		{
    		  if(k>0)
    		  {
    			if(sl<sr)
    			{
    				
    				strb.setCharAt(left,sr);
    				k=k-1;
    				flag[left]=1;
    			}
    			else
    				if(sl>sr&&k>0)
    			{
    				strb.setCharAt(right,sl);
    				k=k-1;
    				flag[right]=1;
    			}	
    		  }
    		  else
    		  {
    			return "-1";//can't be a Palindrome: the need modifying number is more than the 
    		  }  
    			count++;
    		}
    		
    			
    		left++;
    		right--;
    		
    	}	
    	
    	  System.out.println(strb.toString());
       	 System.out.println(IsPalindrome(strb.toString(),0,strb.toString().length()-1));
     	 
    	
    		 int i=0;
        	 while(k>0&&i<n)
        	 {
        		 int l=i;
        	     int r=n-i-1;
        	     char strl=strb.charAt(l);
         		//char strr=strb.charAt(r);
        		 
        		 if(strl!='9')
        		 {
        			if(flag[l]==0&&flag[r]==0&&k>=2)
        			{
        			 strb.setCharAt(l,'9');
        			 strb.setCharAt(r,'9');
        			 k=k-2;
        			}
        			if(flag[l]==1||flag[r]==1&&k>=1)
        			{
        			 strb.setCharAt(l,'9');
           			 strb.setCharAt(r,'9');
           			 k=k-1;
        			}
        		 } 
        		
        	     i++;
        	 }//end while	 
        		 
      	   if(k==1&&n%2!=0)//n is odd,then used the last one time to modify the middle number	 
		   {
			 strb.setCharAt((n-1)/2,'9');
			 k=k-1;  
		   }
         
    	  return strb.toString();
    	}
    		
    

}

public class HighestValuePalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = HighestValuePalindromeResult.highestValuePalindrome(s, n, k);

        bufferedReader.close();
    }
}
