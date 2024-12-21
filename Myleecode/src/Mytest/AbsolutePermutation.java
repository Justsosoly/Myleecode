package Mytest;




import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class AbsolutePermutationResult {

    /*
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */
	
	 public static List<Integer> absolutePermutation(int n, int k) {
	
		 List<Integer> result=new ArrayList<Integer>();
		 Set<Integer> set=new HashSet();
		 
		 for(int i=1;i<=n;i++)
		 {
			 int min=i-k;
			 int max=i+k;
			 
			 if(min>0&&!set.contains(min))
			 {
				 result.add(i-1,min);
				 set.add(min);
			 }
			 else 
				 
				 if(max<=n&&!set.contains(max))
			 {
				 result.add(i-1,max);
				 set.add(max);
			 }
			 else
			 {
				 result.clear();
				 result.add(0,-1);
				 return result;
			 }
			 
		 }
		 
	
	
	    return result;
	 }
	
//fail to pass the test case 9-12 time limit exceed
    public static List<Integer> absolutePermutation2(int n, int k) {
    // Write your code here
    	 List<Integer> result=new ArrayList<Integer>();
    	
    	 for(int i=1;i<=n;i++)
    	 {
    		int position=i; 
    		int per_higher=0;
    		int per_lower=0;
    	
    		per_higher=position+k;
    		per_lower=position-k;
    		
    		int permutation=per_lower;
    	
    		if(per_lower<=0)//小的数比0小，则选大的
    		{
    			if(per_higher<=n)
    			permutation=per_higher;
    			
    		}
    		
    		if(per_higher>n)//大的数比n大，则选小大
    		{
    			
    			if(per_lower>0)
    			permutation=per_lower;
    			else 
    			{
    				result.clear();
    				result.add(0,-1);
    				break;
    			}
    				
    		}
    		if(result.contains(per_lower))//如果小的数已经用过了，则改大的看看
    			if(!result.contains(per_higher)&&per_higher<=n)//大的数比n小并且也没用过才可以
    			permutation=per_higher;
    			else //大，小两个数都 不满足则返回-1
    			{
        			result.clear();
        			result.add(0,-1);
    			   break;
    			}
    		
    		if(result.contains(per_higher))//同样
    			if(!result.contains(per_lower)&&per_lower>0)
    			permutation=per_lower;
    			else
    		{
    			result.clear();
    			result.add(0,-1);
			   break;
			}
    		
    		
    		if(!result.contains(permutation))
    			result.add(i-1, permutation);
    		else
    		{
    			result.clear();
    			result.add(0,-1);
			   break;
			}
    	 }
    	
    	 for(int j=0;j<result.size();j++)
    	 {
    		 System.out.print(result.get(j)+" ");
    		
    	 }
    	 System.out.println();
    	 
    	 
    	 
    	return result;

    }

}

public class AbsolutePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = AbsolutePermutationResult.absolutePermutation(n, k);

                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
