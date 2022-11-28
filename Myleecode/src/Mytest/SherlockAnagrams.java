package Mytest;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.*;


class SherlockAnagramsResult {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
    	
    // Write your code here
    	
    	int result=0;
    	/*
    	 HashMap<String,Integer> word=new HashMap<String,Integer> ();
    	
    	
    	 for(int i=0;i<s.length();i++)
    		 
    	 {
    		 int index=1;
    		 String temp=String.valueOf(s.charAt(i));
    		 
    		 if(word.get(temp)==null)
    		 {
    			 word.put(temp, index);
    			 index++;
    		 }
    		 
    		 else
    		 {
    		     int num=(int)word.get(temp)+1;
    			 word.replace(temp, num);
    		 }
    	 }
    	 
    	 for(String key :word.keySet())
    	 {
    		 
    		 int value=word.get(key);
    		 result+=(value*(value-1))/2;
    		 
    	 }
    	 
    	 System.out.println(result);
    	 
    	 */
    	
    	 HashMap<String, Integer> map= new HashMap<>();
    	 
         for(int i = 0; i < s.length(); i++){
             for(int j = i; j < s.length(); j++){
                 char[] valC = s.substring(i, j+1).toCharArray();
                 Arrays.sort(valC);
                 String val = new String(valC);
                 if (map.containsKey(val))
                     map.put(val, map.get(val)+1);
                 else
                     map.put(val, 1);
             }
         }
         int anagramPairCount = 0;
         for(String key: map.keySet()){
             int n = map.get(key);
             anagramPairCount += (n * (n-1))/2;
         }
         System.out.println(anagramPairCount);
     
    	
    	
    	 
         return result;
         
    }

}

public class SherlockAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = SherlockAnagramsResult.sherlockAndAnagrams(s);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
