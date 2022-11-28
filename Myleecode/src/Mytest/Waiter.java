package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class WaiterResult {

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
    // Write your code here
    	List<Integer> answerlist=new LinkedList<Integer>();
 
    	List<Integer> primenum=primeNumber(q);
    	int psize=primenum.size();
    	
    	for(int j=0;j<psize;j++)
    	{
    		Deque temp=new LinkedList<Integer>();
    		for(int i=0;i<number.size();i++)
    	 {
    			
    		if(number.get(i)%primenum.get(j)==0)
    		{
    			int n=number.get(i);
    			answerlist.add(n);
    			number.remove(i);
    			i--;
    			continue;
    		}	
    		else
    		{
    			
    			temp.addFirst(number.get(i));
    			continue;
    		}
    		
    		
    	}//end for i
    		number=(LinkedList<Integer>)temp;
    	}//end for j
    	
    	int numsize=number.size();
    	
    	for(int x=numsize-1;x>=0;x--)
    	{
    		answerlist.add(number.get(x));
    		
    	}
    	
    	
    	return answerlist;
    }
    
    //get all the prime number
    public static List<Integer> primeNumber(int q)
    {
    	List<Integer> prime=new ArrayList<Integer>();
    	
    	int index=0;
    	int max=Integer.MAX_VALUE;
    	
    	if(q==1)
    	{
    		prime.add(2);
    		return prime;
    	}	
    	
    	
    	else if(q>1)
    	{
    	
      for(int n=2;n<max;n++)
    	{
    	  boolean flag=true;
    		for(int i=2;i<n;i++)
    		{
    			if(n%i==0) 
    			{
    				flag=false;
    				break;
    			}
    			
    		}
    		if(flag==true)//
    		{
    			prime.add(n);
    			System.out.print(n+" ");
    			index++;
    			if(index==q)
    			{
    				return prime;
    			}
    		}
    		
    		
    	}
    	
    	}//end if
    	
    	
    	return prime;
    }
    

}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = WaiterResult.waiter(number, q);

     

        bufferedReader.close();
    }
}
