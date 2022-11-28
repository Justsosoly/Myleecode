package Mytest;


import java.io.*;


class SuperReducedStringResult {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
    // Write your code here
    	StringBuilder  sb=new StringBuilder(s);
    	
    for(int i=0;i<sb.length()-1;i++)
     {
    	
    	 char x=sb.charAt(i);
    	 char y=sb.charAt(i+1);
    	 if(x==y)
    	 {
    	   sb.delete(i, i+2);
    	   i=-1;
    	 }
     }
     if(sb.isEmpty())
    	 return "Empty String";
    	
    	return sb.toString();
    }

}

public class SuperReducedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = SuperReducedStringResult.superReducedString(s);
        bufferedReader.close();
  
    }
}
