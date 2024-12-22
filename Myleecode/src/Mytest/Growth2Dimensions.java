package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Growth2DimensionsResult {

    /*
     * Complete the 'countMax' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING_ARRAY upRight as parameter.
     */
	
	
	public static long countMax(List<String> upRight) {
		
		long result=0;
		
		int n=upRight.size();
		
		int minrow=Integer.MAX_VALUE;
		int mincol=Integer.MAX_VALUE;
		
		
		for(int i=0;i<n;i++)
		{
		  String  con[]=upRight.get(i).split(" ");
		  
		  int row=Integer.valueOf(con[0]);
		  int col=Integer.valueOf(con[1]);
		  if(row<minrow)
			  minrow=row;
		  if(col<mincol)
			  mincol=col;
			
		}
		
		result=mincol*minrow;
		return result;
		
	}
	

    public static long countMax2(List<String> upRight) {
        long result=0;
        int minrow=Integer.MAX_VALUE;
        int mincol=Integer.MAX_VALUE;
     //   int arr[][]=new int[101][101];
        
        for(int i=0;i<upRight.size();i++)
        {
           String element= upRight.get(i);
           
           String temp[]=element.split(" ");
           int r=Integer.valueOf( temp[0] );
           if(r<minrow)
        	   minrow=r;
            
           int c=Integer.valueOf(  temp[1]  );
            if(c<mincol)
        	  mincol=c;
            //System.out.println("element "+element+" r "+r+" c "+c); 
            
          /*
            for(int k=1;k<=r;k++)
               for(int j=1;j<=c;j++)
                arr[k][j]=arr[k][j]+1;
           */ 
        }
        /*
       int max=0;
       int count=0;
       for(int i=1;i<=maxrow;i++)
         for(int j=1;j<=maxcol;j++)
           {
         
             
             if(arr[i][j]>max) 
               {
                 count=0;
                 max=arr[i][j];  
                 System.out.println("max "+max);
               }
                if(arr[i][j]==max)
                   count++;
               
           }
        result=count;
        */
        result=minrow*mincol;
        return result;
    }

}

public class Growth2Dimensions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int upRightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> upRight = IntStream.range(0, upRightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        long result = Growth2DimensionsResult.countMax(upRight);


        bufferedReader.close();
    }
}
