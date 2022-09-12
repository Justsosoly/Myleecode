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



class FlippingMatrix {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
    // Write your code here
    	int sum=0;
    	int n=matrix.size()/2;//matrix's row
    	int a[][]=  new int [n][n];
 
    	for(int i=0;i<n;i++)
    		for(int j=0;j<n ;j++)
    	{
    		a[i][j]=maxRowCon(i,j,matrix);
    		sum=sum+a[i][j];
    		
    	}
    	
    	
    	
    	
    	System.out.println("the sum is"+sum);
        return sum;
    }

    
    public static int maxRowCon(int i,int j,List<List<Integer>> matrix)
    {
    	int max=0;
    	int n=matrix.size()/2;//matrix's row
    	int flipping[]=new int [4];
    	/*
    	//i=0,j=0
    	matrix.get(i).get(j);
    	matrix.get(i).get(2*n-1);
    	matrix.get(2*n-1).get(j);
    	matrix.get(2*n-1).get(2*n-1);
    	//i=0,j=1
    	matrix.get(i).get(j);
    	matrix.get(i).get(2*n-j-1);
    	matrix.get(2*n-1).get(j);
    	matrix.get(2*n-1).get(2*n-1-j);
    	*/
    	//i=1,j=0
    	
    	
    	flipping[0]=matrix.get(i).get(j);
    	flipping[1]=matrix.get(i).get(2*n-1-j);
    	flipping[2]=matrix.get(2*n-1-i).get(j);
    	flipping[3]=matrix.get(2*n-1-i).get(2*n-1-j);
    	max=flipping[0];
        for(int p=0;p<3;p++)
        {
        	
        	if(max<flipping[p+1])
        	
            max=flipping[p+1];	
        }	
    	
    	
    	
    	
    	
    	return max;
    }
    
    
    
    



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
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

                int result = FlippingMatrix.flippingMatrix(matrix);

            //    bufferedWriter.write(String.valueOf(result));
            //    bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
       // bufferedWriter.close();
    }
}
