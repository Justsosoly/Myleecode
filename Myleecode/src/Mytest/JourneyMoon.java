package Mytest;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class JourneyMoonResult {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
    // Write your code here
      int result=0;
      List<List<Integer>> country=new ArrayList<List<Integer>>();
      
      for(int i=0;i<astronaut.size();i++)
      {
    	  List<Integer> pairlist=astronaut.get(i);
    	  int first=pairlist.get(0);
    	  int second=pairlist.get(1);
    	  
    	  if(country.isEmpty())
    	  {
    		  country.add(pairlist);
    	  }
    	  else//iterator  the country list to insert or add
    	  {
    		  int count=0;
    		  for(int j=0;j<country.size();j++)
    		  {
    			  List<Integer> templist=country.get(j);
    			  if(templist.contains(first)&&!templist.contains(second))
    			  {
    				  country.get(j).add(second);
    				  continue;
    			  }
    			  if(templist.contains(second)&&!templist.contains(first))
    			  {
    				  country.get(j).add(first);
    				  continue;
    			  }
    			  count++;
    		  }
    		  if(count==country.size())
    		  {
    			  country.add(pairlist);
    		  }
    	  }	  
        }
      int sum=0;
      for(int y=0;y<country.size();y++)
      {
         sum+=country.size();
      }
      
      
      if(country.size()>1&&sum==n)
      {
    	  for(int x=1;x<country.size();x++)
          {
    		 int   temp=  country.get(x).size()*country.get(x-1).size();
    		 result+=temp;
          } 
      }
      
      else
      {
    	  for(int x=1;x<country.size();x++)
          {
    		 int   temp=  country.get(x).size()*country.get(x-1).size()*(n-sum);
    		 result+=temp;
          } 
    	  
    	  
      }
      
      return result;	
    }

}

public class JourneyMoon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = JourneyMoonResult.journeyToMoon(n, astronaut);


        bufferedReader.close();
    }
}
