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

class PrimSpecialSubtreeResult {
 
    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    public static int prims(int n, List<List<Integer>> edges, int start) {
    // Write your code here
    	int result=0;
     List<Integer> mst=new ArrayList<Integer>();

    	
     PriorityQueue<List<Integer>> pque = new PriorityQueue<>((a,b) -> a.get(2) - b.get(2));
     pque.addAll(edges);
     
 	 int edgesize=pque.size();
 
    	mst.add(start);
    	int i=0;
    	List<List<Integer>> pqueback=new ArrayList<List<Integer>>();//没有用上的边都先存放在这
    	
    	while(mst.size()<n)
    	{
    		
    		if(pqueback!=null)
    		{
    		pque.addAll(pqueback);
    		pqueback.clear();
    		}
    		
    	 while(!pque.isEmpty())
    	 {
    		 
    		 List<Integer> curedge = pque.poll();
    		 Integer source=curedge.get(0);
    		 Integer target=curedge.get(1);
    		 Integer weight=curedge.get(2);
    		 
    		 if(mst.contains(source)&&mst.contains(target))
    		 {
    			 break;
    		 }
    		 if(mst.contains(source)&&!mst.contains(target))
    		 {
    			 mst.add(target);
    			 result+=weight;
    			// pqueback.clear();
    			 break;
    		 }
    		 if(!mst.contains(source)&&mst.contains(target))
    		 {
    			 mst.add(source);
    			 result+=weight;
    			// pqueback.clear();
    			 break;
    		 }
    		 else  //一条边2个端点都没有在mst最小生成树都集合里，则把这条边放到pqueback里以后再处理
    		 {
    			 pqueback.add(curedge);
    			 continue;
    		 }
    	 }// end while empty
    	 }//end while size
   
    	return result;
}
}

public class PrimSpecialSubtree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }); 

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = PrimSpecialSubtreeResult.prims(n, edges, start);


        bufferedReader.close();
    }
}

