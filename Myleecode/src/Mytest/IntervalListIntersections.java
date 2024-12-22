package Mytest;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
	
	
	
	
	
	/*
	 firstList = [[0,2],[5,10],[13,23],[24,25]], 
	 secondList = [[1,5],[8,12],[15,24],[25,26]]
     Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     
     Input: firstList = [[1,3],[5,9]], 
     secondList = []
     Output: []
	 */
	
	public static void main(String args[])
	{
		int firstList[][] =  { {0,2},{5,10},{13,23},{24,25} }; 
		
		int secondList[][] = { {1,5},{8,12},{15,24},{25,26} }; 
		
		intervalIntersection(firstList,secondList);
		
		
	}
	
	
	 static public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
	        
	        int n=  firstList.length;
	       // System.out.println("n="+n);
	        
	        int[][] result=new int[n][2];
	        
	        List<int[]> re=new ArrayList<>();
	             
	        int m=  secondList.length;
	      //  System.out.println("m="+m);
	        
	        int i=0,j=0;
	        
	        while(i<n&&j<m)
	        {
	            
	        	int start1=firstList[i][0];
	            int end1=firstList[i][1];
	            
	            int start2=secondList[j][0];
	            int end2=secondList[j][1];
	            
	            int start=0;
	            int end=0;
	            
	            start=Math.max(start1, start2);
	            end=Math.min(end1, end2);
	            
	            if(start<=end)
	            {
	            	re.add(new int[] {start,end});
	            }
	            if(end==end1) i++;
	            if(end==end2) j++;
	                
	            
	        }
	        
	        result=re.toArray(new int[re.size()][2]);
	        
	        return result;
	    }

}
