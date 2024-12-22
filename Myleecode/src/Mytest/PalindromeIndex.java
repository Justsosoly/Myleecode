package Mytest;


import java.io.*;
import java.util.*;

import java.util.stream.*;




class PalindromeIndexResult {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
	
	
	/*
    //pass all the test
    public static int palindromeIndex(String s) {
        char arr[]=s.toCharArray();
        int left=0;
        int right=arr.length-1;
        
        while(left<=right){
        	char leftchar=arr[left];
        	char rightchar=arr[right];
            if(leftchar!=rightchar){ 
            boolean Rres=IsPalindrome(arr,left,right-1);//如果不同，则右边的先跳过1个字母
            if(Rres)
            return right;
            else
            {
                boolean Lres=IsPalindrome(arr,left+1,right);//如果右边不同，则左边跳过1个字母
                if(Lres)
                return left;
            }
            
            }
            right--;
            left++;
        }
        return -1;
        }
        
        public static boolean IsPalindrome(char arr[],int left,int right){
            
            while(left<=right){
            	char leftchar2=arr[left];
            	char rightchar2=arr[right];
                if(leftchar2!=rightchar2)//跳过右边的一个字母后依然有不同的话，则不是回文
                return false;
                right--;
                left++;
            }
            return true;
        }
	*/
	
	//pass all test
	public static int palindromeIndex(String s) {
        // Write your code here
           int result=0;
           int left=0;
           int right=s.length()-1;
          
           if(isPalindrome(s,left,right)) return -1;
          
            while (left<=right)
            {
                char x=s.charAt(left);
                char y=s.charAt(right);
                
              if( x!=y ) //如果是回文，则返回
              {
            //   System.out.println("not the palindrome");//不是回文
               
               if(isPalindrome(s,left,right-1))//然后删掉最右边的字符，判断剩余是否为回文
               {
                 return right;
               } 
               
                else    
               if(isPalindrome(s, left+1,right)) //先删掉左边第一个字符，判断剩余是否为回文
                 {
            
                    return left;
                 }
                        
              } //end else
                
                left++;
                right--;
              
            }
           
          return result;
        }
        
    
    
        public static boolean isPalindrome(String s,int left,int right)
        {
          boolean flag=true;
       // System.out.println("judge left="+left+" right="+right);
          while(left<right)
          {
            char x=s.charAt(left);
            char y=s.charAt(right);
         //   System.out.println("x="+x+" y="+y);
              
              if(x==y)
            {
              left++;
              right--;
            }
            else
            {
              flag=false;
              return flag;
            }
          
          }
         // System.out.println("judge"+flag);
          
          return flag;
        }
	    

    
    

}

public class PalindromeIndex {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = PalindromeIndexResult.palindromeIndex(s);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
