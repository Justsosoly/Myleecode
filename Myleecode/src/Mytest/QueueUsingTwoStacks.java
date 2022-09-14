package Mytest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class QueueUsingTwoStacks {
	
	
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();
		int type;
		Deque<Integer> queue=new LinkedList<>();
		

		
		
		for(int i=0;i<q;i++)
		{
			type=sc.nextInt();
			
			switch(type)
			{
			case 1:
				queue.addLast(sc.nextInt());
				break;
				
			case 2: 
				
				queue.pollFirst();
				break;
			case 3:
				
				System.out.println(queue.getFirst());
				break;
			}
			
		}
		
		
		
	}
	

}
