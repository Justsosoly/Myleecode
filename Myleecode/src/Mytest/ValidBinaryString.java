package Mytest;


import java.io.*;


class ValidBinaryStringResult {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER d
     */
	
	
	//pass all the test
	 public static int minimumMoves(String s, int d) {
		    // Write your code here
		        int result=0;
		        int n=s.length();
		        int i=0;
		        char str[]=s.toCharArray();
		        int count=0;
		        while(i<n)
		        {
		            char cur=str[i];
		        //    System.out.println("current="+cur);
		            if(cur=='1')
		            {
		               // i=i+d-1;
		                i++;
		            	count=0;
		                continue;
		            }
		            else
		            if(cur=='0')
		            {
		                count++;
		               
		                if(count==d)//continuous d 0, modify to 1 and i get the next d-1;
		                {
		                    result++;
		                   // i=i+d-1;
		                    i++;
		                    count=0;
		                    continue;
		                }
		                i++;
		            }     
		        }
		        
		        System.out.println(result);		        
		       return result;
		    }
	
	
	
	
	
//time limit
    public static int minimumMoves2(String s, int d) {
    // Write your code here
        int result=0;
        int n=s.length();
        int i=0;
        int count=0;
        
        char str[]=s.toCharArray();
        while(i<=n-d)
        {
        	char cur=str[i];
          //  System.out.println("i="+i+" current="+cur);
           
            if(cur=='1')
            {
                i=i+d-1;
                count=0;
                continue;
            }
            else
            if(cur=='0') //judge the next d has one '1'
            {
                
                
                for(int j=1;j<d;j++)
              {
                	char next=str[j+i];
            //    System.out.println("j="+j+" next="+next);
                 if(next=='1')
                 {
                	 i=i+j+1;
                    count=0;
                	break; 
                    
                 }  
                 else
                   if (next=='0')
                 {
                    count++; 
                     continue;
                 }
                        
              }//end for j 
                    if(count==d-1)
                    {
                        result++;
                        i=i+d;
                        continue;
                    } 
                    
            }//end if '0' situation
            
        }//end for i
        
        System.out.println(result);
        return result;

    }

}

public class ValidBinaryString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int result = ValidBinaryStringResult.minimumMoves(s, d);

        bufferedReader.close();
    }
}
