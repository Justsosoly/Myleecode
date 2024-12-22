package Mytest;




import java.io.*;
import java.util.*;

public class MinimumTimeRequired {

    // Complete the minTime function below.
	//pass all the test
	
    static long minTime(long[] machines, long goal) {
        
        long day=0;
        int n=machines.length;
        Arrays.sort(machines);
     
        long leftday=0;
        long rightday=machines[n-1]*goal;
       
        while (leftday<rightday)
        {
            
          long midday=(leftday+rightday)/2;
          // System.out.println("mid day="+midday);
       
          long midpnum=0;
          long rightnum=0,leftnum=0;
          for(int i=0;i<n;i++)
          {
             midpnum+= midday/machines[i];
          }

          if(goal<midpnum)
          {
             rightday=midday-1; // roll the right to middle  
              
             for(int i=0;i<n;i++)
               {
              
              rightnum+= rightday/machines[i];
               }
               if(rightnum<goal) return rightday+1;
             
          }
          
          if(goal>midpnum)
          {
              leftday=midday+1;// roll the left to middle
          }  
          
          if(goal==midpnum)
          {
            
             while(true)
             {
               
               midday--; 
               long sum=0;
                for(int i=0;i<n;i++)
             {
              sum+= midday/machines[i];
             }

            if(sum<goal)
               return midday+1;
             }
          }
           day=leftday;
        }
        return day;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);



        scanner.close();
    }
}
