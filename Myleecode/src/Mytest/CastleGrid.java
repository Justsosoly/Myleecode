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

class CastleGridResult {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid
     *  2. INTEGER startX
     *  3. INTEGER startY
     *  4. INTEGER goalX
     *  5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
    // Write your code here BFS
    	
    	int result=0;
    	int m=grid.size();
    	int n=grid.get(0).length();
    	
    	boolean reached=false;
    	
    	List<String> bfslist=new LinkedList<String>();
    	String start=String.valueOf(startX)+startY;
    	
 
    	
    	//String bfs[][]=new String[m][n];
    	
    	String visited[][]=new String[m][n];
    	
    	while(!reached)
    	{
    	
    	
    	for(int i=0;i<grid.size();i++)
    	{
    		String temp=grid.get(i);
    		if((goalX-startX)>0)
    			
    		
    		for(int j=0;j<temp.length();j++)
    		{
    			
    			
    		}//end for j
    		
    	}//end for i
    	
    	
    	
    	
    	
    	}//end while
    	
        return result;
    }

}

public class CastleGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = CastleGridResult.minimumMoves(grid, startX, startY, goalX, goalY);


        bufferedReader.close();
    }
}
