package Mytest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class IBMTest {

	
	public static void main(String args[])
	{
		
		List<String> request=new ArrayList<>();
		
		
		request.add("www.xyz.com");
		request.add("www.xyz.com");
		request.add("www.abc.com");
		request.add("www.xyz.com");
		request.add("www.pqr.com");
		request.add("www.abc.com");
		request.add("www.xyz.com");
		request.add("www.xyz.com");
		request.add("www.abc.com");
		request.add("www.xyz.com");
		
		responseGateWay(request);
		
	}
	
	public static List<String> responseGateWay(List<String> request)
	{
		List<String> result=new ArrayList<>();
		
		
		int n=request.size();
	
		
		Deque<String> que=new LinkedList<>();
		
		for(int i=0;i<n;i++) //i就是时间，i++就是时间流逝
		{
			
			String str=request.get(i);
		
			System.out.println(str);
			 
			int count=0;
			
			String response="status: 200,message: OK";
			
			
			
			if(que.size()<5)  //队列小于5的时候
			{
				que.add(str);
			}
			else
			{
				que.removeFirst();
				que.add(str);
			}	
			
			
			
			
			
			Iterator<String> it = que.iterator(); 
		
			while(it.hasNext())
			{	
				String temp=it.next();
				
				if(temp.equals(str))
				{
					count++;
				}
			}//end for j
			if(count>2)
			{
				response="status: 429,message: Too many requests";
				que.removeLast();
				que.add("False");
			}
			
			
			System.out.println(response);
			result.add(response);
			
		}//end for i
		
		
		
		return result;
		
	}
	
	
	
	
}
