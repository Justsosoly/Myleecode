package Mytest;

public class BinarySearch {
	
	
	public static void main(String args[])
	{
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 , 10, 11, 12,13,14,15,16,17,19,20,21,22};
		int n=arr.length;
		
	//	System.out.println("find the target"+binarySearch(arr,15, 0,n-1));
		
		System.out.println("find the target while"+binarySeachWhile(arr,18, 0,n-1));		
		
		
	}
	
	//recursion
	static int binarySearch(int arr[], int target,int left,int right)
	{
		int mid=(left+right)/2;
		
		if(left>right) return -1;
		
		
		if(target<arr[mid])
			
		return binarySearch(arr,target,left,mid-1);
	
		else if(target>arr[mid])
		
		    return binarySearch(arr,target,mid+1,right);
		else return arr[mid];
		
		
	}
	
	//while
	static int binarySeachWhile(int arr[],int target,int left,int right)
	{
		
		
		while(left<=right)
		{
			int mid=(left+right)/2;
			
			if(target>arr[mid])//right area
			{
				left=mid+1;
			}
			if(target<arr[mid])//left area
			{
				right=mid-1;
			}	
			else if(target==arr[mid]) return arr[mid];
			
		}
		
		
		
      return -1;		
	}

}
