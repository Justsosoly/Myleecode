package Mytest;


import java.io.*;


class DecryptingCodeResult {

    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
    // Write your code here
      String result=s;
      int delcount=0;
   
      for(int i=0;i<s.length();i++)
      {
        
        char cur=s.charAt(i);
         System.out.println("the cur is: "+cur);
        if(cur>='1'&&cur<='9')//deal the number
        {
            
            int index=  result.lastIndexOf('0');
            System.out.println("the number is:"+index);
            if(index+1<result.length())
            {
               System.out.println("the s length is: "+s.length());
               System.out.println("the subresult is: "+result.substring(1, index));
              System.out.println("the subresult is: "+result.substring(index+1, result.length()));
             
      result=result.substring(1, index)+cur+result.substring(index+1, result.length());
                  System.out.println("the result is: "+result);
            }
            else
            result=result.substring(1, index)+cur;
            delcount++;
        }
        else
        if(cur>='A'&&cur<='Z') //deal the alpha
        {
           if(i<=(s.length()-2)) 
            if(s.charAt(i+1)>='a'&&s.charAt(i+1)<='z')
            {
                if(s.charAt(i+2)=='*')
                { 
   
        int index2=  i-delcount;
        // System.out.println("the  index2  is: "+index2);
      //  System.out.println("the subresult2 is: "+result.substring(0, index2));
      //  System.out.println("the subresult2 is: "+result.substring(index2+3, result.length()));
    result=result.substring(0, index2)+s.charAt(i+1)+s.charAt(i)+result.substring(index2+3, result.length());
         System.out.println("the result is: "+result);            
                    i=i+2;
                    delcount++;
                }
                
            }
            
        }
          
          
      }
      
      return result;

    }

}

public class DecryptingCode {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = DecryptingCodeResult.decryptPassword(s);


        bufferedReader.close();
    }
}
