package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class EqualStackResult {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
5 3 4
3 2 1 1 1
4 3 2
1 1 4 1
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    	
        int	h1height=stackHeight(h1);
        int h2height=stackHeight(h2);
        int h3height=stackHeight(h3);
        int maxheight=0;
    	
    	
    	
    //	Deque<Integer> queue=(LinkedList)maxStack(h1,h2,h3);
    	
    	while(!((h1height==h2height)&&(h1height==h3height)))
    	{
    	//	 maxheight=stackHeight(maxStack(h1,h2,h3));
    		maxheight=Math.max( (Math.max(h1height, h2height)),h3height);
    		if(h1height==maxheight)
    		{
    			h1height=h1height-h1.get(0);
    			h1.remove(0);
    		}
    		if(h2height==maxheight)
    		{
    			h2height=h2height-h2.get(0);
    			h2.remove(0);
    		}
    		if(h3height==maxheight)
    		{
    			h3height=h3height-h3.get(0);
    			h3.remove(0);
    		}
    		
    	}
    	 maxheight=stackHeight(maxStack(h1,h2,h3));
    	
    //	queue.removeFirst();
    	
    	
    	return maxheight;

    }
    
    
    public static List<Integer> maxStack(List<Integer> h1, List<Integer> h2, List<Integer> h3)
    {
    	List<Integer> maxlist=null;
    	
     	int h1height=0;
    	int h2height=0;
    	int h3height=0;
    	int max=0;
    	
    	h1height=stackHeight(h1);
    	h2height=stackHeight(h2);
    	h3height=stackHeight(h3);
    	
        max=(h1height>h2height)?h1height:h2height;
        max=(max>h3height)?max:h3height;
   
    if(max==h1height)
    	return h1;
    	
    if(max==h2height)
    	return h2;
    	
    if(max==h3height)
        return h3;
    	
    	return null;
    }
    
    
    public static int stackHeight(List<Integer> h)
    {
    	int height=0;
    	for(int x=0;x<h.size();x++)
    	{
    		height=h.get(x)+height;
    	}
    	return height;
    }

}

public class EqualStack {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = EqualStackResult.equalStacks(h1, h2, h3);


        bufferedReader.close();
    }
}
