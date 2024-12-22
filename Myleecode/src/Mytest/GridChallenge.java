package Mytest;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class GridChallengeResult {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

	
	 public static void gridChallengetest(List<String> grid) {
		 
		 int n=grid.size();
		 List<String> newgrid=new ArrayList<String>();
			
		
		 
		 
		 for(int i=0;i<n;i++)
		 {
			 String temp=grid.get(i);
			 char strtemp[]=temp.toCharArray();
			 Arrays.sort(strtemp);
			 
			 String sortstr=new String(strtemp);
			 
			 newgrid.add(sortstr);
			 
			 
		 }
		 

		 
		 System.out.println(newgrid);
		 
		 
	 
	 }
	
	
	
    public static String gridChallenge(List<String> grid) {
    // Write your code here
    	gridChallengetest(grid);
    	
    List<String> newgrid=new ArrayList<String>();
    int n=grid.size();
    boolean flag=true;
    if(n==1) return "YES";
      for(int i=0;i<n;i++)
      {
        String s=grid.get(i);
        char[] strarray=s.toCharArray();
        Arrays.sort(strarray);
        String newstr=new String(strarray);
        newgrid.add(newstr);
        System.out.println(newstr);
      }
      
      for(int x=0;x<n-1;x++)
        {
          String pre=newgrid.get(x);
          String post=newgrid.get(x+1);
          
          for(int y=0;y<pre.length();y++)
          {
        	  System.out.println(pre.charAt(y));
        	  System.out.println(post.charAt(y));
          if(pre.charAt(y)>post.charAt(y))
            {
        	
        	  flag=false;
            System.out.println("NO");
            return "NO";
             }
          }
        }
      
      System.out.println("YES");
      return "YES";
    }

}

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> grid = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String gridItem = bufferedReader.readLine();
                grid.add(gridItem);
            }

            String result = GridChallengeResult.gridChallenge(grid);

        }

        bufferedReader.close();
    }
}
