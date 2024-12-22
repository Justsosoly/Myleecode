package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Matrix{
	int x;
	int y;
	int z;
	
    Matrix(int m, int n,int p)
    {
    	this.x=m;
    	this.y=n;
    	this.z=p;
    }
}


class CubeSummationResult {

    /*
     * Complete the 'cubeSum' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY operations
     */
	

    public static List<Long> cubeSum(int n, List<String> operations) {
    // Write your code here
    	List<Long> result=new ArrayList<Long>();
    	
    	Map<Matrix,Long> map=new HashMap< Matrix,Long>();
    	
    	for(int x=1;x<=n;x++)
    		for(int y=1;y<=n;y++)
    			for(int z=1;z<=n;z++)
    			{
    				Matrix matrix=new Matrix(x,y,z);
    				map.put(matrix,0L);
    			}
    	
    	
    	for(int i=0;i<operations.size();i++)
    	{
    		String op=operations.get(i);
    		String temp[]=op.split(" ");
    		
    		switch (temp[0])
    		{
    		
    		   case "UPDATE":
    		  {
    			  int x=Integer.parseInt(temp[1]);
    			  int y=Integer.parseInt(temp[2]);
    			  int z=Integer.parseInt(temp[3]);
    			  Long value =Long.parseLong(temp[4]);
    			  Matrix matrix=new Matrix(x,y,z);
    			  map.put(matrix,value);
    			  continue;
    		  }
    		
    		   case "QUERY":
    		  {
    		 	
    		 	 int x1=Integer.parseInt(temp[1]);
   			     int y1=Integer.parseInt(temp[2]);
   			     int z1=Integer.parseInt(temp[3]);
   			     
    		 	 int x2=Integer.parseInt(temp[4]);
   			     int y2=Integer.parseInt(temp[5]);
   			     int z2=Integer.parseInt(temp[6]);
    		 	
    		 	long sum=0;
    		 
    		 /*
    		 	for(Matrix m:map.keySet())
    		 	{
    		 		
    		 		if(m.x>=x1&&m.x<=x2&&
    		 		   m.y>=y1&&m.y<=y2&&
    		 		   m.z>=z1&&m.z<=z2
    		 		  )
    		 		{
    		 			 sum+=map.get(m);
    		 		}	
    		 		
    		 	}//end for map
    		 	*/
    		 	Iterator<Map.Entry<Matrix,Long>>it=map.entrySet().iterator();
    		 	while(it.hasNext())
    		 	{
    		 		Matrix m=it.next().getKey();
    		 		if(m.x>=x1&&m.x<=x2&&
    	    		 		   m.y>=y1&&m.y<=y2&&
    	    		 		   m.z>=z1&&m.z<=z2
    	    		 		  )
    	    		 		{
    	    		 			 sum+=map.get(m);
    	    		 		}	
    		 		
    		 	}
    		 	
    		 	
    		 	
    		 	System.out.println(sum);
    		 	result.add(sum);
    		 	 continue;
    		  }//end "QUERY"
    		
    		}//end switch		
    		
    	}//end for operation
    	
        return result;
    }

}

public class CubeSummation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int matSize = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<String> ops = IntStream.range(0, m).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                List<Long> res = CubeSummationResult.cubeSum(matSize, ops);

        
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
