package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;



class TruckTourResult {

    /*
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    public static int truckTour(List<List<Integer>> petrolpumps) {
    // Write your code here
    	
           int petrolsum=0;
           int pumpnum=petrolpumps.size();
   
           int start=0;
           int end=0;
           
          while (petrolsum>=0)//have petrol to go a circle
           {
        	 
        	  petrolsum+=petrolpumps.get(end).get(0);
        	  
        	   petrolsum=petrolsum-petrolpumps.get(end).get(1);
        	  
        	    if(petrolsum>=0)
                  {
                 
        		  end=(end+1)%pumpnum;   //这个加油站可以继续往后走一站
        		    if(end==start)      //相同，则说明可以走一圈
        		    	return start;
        		  
                  }
                  else       //说明汽油不够，从下一个加油站开始
                  {
                  start=(start+1)%pumpnum;
                  end=start;
                  petrolsum=0;
                 
                  }
                 
        	  
           }
           return -1;
    }

}

public class TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = TruckTourResult.truckTour(petrolpumps);

;

        bufferedReader.close();
    }
}
