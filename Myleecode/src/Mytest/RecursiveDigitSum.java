package Mytest;


import java.io.*;

class RecursiveDigitSumResult {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
	
	//success others method
	public static int superDigit2(String n, int k) {
	    // Write your code here
	         if(n.length() == 1){
	            return Integer.parseInt(n);
	        }
	        return superDigit2(String.valueOf(getSuper(n) * k), 1);
	    }
	    
	    public static long getSuper(String s){
	        long sum = 0;
	        for(int i = 0; i < s.length(); i++){
	            sum += Long.parseLong(s.substring(i, i + 1));
	        }
	        return sum;
	    }
	
	    //success,my method
	 public static int superDigit3(String n, int k) {
	    int size=n.length();
	    long result=0;
	    if(size==1) return Integer.valueOf(n);
	    else
	    {
	    	for(int i=0;i<size;i++)
	          {
	          String temp=String.valueOf(n.charAt(i));
	          long single=Long.valueOf(temp);
	          result+=single;  
	          System.out.println("the superDigit is:"+result);
	          }
	    	return superDigit3(String.valueOf(result*k),1);
	    }
		 
	 }
	 
/// this method fail some test ,time limit 改进一开始的字符串拼接，为乘以k。并将int 类型改为long 则全部通过
    public static int superDigit(String n, int k) {
    	
    // Write your code here
    	
    	/*
    	//fail the test 4 5 6 7 8 9 
    	StringBuffer strtemp=new StringBuffer();
    	for(int j=0;j<k;j++)
    		strtemp.append(n);
    	n=strtemp.toString();
    	*/
    	
    	//int resulttemp=0;//fail the test 7 8 9
    	long  resulttemp=0; //pass all the test
        for(int i=0;i<n.length();i++)
             {
                
             String temp=String.valueOf(n.charAt(i));
             long single=Long.valueOf(temp);
             resulttemp+=single;  
             System.out.println("the superDigit is:"+resulttemp);
             }
         n=String.valueOf(resulttemp*k);
    	
    	
    	
    	while(n.length()>1)
        {  
          long result=0;
          
         for(int i=0;i<n.length();i++)
          {
             
          String temp=String.valueOf(n.charAt(i));
          long single=Long.valueOf(temp);
          result+=single;  
          System.out.println("the superDigit is:"+result);
          }
         n=String.valueOf(result);
       

        if(String.valueOf(n).length()==1)
        {
        
          return Integer.valueOf(n);
        }
        
        }//end while
        return 0;
   
    }

}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = RecursiveDigitSumResult.superDigit(n, k);


        bufferedReader.close();
    }
}
