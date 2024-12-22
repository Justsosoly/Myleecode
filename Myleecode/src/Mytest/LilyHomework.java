package Mytest;



import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class LilyHomeworkResult {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int checkSorted(List<Integer> arr, boolean isCheckingAsc) {
    int res = 0;
    int n = arr.size();
    
    TreeMap<Integer, Integer> map;
    if (isCheckingAsc) {
        map = new TreeMap<>();
    }
    else {
        map = new TreeMap<>(Comparator.reverseOrder());
    }
    
    for (int i = 0; i < n; i++) {
        int a = arr.get(i);
        map.put(a, i);
    }
    
    int index = 0;// the index start from 0 of arr list, initial sequence
    int[] buffer = new int[n];

    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        int key = e.getKey();// the elment of the sorted arr list
        int val = e.getValue();// the sepcific positon index in arr list
        int toSwap = arr.get(index);//  the element  from arr list, initial sequence
        
        if (buffer[index] != 0) {
            toSwap = buffer[index];
        }
        
        if (val != index) {//sorted map compare from the arr list, compare the specific index
            map.put(toSwap, val);  // modify the map
            
            buffer[index] = key;
            buffer[val] = toSwap;     
            
            res++;
        }
        index++;
    }
    
    return res;
}

public static int lilysHomework2(List<Integer> arr) {

    int countAsc = checkSorted(arr, true);
    int countDsc = checkSorted(arr, false);
    
    return Math.min(countAsc, countDsc);
}







//use the Array to sort,can't pass all the test3 - test9, time limits

//use the maptree,can't pass all the test3 - test9,time limits,too

//don't use the list to deal the swap ,use the array[]
public static int lilysHomework(List<Integer> arr) {
	
	int result=0;
	int ascresult=0;
	int descresult=0;
	int n=arr.size();
	
    Integer origial[]=new  Integer[n];
    
    origial=arr.toArray(new Integer[n]);
    
	
	ascresult=swapResult(arr,true);
	
    arr=Arrays.asList(origial);
	
	descresult=	swapResult(arr,false);
	
	result=Math.min(ascresult, descresult);
	
	
	return result;
}

//public static int swapResult( arr[],boolean flag)
  public static int swapResult(List<Integer> arr,boolean flag)
  {
	  
	  

      int result=0;
    
      int n=arr.size();
      
      Integer sortarr[]= new Integer[n];
 
      
      TreeMap<Integer,Integer> treemap;
      
      
      if(flag)
      {
    	  treemap =new TreeMap<>();
      }
      else
      {
    	  treemap =new TreeMap<>(Collections.reverseOrder());
      }    
      
      
      
      for(int j=0;j<n;j++)
      {
    	  
    	  int x=arr.get(j);
    	  
    	  treemap.put(x, j);
    	  
      }
      
      
      
   // for(int i=0;i<n;i++)
      int i=0;
    
      for(Integer y:treemap.keySet())
      
      {
          
          int x=arr.get(i);
          int swapindex=arr.indexOf(y);
        
          
          if(x!=y)
          {   
        	 
              arr.set(i,y);
              arr.set(swapindex,x);
              result++;
          }

          i++;
      }//end for i
    
    

    
    return result;
    
	  
  }


   
}

public class LilyHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = LilyHomeworkResult.lilysHomework(arr);

        bufferedReader.close();
    }
}
