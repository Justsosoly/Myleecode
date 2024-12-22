package Mytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExclusiveTimeofFunctions {
	
	
	
	 public static void main(String[] args) throws IOException {
	        
		 
		 List<String> logs=new ArrayList<>();
		 
		 //Test 1
		
		 int n=2;
		 logs.add("0:start:0");
		 logs.add("1:start:2");
		 logs.add("1:end:5");
		 logs.add("0:end:6");
		 
		//Test 2 "0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"
		 /*
		 int n=1;
		 logs.add("0:start:0");
		 logs.add("0:start:2");
		 logs.add("0:end:5");
		 logs.add("0:start:6");
		 logs.add("0:end:6");
		 logs.add("0:end:7");
		 */
		 
		 exclusiveTime(n,logs);
		 
	    }
	
	public static int[] exclusiveTime(int n, List<String> logs) {
        
        int result[]=new int[n];
        Map<String, Integer> timemap=new HashMap<>();

        Deque<Task> stack=new LinkedList<Task>();
       
        int prettime=0;//上一个任务完成的位置，最后的时间标示
       
        
        for(int i=0;i<logs.size();i++)
        {
          
          Task cur_task=new Task();
          String cur_log=logs.get(i);
          
          String []cur=  cur_log.split(":");


          cur_task.id=cur[0];
          cur_task.flag=cur[1];
          cur_task.index=cur[2];
           
          System.out.println("id="+cur_task.id+" flag="+cur_task.flag+" index="+cur_task.index);
           
           
           int spendtime=0;
           
           if(cur_task.flag.equals("start"))//push to the stack 
           {
               
               if(stack.isEmpty()) //first task push to the stack,do nothing
               {
            	   
               }
               else  // if there had task, caculator the last task time
               {
            	   
            	   Task lasttask=stack.peek();
            	   
            	   spendtime= Integer.parseInt(cur_task.index) -prettime;
            	  
            	   result[Integer.parseInt(lasttask.id)]+=spendtime;
            	   prettime=Integer.parseInt(cur_task.index);
            	   
               }	   
               System.out.println("push"+" id="+cur_task.id+" flag="+cur_task.flag+" index="+cur_task.index);
               stack.push(cur_task);  
           }
            
            if(cur_task.flag.equals("end"))//pop  the top element of the stack
           {
            //  Task starttask= stack.pop(); //the start task
            	stack.pop();
            //  String startTime=starttask.index;
          //    String startId=starttask.id;
          //    System.out.println("pop"+" endId="+cur_task.id+" endTime="+cur_task.index);
                
              // if(startId==task.id)//the same task
               spendtime=Integer.parseInt(cur_task.index)-prettime+1;
              
             if(result[Integer.parseInt(cur_task.id)]==0)
              result[Integer.parseInt(cur_task.id)]+=spendtime;
             
             else
            	 
             result[Integer.parseInt(cur_task.id)]+=spendtime;
             
             prettime=Integer.parseInt(cur_task.index)+1;
           } 
        }

        return result;
  }

}



 class Task
  {
     String id;
     String flag;
     String index;

  }
