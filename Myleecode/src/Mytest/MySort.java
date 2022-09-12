package Mytest;

public class MySort {
	
	
	public static void quickSort(int[]arr,int low,int high)
	{
		
		
		
	    if(low>high) return ;
	    int index=arr[low];
	    int i=low;
		int j=high;
		while(i<j)
		{
			while(i<j&&index<=arr[j])
			{
				j--;
			}
			
			while(i<j&&index>=arr[i])
			{
				i++;
			}
			
			if(i<j)
			{
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
			
		}
		arr[low]=arr[i];
		arr[i]=index;
		
		quickSort(arr,low,j-1);
		quickSort(arr,j+1,high);
		
		
		
		
	}
	
	
	
	public static void main(String args[])
	{
		int arr[]= {6,1,2,7,9,3,4,5,10,8};
		int low=0;
		int high=arr.length-1;
		quickSort(arr,low,high);
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
	}
	

}
