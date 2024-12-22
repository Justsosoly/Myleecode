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



class SearchSuggestionSystemResult {

    /*
     * Complete the 'getProductSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY products
     *  2. STRING search
     */

    public static List<List<String>> getProductSuggestions(List<String> products, String search) {
    // Write your code here
    	
    	List<List<String>> resultAll=new ArrayList<List<String>>();
    	
    	
    	Collections.sort(products);
    	
    	List<String> subproducts=products;
    	
    	for(int i=0;i<search.length();i++)
    	{
    		
    	  String s=String.valueOf(search.charAt(i));
    	  List<String> result=new ArrayList<String>();
    	  int n=0;
    	  
    	 
    	  
    	  if(subproducts.size()>0)
    	  {
    	 
    		  for(int j=0;j<products.size();j++)
    			  
    			  
    	  {
    		  
    		 String product_name= products.get(j);
    		 String product_name_char="";
    		 if(product_name.length()>i)
    		  product_name_char=String.valueOf(product_name.charAt(i));
    		 
    		
    		 if(s.contentEquals(product_name_char))
    		  {
    			
    			 if(result.size()<3)
        		 {
    			 System.out.print(product_name+" ");
    			 result.add(product_name);
        		 }
    		  }
    		 else
    		 {
    			 subproducts.remove(j);
    		    j--;
    		 }
    		 
    	  }
    	
    	  System.out.println();
    		
    		if(!result.isEmpty())
    	  resultAll.add(result);
    	}//if
    	}
    	
    	
    	
    	
        return resultAll;
    }

}

public class SearchSuggestionSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> products = IntStream.range(0, productsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String search = bufferedReader.readLine();

        List<List<String>> result = SearchSuggestionSystemResult.getProductSuggestions(products, search);

        /*
        result.stream()
            .map(
                r -> r.stream()
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
    */
        bufferedReader.close();
    }
}
