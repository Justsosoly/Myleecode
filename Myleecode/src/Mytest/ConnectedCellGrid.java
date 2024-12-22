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



class ConnectedCellGridResult {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
    // Write your code here
       int result=0;
       
       int n=matrix.size();//row
       int m=matrix.get(0).size();//column
       
       for(int i=0;i<n;i++)
    	   for(int j=0;j<m;j++)
    	   {
    		   if(matrix.get(i).get(j)==1)
    		   {
    			   System.out.println("search the grid["+i+"]["+j+"]");
    			   result=Math.max(result,getgridnum(matrix,i,j)); 
    			   
    		   }
    	   }
       
       return result;
    }
    
	public static int getgridnum(List<List<Integer>> matrix, int r, int c) {
		int num = 1;
		int row = matrix.size();// row
		int column = matrix.get(0).size();// column
	    
		if(r>=row||c>=column||r<0||c<0)//超过了边界的都为0
			return 0;
		
		if(matrix.get(r).get(c)==0)
			return 0;
		
	    matrix.get(r).set(c, 0);//将matrix[r][c]设置为0，则下次在connectedCell中则不会再进入迭代
			                    //没有return，则会再次进入下面的2个for循环
		
		for(int i=r-1;i<=r+1;i++)
			for(int j=c-1;j<=c+1;j++)
			{
				if(i!=r||j!=c)//||则是刨去中间一个点，&&的话则是刨去中心十字，只有4个
				{
				num+=getgridnum(matrix,i,j);
				System.out.println("the getgrid["+i+"]["+j+"]num is "+num);
				}
			}	
		

		return num;

	}

}

public class ConnectedCellGrid {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ConnectedCellGridResult.connectedCell(matrix);


        bufferedReader.close();
    }
}
