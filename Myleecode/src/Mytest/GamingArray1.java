package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class GamingArray1Result {

    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
	
	
	//passed all the test
	
	  public static String gamingArray(List<Integer> arr) {
		  
		  int max=Integer.MIN_VALUE;
		  
		  

		  int count=0;
		  for(int i=0;i<arr.size();i++)
		  {
			  if(arr.get(i)>=max) 
			  {
				  max=arr.get(i);
				  count++;
			  }
		  }
		  
		  if(count%2==0)
		      return "ANDY";
		      else
		        return "BOB";
	  }

	  
	  
	  //first write code ,fail some test, time limits
	  //for example an arr has 10w element and ascend
	  
    public static String gamingArray2(List<Integer> arr) {
    // Write your code here
       int count=0;
       while(arr.size()>0)
       {
         Integer max=Collections.max(arr);
         System.out.println("max is :"+max);
          int max_index= arr.indexOf(max);
         System.out.println("max_index is :"+max_index);
         if(max_index>=0)
         {
          arr=arr.subList(0, max_index);
        
           count++;
           
           
         }
          else
          break;//
      
       }
      System.out.println("count :"+count);
      if(count%2==0)
      return "ANDY";
      else
        return "BOB";
    }

}

public class GamingArray1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = GamingArray1Result.gamingArray(arr);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
